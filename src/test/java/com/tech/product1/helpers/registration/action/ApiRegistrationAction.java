package com.tech.product1.helpers.registration.action;

import com.tech.common.apiTestHelper.ApiAutomationHelper;
import org.springframework.stereotype.Service;

@Service
public class ApiRegistrationAction extends ApiAutomationHelper implements RegistrationAction {

    @Override
    public String doRegistration() {
        System.out.println("Registration SMOKE.");
        return "Registration SMOKE.";
    }
}