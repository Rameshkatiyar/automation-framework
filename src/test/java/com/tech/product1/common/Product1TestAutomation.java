package com.tech.product1.common;

import com.tech.common.TestAutomation;
import com.tech.product1.login.action.LoginAction;
import com.tech.product1.login.action.LoginResolver;
import com.tech.product1.registration.action.RegistrationAction;
import com.tech.product1.registration.action.RegistrationResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class Product1TestAutomation extends TestAutomation {

    @Autowired
    private LoginResolver loginResolver;
    @Autowired
    private RegistrationResolver registrationResolver;

    protected LoginAction loginAction;
    protected RegistrationAction registrationAction;

    @Override
    protected void setInitialConfig() {
        loginAction = this.loginResolver.getResolver(platform);
        registrationAction = this.registrationResolver.getResolver(platform);
    }
}
