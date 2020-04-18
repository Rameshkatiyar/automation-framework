package com.tech.common.webTestHelper;

import com.tech.config.ConfigProperties;
import com.tech.enums.Environment;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

@Slf4j
@Service
public class SeleniumService {

    @Autowired
    private ConfigProperties configProperties;

    private WebDriver driver;

    /**
     * @param browserType
     * @param capabilityNameValueMap: Set the "browser_version" in capabilities for local testing. If not it will take default version.
     * @return
     */
    public WebDriver getWebDriver(String browserType, Map<String, String> capabilityNameValueMap){
        Environment environment = configProperties.getEnvironment();
        if (environment.equals(Environment.BROWSERSTACK)){
            return getBrowserStackWebDriver(capabilityNameValueMap);
        }else {
            return getLocalWebDriver(browserType);
        }
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
     * By default it will run on latest and proper version of browser. Managed by WebDriverManager.
     * @param browserType
     * @return
     */
    private WebDriver getLocalWebDriver(String browserType){
        log.info("Connecting with local webdriver using WebDriverManager.");
        if (browserType.equals(BrowserType.CHROME)){
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        }
        else if (browserType.equals(BrowserType.FIREFOX)){
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();
        }
        else if (browserType.equals(BrowserType.IE)){
            WebDriverManager.iedriver().setup();
            this.driver = new InternetExplorerDriver();
        }
        else {
            log.error("Given browser type {} is not supported by this framework.", browserType);
        }
        return driver;
    }

    /**
     * Open browser on browser stack side.
     * @param capabilityNameValueMap
     * @return
     */
    private WebDriver getBrowserStackWebDriver(Map<String, String> capabilityNameValueMap){
        String url = configProperties.getSeleniumBrowserstackUrl();
        try {
            log.info("Connecting with browser stack webdriver.");
            this.driver = new RemoteWebDriver(new URL(url), getDesiredCapabilities(capabilityNameValueMap));
        } catch (MalformedURLException e) {
            log.error("Error in browser stack url. {}", e.getMessage());
        }
        return driver;
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
