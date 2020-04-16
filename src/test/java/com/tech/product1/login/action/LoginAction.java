package com.tech.product1.login.action;

public abstract class LoginAction {
    abstract public int doLoginAndGetStatus(String username, String password);
}
