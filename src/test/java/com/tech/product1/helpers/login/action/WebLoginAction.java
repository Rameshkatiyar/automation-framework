package com.tech.product1.helpers.login.action;

import com.tech.common.webTestHelper.WebAutomationHelper;
import com.tech.common.webTestHelper.webUtils.WebWaitService;
import com.tech.product1.helpers.login.pages.LoginPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WebLoginAction extends WebAutomationHelper implements LoginAction {

    @Autowired
    private LoginPage loginPage;

    public final String LOGIN_URL = "/login";

    public int doLoginAndGetStatus(String username, String password) {
        openBrowser(LOGIN_URL);

        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();

        WebWaitService.waitForPageLoad(driver);
        WebElement createNewAccountButton = loginPage.getCreateNewAccountButton();
        closeBrowser();

        if (createNewAccountButton != null)
            return 300;
        else
            return 200;
    }

    @Override
    public void setBaseUrl() {
        baseURI = testUrlConfig.getFacebookWebUrl();
    }

    @Override
    public void setBrowserAndCapabilities() {
        browserType = BrowserType.CHROME;
    }
}
