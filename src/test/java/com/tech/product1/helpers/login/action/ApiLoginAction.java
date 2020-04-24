package com.tech.product1.helpers.login.action;

import com.tech.common.apiTestHelper.ApiAutomationHelper;
import com.tech.enums.Platform;
import com.tech.product1.helpers.login.pages.ApiLoginUrl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ApiLoginAction extends ApiAutomationHelper implements LoginAction {

    @Autowired
    private ApiLoginUrl apiLoginUrl;

    @Override
    public int doLoginAndGetStatus(String username, String password) {
        System.out.println("Login through api at url: "+ apiLoginUrl.getLoginUrl());
        getResponse(apiLoginUrl.getEmployeesUrl()).prettyPrint();
        int status = getStatus(apiLoginUrl.getEmployeesUrl());

        return status;
    }

    @Override
    public Platform getPlatformType() {
        return Platform.API;
    }

    @Override
    public String getBaseURI() {
        return testUrlConfig.getFacebookApiUrl();
    }
}
