package com.tech.registration;

import com.tech.enums.Platform;
import org.springframework.stereotype.Service;

@Service
public class RegistrationAppService extends RegistrationAPI {

    public Platform getPlatform() {
        return Platform.APP;
    }

    @Override
    public String doRegistration() {
        System.out.println("Registration APP.");
        return "Registration APP.";
    }
}
