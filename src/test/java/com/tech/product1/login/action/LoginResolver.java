package com.tech.product1.login.action;

import com.tech.common.ResolverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginResolver extends ResolverFactory<LoginAction> {

    @Autowired
    private LoginApiService loginApiService;
    @Autowired
    private LoginWebService loginWebService;

    @Override
    public Optional<LoginAction> getAPIService() {
        return Optional.of(loginApiService);
    }

    @Override
    public Optional<LoginAction> getAppService() {
        return Optional.empty();
    }

    @Override
    public Optional<LoginAction> getWebService() {
        return Optional.of(loginWebService);
    }

    @Override
    public Optional<LoginAction> getBackendService() {
        return Optional.empty();
    }
}
