package com.tech.commonHelper.commonApi;

import com.tech.Application;
import com.tech.annotations.Platforms;
import com.tech.config.ConfigInitializer;
import com.tech.config.TestConfig;
import com.tech.enums.Platform;
import com.tech.service.TestDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@Listeners({AlterTestNgXmlListener.class, ExtentReportTestNgListener.class})
@ContextConfiguration(classes = Application.class, initializers = ConfigInitializer.class)
public abstract class TestAutomation extends AbstractTestNGSpringContextTests {
    @Autowired
    protected TestConfig testConfig;
    @Autowired
    protected TestActionResolver testActionResolver;
    @Autowired
    protected TestDataService testDataService;

    public final String SMOKE = "SMOKE";
    public final String ACCEPTANCE = "ACCEPTANCE";
    public final String REGRESSION = "REGRESSION";

    public Platform platform;

    @BeforeClass(alwaysRun = true)
    public void setConfig() {
        this.platform = testConfig.getPlatform();
        log.info("Setting the platform for: {}", platform);

        setInitialConfig();
        testDataService.initializeGenericTestData(platform);
    }

    /**
     * This method skip the test which is not eligible for the given platform in Maven -Dplatform value.
     * @param result
     */
    @BeforeMethod(alwaysRun = true)
    public void verifyTestEligiblePlatform(ITestResult result){
        Platforms annotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Platforms.class);
        if (null != annotation){
            List<Platform> eligiblePlatforms = Arrays.asList(annotation.value());
            if (!eligiblePlatforms.contains(platform)){
                result.setStatus(ITestResult.SKIP);
                log.info("{}, is skipping because of {} platform is not available for this. Eligible platform: {}", result.getMethod().getMethodName(), platform, eligiblePlatforms);
                throw new SkipException("Skipping / Ignoring - Script not Ready for platform: "+platform);
            }
        }
    }

    public Map<String, String> getTestData(String key){
        return testDataService.getData(platform, key);
    }

    protected abstract void setInitialConfig();
}
