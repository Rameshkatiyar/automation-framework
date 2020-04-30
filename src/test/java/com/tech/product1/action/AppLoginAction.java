package com.tech.product1.action;

import com.tech.commonHelper.appTestHelper.AppAutomationHelper;
import com.tech.enums.Platform;
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

    @Override
    public Platform getPlatformType() {
        return Platform.APP;
    }
}
