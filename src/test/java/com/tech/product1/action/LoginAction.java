package com.tech.product1.action;

import com.tech.commonHelper.commonApi.TestAction;

public interface LoginAction extends TestAction {
    int doLoginAndGetStatus(String username, String password);
}
