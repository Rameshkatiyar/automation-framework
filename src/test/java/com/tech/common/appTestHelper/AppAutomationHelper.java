package com.tech.common.appTestHelper;

import com.tech.config.TestConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobilePlatform;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public abstract class AppAutomationHelper {

    @Autowired
    protected AppiumService appiumService;
    @Autowired
    protected TestConfig testConfig;

    protected AppiumDriver<MobileElement> driver;

    public void connectWithAppiumServer() {
        driver = appiumService.getAppiumDriver(
                getMobilePlatform(),
                testConfig.getAppiumServerUrl(),
                getCapabilityNameValueMap()
        );
    }

    protected abstract MobilePlatform getMobilePlatform();
    protected abstract Map<String, String> getCapabilityNameValueMap();


}
