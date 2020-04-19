package com.tech.product1.helpers.login.action;

import com.tech.common.apiTestHelper.ApiAutomationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiLoginAction extends ApiAutomationHelper implements LoginAction {

    @Autowired
    private ApiAutomationHelper apiAutomationHelper;

    @Override
    public int doLoginAndGetStatus(String username, String password) {
        System.out.println("Login through api.");
        return 200;
    }
}
