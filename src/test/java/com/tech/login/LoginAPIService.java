package com.tech.login;

import com.tech.enums.Platform;
import org.springframework.stereotype.Service;

@Service
public class LoginAPIService extends LoginAPI {
    protected Platform getPlatform() {
        return Platform.API;
    }

    int doLoginAndGetStatus(String username, String password) {
        System.out.println("Login through API");
        return 200;
    }
}
