package com.tech.product1.helpers.login.action;

import com.tech.common.ResolverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginResolver extends ResolverFactory<LoginAction> {

    @Autowired
    private LoginApiService loginApiService;
    @Autowired
    private LoginWebService loginWebService;

    @Override
    public LoginAction getAPIService() {
        return loginApiService;
    }

    @Override
    public LoginAction getAppService() {
        return null;
    }

    @Override
    public LoginAction getWebService() {
        return loginWebService;
    }

    @Override
    public LoginAction getBackendService() {
        return null;
    }
}
