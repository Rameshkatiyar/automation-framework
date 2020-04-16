package com.tech.registration;

import com.tech.enums.Platform;
import org.springframework.stereotype.Service;

@Service
public class RegistrationAPIService extends RegistrationAPI {

    public Platform getPlatform() {
        return Platform.API;
    }

    @Override
    public String doRegistration() {
        System.out.println("Registration API.");
        return "Registration API.";
    }
}
