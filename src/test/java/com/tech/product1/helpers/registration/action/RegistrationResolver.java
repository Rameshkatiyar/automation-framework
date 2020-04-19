package com.tech.product1.helpers.registration.action;

import com.tech.common.ResolverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationResolver extends ResolverFactory<RegistrationAction> {
    @Autowired
    private AppRegistrationAction appRegistrationAction;
    @Autowired
    private ApiRegistrationAction apiRegistrationAction;

    @Override
    public RegistrationAction getAPIService() {
        return apiRegistrationAction;
    }

    @Override
    public RegistrationAction getAppService() {
        return appRegistrationAction;
    }

    @Override
    public RegistrationAction getWebService() {
        return null;
    }

    @Override
    public RegistrationAction getBackendService() {
        return null;
    }
}
