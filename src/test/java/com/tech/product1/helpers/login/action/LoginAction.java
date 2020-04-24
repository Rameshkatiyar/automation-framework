package com.tech.product1.helpers.login.action;

import com.tech.common.TestAction;

public interface LoginAction extends TestAction {
    int doLoginAndGetStatus(String username, String password);
}
