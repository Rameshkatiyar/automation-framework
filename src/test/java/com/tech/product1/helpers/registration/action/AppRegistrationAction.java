package com.tech.product1.helpers.registration.action;

import com.tech.common.appTestHelper.AppAutomationHelper;
import org.springframework.stereotype.Service;

@Service
public class AppRegistrationAction extends AppAutomationHelper implements RegistrationAction {

    public String doRegistration() {
        System.out.println("Registration ACCEPTANCE.");
        return "Registration ACCEPTANCE.";
    }

    @Override
    protected void setMobilePlatform() {

    }

    @Override
    protected void setCapabilityNameValueMap() {

    }
}
