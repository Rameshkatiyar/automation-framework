package com.tech.product1.common;

import com.tech.common.AutomateHelper;
import com.tech.product1.login.action.LoginAction;
import com.tech.product1.login.config.LoginResolver;
import com.tech.product1.registration.action.RegistrationAction;
import com.tech.product1.registration.config.RegistrationResolver;
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
        loginAction = this.loginResolver.getResolver(platform).get();
        registrationAction = this.registrationResolver.getResolver(platform).get();
    }
}
