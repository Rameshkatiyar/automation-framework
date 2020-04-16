package com.tech.product1.registration.config;

import com.tech.common.ResolverFactory;
import com.tech.product1.registration.action.RegistrationAction;
import com.tech.product1.registration.action.RegistrationApiService;
import com.tech.product1.registration.action.RegistrationAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationResolver extends ResolverFactory<RegistrationAction> {
    @Autowired
    private RegistrationAppService registrationAppService;
    @Autowired
    private RegistrationApiService registrationApiService;


    @Override
    public Optional<RegistrationAction> getAPIService() {
        return Optional.of(registrationApiService);
    }

    @Override
    public Optional<RegistrationAction> getAppService() {
        return Optional.of(registrationAppService);
    }

    @Override
    public Optional<RegistrationAction> getWebService() {
        return Optional.empty();
    }

    @Override
    public Optional<RegistrationAction> getBackendService() {
        return Optional.empty();
    }
}
