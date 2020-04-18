package com.tech.product1.login.action;

import com.tech.common.webTestHelper.WebAutomationHelper;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginWebService extends WebAutomationHelper implements LoginAction {

    public int doLoginAndGetStatus(String username, String password) {
        System.out.println("Login facebook Web.");
        WebDriver driver = seleniumService.getWebDriver(BrowserType.CHROME, null);
        driver.get("https://www.facebook.com/");
        String title = driver.getTitle();
        log.info("Facebook title: {}", title);
        return 200;
    }
}
