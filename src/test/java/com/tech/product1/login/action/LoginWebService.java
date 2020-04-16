package com.tech.product1.login.action;

import org.springframework.stereotype.Service;

@Service
public class LoginWebService extends LoginAction {

    public int doLoginAndGetStatus(String username, String password) {
        System.out.println("Login through Web.");
        return 200;
    }
}
