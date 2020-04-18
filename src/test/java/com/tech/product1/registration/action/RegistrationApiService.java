package com.tech.product1.registration.action;

import com.tech.common.apiTestHelper.ApiAutomationHelper;
import org.springframework.stereotype.Service;

@Service
public class RegistrationApiService extends ApiAutomationHelper implements RegistrationAction {

    @Override
    public String doRegistration() {
        System.out.println("Registration API.");
        return "Registration API.";
    }
}
