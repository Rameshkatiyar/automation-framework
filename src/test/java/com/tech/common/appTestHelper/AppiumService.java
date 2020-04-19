package com.tech.common.appTestHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.windows.WindowsDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Map;

@Slf4j
@Service
public class AppiumService {

    private AppiumDriver<MobileElement> driver;

    /**
     * Get the Appium driver.
     * @param mobilePlatform
     * @param appiumServerUrl
     * @param capabilityNameValueMap
     * @return
     */
    public AppiumDriver<MobileElement> getAppiumDriver(String mobilePlatform,
                                                       String appiumServerUrl,
                                                       Map<String, String> capabilityNameValueMap){
        Capabilities capabilities = getDesiredCapabilities(capabilityNameValueMap);
        try {
            URL serverUrl = new URL(appiumServerUrl); //Appium Server URL;

            if (mobilePlatform.equals(MobilePlatform.IOS)){
                driver = new IOSDriver<MobileElement>(serverUrl, capabilities);
            }
            else if (mobilePlatform.equals(MobilePlatform.ANDROID)){
                driver = new AndroidDriver<MobileElement>(serverUrl, capabilities);
            }
            else if (mobilePlatform.equals(MobilePlatform.WINDOWS)){
                driver = new WindowsDriver<MobileElement>(serverUrl, capabilities);
            }

            return driver;
        } catch (Exception e) {
            log.error("Not able to connect with appium server. {}", e.getMessage());
        }
        return null;
    }

    /**
     * Quits this driver, closing every associated window.
     * @return
     */
    public boolean teardown() {
        if (this.driver != null) {
            this.driver.quit();
            return true;
        }
        log.info("Driver is null. {}", driver);
        return false;
    }

    /**
     * DesiredCapability = AboutDevice + AboutApplication
     * @param capabilityNameValueMap
     * @return
     */
    private DesiredCapabilities getDesiredCapabilities(Map<String, String> capabilityNameValueMap){
        DesiredCapabilities cap = new DesiredCapabilities();

        capabilityNameValueMap.keySet().stream()
                .forEach(
                        key -> cap.setCapability(key, capabilityNameValueMap.get(key))
                );

        return cap;
    }
}
