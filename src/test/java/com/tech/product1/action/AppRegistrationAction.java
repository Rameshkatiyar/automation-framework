package com.tech.product1.action;

import com.tech.commonHelper.appTestHelper.AppAutomationHelper;
import com.tech.enums.Platform;
import org.springframework.stereotype.Service;

@Service
public class AppRegistrationAction extends AppAutomationHelper implements RegistrationAction {

    public String doRegistration() {
        System.out.println("Registration ACCEPTANCE.");
        return "Registration ACCEPTANCE.";
    }

    @Override
    public Platform getPlatformType() {
        return Platform.APP;
    }
}
