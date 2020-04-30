package com.tech.product1.action;

import com.tech.commonHelper.apiTestHelper.ApiAutomationHelper;
import com.tech.enums.Platform;
import org.springframework.stereotype.Service;

@Service
public class ApiRegistrationAction extends ApiAutomationHelper implements RegistrationAction {

    @Override
    public String doRegistration() {
        System.out.println("Registration SMOKE.");
        return "Registration SMOKE.";
    }

    @Override
    public Platform getPlatformType() {
        return Platform.API;
    }

    @Override
    public String getBaseURI() {
        return testUrlConfig.getFacebookApiUrl();
    }
}
