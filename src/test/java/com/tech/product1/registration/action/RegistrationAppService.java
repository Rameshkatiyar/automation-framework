package com.tech.product1.registration.action;

import org.springframework.stereotype.Service;

@Service
public class RegistrationAppService extends RegistrationAction {

    @Override
    public String doRegistration() {
        System.out.println("Registration APP.");
        return "Registration APP.";
    }
}
