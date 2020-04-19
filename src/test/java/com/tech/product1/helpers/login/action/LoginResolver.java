package com.tech.product1.helpers.login.action;

import com.tech.common.ResolverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginResolver extends ResolverFactory<LoginAction> {

    @Autowired
    private ApiLoginAction apiLoginAction;
    @Autowired
    private WebLoginAction webLoginAction;
    @Autowired
    private AppLoginAction appLoginAction;

    @Override
    public LoginAction getAPIService() {
        return apiLoginAction;
    }

    @Override
    public LoginAction getAppService() {
        return appLoginAction;
    }

    @Override
    public LoginAction getWebService() {
        return webLoginAction;
    }

    @Override
    public LoginAction getBackendService() {
        return null;
    }
}
