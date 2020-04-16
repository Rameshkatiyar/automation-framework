package com.tech.product1.login.action;

import org.springframework.stereotype.Service;

@Service
public class LoginApiService extends LoginAction {

    public int doLoginAndGetStatus(String username, String password) {
        System.out.println("Login through API");
        return 200;
    }
}
