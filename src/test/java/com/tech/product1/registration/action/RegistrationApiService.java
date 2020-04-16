package com.tech.product1.registration.action;

import org.springframework.stereotype.Service;

@Service
public class RegistrationApiService extends RegistrationAction {

    @Override
    public String doRegistration() {
        System.out.println("Registration API.");
        return "Registration API.";
    }
}
