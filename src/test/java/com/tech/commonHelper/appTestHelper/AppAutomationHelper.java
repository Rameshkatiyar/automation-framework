package com.tech.commonHelper.appTestHelper;

import com.tech.config.AppConfig;
import com.tech.enums.Environment;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AppAutomationHelper {

    @Autowired
    protected LocalAppTestService localAppTestService;
    @Autowired
    protected BrowserStackService browserStackService;
    @Autowired
    protected DeviceFarmService deviceFarmService;
    @Autowired
    protected AppConfig appConfig;
    @Autowired
    protected BaseAppPage baseAppPage;

    protected String mobilePlatform;
    protected String appUrl = Strings.EMPTY;

    @SuppressWarnings("rawtypes")
    protected AppiumDriver driver;

    public void installApp(){
        //For BS
        this.appUrl = browserStackService.uploadAppBinaryOnBrowserStack(appConfig.getAppBinaryName());
        log.info("App installed. Url: {}", this.appUrl);
        //For Local
        //TODO: Install Manually in mobile.
    }

    public AppiumDriver openApp() {
        MobileCapabilities mobileCapabilities = getMobileCapabilities();
        Environment environment = appConfig.getAppEnvironment();
        this.mobilePlatform = appConfig.getAppPlatform();
        String appiumServerUrl = appConfig.getAppiumServerUrl();

        if (environment.equals(Environment.LOCAL)){
            log.info("Initializing the Local Appium Server: {}", mobileCapabilities);
            this.driver = localAppTestService.getAppiumDriver(mobileCapabilities, appiumServerUrl);
        }else if (environment.equals(Environment.BROWSERSTACK)){
            log.info("Initializing the BrowserStack API: {}", mobileCapabilities);
            this.driver = browserStackService.getAppiumDriver(mobileCapabilities);
        } else if (environment.equals(Environment.DEVICEFARM)){
            this.driver = deviceFarmService.getDriver();
        }

        baseAppPage.setDriver(driver);

        return this.driver;
    }

    public void closeApp(){
        if (this.driver != null) {
            this.driver.quit();
        }else {
            log.info("Driver is null. {}", driver);
        }
    }

    private MobileCapabilities getMobileCapabilities(){
        return MobileCapabilities.builder()
                .platform(appConfig.getAppPlatform())
                .device(appConfig.getAppDevice())
                .osVersion(appConfig.getAppOsVersion())
                .appUrl(this.appUrl)
                .project(appConfig.getAppProjectName())
                .testName(appConfig.getAppTestName())
                .appPackage(appConfig.getAppPackage())
                .appActivity(appConfig.getAppActivity())
                .udid(appConfig.getAppUdid())
                .build();
    }
}
