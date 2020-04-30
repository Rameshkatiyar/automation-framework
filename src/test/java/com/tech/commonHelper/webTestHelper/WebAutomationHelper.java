package com.tech.commonHelper.webTestHelper;

import com.tech.config.TestUrlConfig;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public abstract class WebAutomationHelper {

    @Autowired
    protected TestUrlConfig testUrlConfig;
    @Autowired
    protected SeleniumService seleniumService;
    @Autowired
    protected BaseWebPage baseWebPage;

    protected WebDriver driver;
    protected String baseURI = "http://localhost:8080"; //Default URI
    protected String browserType = BrowserType.CHROME; //Default Browser
    protected Map<String, String> capabilityNameValueMap = new HashMap<String, String>(){{
        put("browser", "Chrome");
        put("browser_version", "73.0");
        put("os", "OS X");
        put("os_version", "Catalina");
        put("resolution", "1024x768");
    }};


    public abstract void setBaseUrl();
    public abstract void setBrowserAndCapabilities();

    public void openBrowser(String url){
        setBaseUrl();
        setBrowserAndCapabilities();

        this.driver = seleniumService.getWebDriver(browserType, capabilityNameValueMap);
        this.driver.get(baseURI.concat(url));

        baseWebPage.setDriver(this.driver); //IMP: It is going to set web driver in all pages.
    }

    /**
     * Quits this driver, closing every associated window.
     * @return
     */
    public boolean closeBrowser() {
        if (this.driver != null) {
            this.driver.quit();
            return true;
        }
        log.info("Driver is null. {}", driver);
        return false;
    }
}
