package com.tech.commonHelper.appTestHelper;

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
public class LocalAppTestService {

    private AppiumDriver<MobileElement> driver;

    /**
     * Get the Appium driver.
     * @param mobileCapabilities
     * @param appiumServerUrl
     * @return
     */
    public AppiumDriver<MobileElement> getAppiumDriver(MobileCapabilities mobileCapabilities,
                                                       String appiumServerUrl){
        Capabilities capabilities = mapDesiredCapabilities(mobileCapabilities);
        String mobilePlatform = mobileCapabilities.getPlatform();
        try {
            URL serverUrl = new URL(appiumServerUrl); //Appium Server URL;

            if (mobilePlatform.equals(MobilePlatform.IOS)){
                driver = new IOSDriver<>(serverUrl, capabilities);
            }
            else if (mobilePlatform.equals(MobilePlatform.ANDROID)){
                driver = new AndroidDriver<>(serverUrl, capabilities);
            }
            else if (mobilePlatform.equals(MobilePlatform.WINDOWS)){
                driver = new WindowsDriver<>(serverUrl, capabilities);
            }

            return driver;
        } catch (Exception e) {
            log.error("Not able to connect with appium server. {}", e.getMessage());
        }
        return null;
    }

    /**
     * DesiredCapability = AboutDevice + AboutApplication
     * @param mobCaps
     * @return
     */
    private DesiredCapabilities mapDesiredCapabilities(MobileCapabilities mobCaps) {
        DesiredCapabilities caps = new DesiredCapabilities();

        //About Device
        caps.setCapability("deviceName", mobCaps.getDevice());
        caps.setCapability("udid", mobCaps.getUdid());
        caps.setCapability("platformName", mobCaps.getPlatform());
        caps.setCapability("platformVersion", mobCaps.getOsVersion());

        //About Application
        caps.setCapability("appPackage", mobCaps.getAppPackage());
        caps.setCapability("appActivity", mobCaps.getAppActivity());

        return caps;
    }
}
