package com.tech.product1.registration.action;

import com.tech.common.ResolverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationResolver extends ResolverFactory<RegistrationAction> {
    @Autowired
    private RegistrationAppService registrationAppService;
    @Autowired
    private RegistrationApiService registrationApiService;

    @Override
    public RegistrationAction getAPIService() {
        return registrationApiService;
    }

    @Override
    public RegistrationAction getAppService() {
        return registrationAppService;
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
