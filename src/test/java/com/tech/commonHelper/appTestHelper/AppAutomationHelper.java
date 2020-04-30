package com.tech.commonHelper.appTestHelper;

import com.tech.config.TestConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobilePlatform;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public abstract class AppAutomationHelper {

    @Autowired
    protected AppiumService appiumService;
    @Autowired
    protected TestConfig testConfig;
    @Autowired
    protected BaseAppPage baseAppPage;

    protected AppiumDriver<MobileElement> driver;
    protected String mobilePlatform = MobilePlatform.ANDROID;
    protected Map<String, String> capabilityNameValueMap = new HashMap<String, String>(){{
        //About Device
        put("deviceName", "OnePlus 6");
        put("udid", "497f66d4");
        put("platformName", "Android");
        put("platformVersion", "10");

        //About Application
        put("appPackage", "com.oneplus.calculator");
        put("appActivity", "com.oneplus.calculator.Calculator");
    }};

    public void openApp() {
        setMobilePlatform();
        setCapabilityNameValueMap();

        this.driver = appiumService.getAppiumDriver(
                mobilePlatform,
                testConfig.getAppiumServerUrl(),
                capabilityNameValueMap
        );

        baseAppPage.setDriver(driver);
    }

    public void closeApp(){

    }

    protected abstract void setMobilePlatform();
    protected abstract void setCapabilityNameValueMap();


}
