package com.tech.commonHelper.appTestHelper;

import com.tech.config.AppConfig;
import com.tech.utils.CommandUtil;
import com.tech.utils.JsonUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobilePlatform;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
@Service
public class BrowserStackService {
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private JsonUtil jsonUtil;

    @SuppressWarnings("rawtypes")
    private AppiumDriver driver;

    public String uploadAppBinaryOnBrowserStack(String appBinaryName){

        File appBinaryPath = new File(appConfig.getLocalAppBinaryPath().concat(appBinaryName));

        String command = "curl -u "
                + appConfig.getBrowserStackUserName()
                +":"+ appConfig.getBrowserStackAccessKey()
                +" -X POST https://api-cloud.browserstack.com/app-automate/upload -F file=@"
                +appBinaryPath;

        String response = CommandUtil.executeCommand(command);

        return jsonUtil.getJsonToKeyValueMap(response).get("app_url");
    }


    public AppiumDriver getAppiumDriver(MobileCapabilities mobileCapabilities) {
        DesiredCapabilities caps = mapDesiredCapabilities(mobileCapabilities);
        String platform = mobileCapabilities.getPlatform();
        URL remoteAddress = getRemoteAddress();

        if (platform.equalsIgnoreCase(MobilePlatform.ANDROID)){
            this.driver = new AndroidDriver<AndroidElement>(remoteAddress, caps);
            log.info("Initialize Android Driver: {}", this.driver);
        }
        else if (platform.equalsIgnoreCase(MobilePlatform.IOS)){
            this.driver = new IOSDriver<IOSElement>(remoteAddress, caps);
            log.info("Initialize IOS Driver: {}", this.driver);
        }
        else {
            this.driver = null;
            log.error("Initialize Driver: {}", this.driver);
        }
        return driver;
    }

    private DesiredCapabilities mapDesiredCapabilities(MobileCapabilities mobCaps) {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", mobCaps.getDevice());
        caps.setCapability("os_version", mobCaps.getOsVersion());
        caps.setCapability("project", mobCaps.getProject());
        caps.setCapability("name", mobCaps.getTestName());
        caps.setCapability("build", "Build");
        caps.setCapability("app", mobCaps.getAppUrl());

        return caps;
    }

    private URL getRemoteAddress(){
        URL remoteAddress = null;
        try {
            remoteAddress = new URL(
                    "https://"
                            + appConfig.getBrowserStackUserName()
                            + ":"
                            + appConfig.getBrowserStackAccessKey()
                            + "@hub-cloud.browserstack.com/wd/hub"
            );
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
        }
        return remoteAddress;
    }


}
