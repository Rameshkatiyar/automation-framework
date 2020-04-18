package com.tech.product1.common;

import com.tech.common.AutomateHelper;
import com.tech.product1.login.action.LoginAction;
import com.tech.product1.login.action.LoginResolver;
import com.tech.product1.registration.action.RegistrationAction;
import com.tech.product1.registration.action.RegistrationResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductOneAutomateHelper extends AutomateHelper {

    @Autowired
    private LoginResolver loginResolver;
    @Autowired
    private RegistrationResolver registrationResolver;

    protected LoginAction loginAction;
    protected RegistrationAction registrationAction;

    @Override
    protected void setInitialConfig() {
        if (loginResolver.getResolver(platform).isPresent()){
            loginAction = this.loginResolver.getResolver(platform).get();
        }
        if (registrationResolver.getResolver(platform).isPresent()){
            registrationAction = this.registrationResolver.getResolver(platform).get();
        }
    }
}
