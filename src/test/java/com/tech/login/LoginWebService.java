package com.tech.login;

import com.tech.enums.Platform;
import org.springframework.stereotype.Service;

@Service
public class LoginWebService extends LoginAPI {
    protected Platform getPlatform() {
        return Platform.WEB;
    }

    int doLoginAndGetStatus(String username, String password) {
        System.out.println("Login through Web.");
        return 200;
    }
}
