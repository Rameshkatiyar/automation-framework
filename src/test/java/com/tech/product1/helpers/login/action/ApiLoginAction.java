package com.tech.product1.helpers.login.action;

import com.tech.common.apiTestHelper.ApiAutomationHelper;
import com.tech.enums.Platform;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ApiLoginAction extends ApiAutomationHelper implements LoginAction {

    @Override
    public int doLoginAndGetStatus(String username, String password) {
        System.out.println("Login through api.");
        return 200;
    }

    @Override
    public Platform getPlatformType() {
        return Platform.API;
    }
}
