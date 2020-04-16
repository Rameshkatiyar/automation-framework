package com.tech.login;

import com.tech.common.ResolverFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginResolver extends ResolverFactory<LoginAPI> {
    @Override
    protected LoginAPI getAPIService() {
        return new LoginAPIService();
    }

    @Override
    protected LoginAPI getAppService() {
        return null;
    }

    @Override
    protected LoginAPI getWebService() {
        return new LoginWebService();
    }

    @Override
    protected LoginAPI getBackendService() {
        return null;
    }
}
