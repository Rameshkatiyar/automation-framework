package com.tech.common;

import com.tech.Application;
import com.tech.config.ConfigInitializer;
import com.tech.config.ConfigProperties;
import com.tech.enums.Platform;
import com.tech.service.Platforms;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Listeners(PlatformListener.class)
@ContextConfiguration(classes = Application.class, initializers = ConfigInitializer.class)
public abstract class AutomateHelper extends AbstractTestNGSpringContextTests {
    @Autowired
    protected ConfigProperties configProperties;

    public final String SMOKE = "SMOKE";
    public final String ACCEPTANCE = "ACCEPTANCE";
    public final String REGRESSION = "REGRESSION";

    public Platform platform;

    @BeforeClass(alwaysRun = true)
    public void setConfig() {
        this.platform = configProperties.getPlatform();
        log.info("Setting the platform for: {}", platform);
        setInitialConfig();
    }

    /**
     * This method skip the test which is not eligible for the given platform in Maven -Dplatform value.
     * @param result
     */
    @BeforeMethod
    public void verifyTestEligiblePlatform(ITestResult result){
        Platforms annotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Platforms.class);
        if (null != annotation){
            List<Platform> platforms = Arrays.asList(annotation.value());
            log.info("Eligible platform {} and run at {}", platforms, platform);
            if (!platforms.contains(platform)){
                result.setStatus(ITestResult.SKIP);
                throw new SkipException("Skipping / Ignoring - Script not Ready for platform: "+platform);
            }
        }
    }

    protected abstract void setInitialConfig();
}
