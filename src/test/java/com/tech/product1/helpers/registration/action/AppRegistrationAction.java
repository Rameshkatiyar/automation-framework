package com.tech.product1.helpers.registration.action;

import com.tech.common.appTestHelper.AppAutomationHelper;
import io.appium.java_client.remote.MobilePlatform;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AppRegistrationAction extends AppAutomationHelper implements RegistrationAction {

    public String doRegistration() {
        System.out.println("Registration ACCEPTANCE.");
        return "Registration ACCEPTANCE.";
    }

    @Override
    protected MobilePlatform getMobilePlatform() {
        return null;
    }

    @Override
    protected Map<String, String> getCapabilityNameValueMap() {
        return null;
    }
}
