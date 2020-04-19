package com.tech.product1.helpers.login.action;

import com.tech.common.appTestHelper.AppAutomationHelper;
import io.appium.java_client.remote.MobilePlatform;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AppLoginAction extends AppAutomationHelper implements LoginAction {
    @Override
    protected void setMobilePlatform() {
        mobilePlatform = MobilePlatform.ANDROID;
    }

    @Override
    protected void setCapabilityNameValueMap() {

    }

    @Override
    public int doLoginAndGetStatus(String username, String password) {
        System.out.println("Starting login on app with calculator.");
        openApp();
        return 200;
    }
}