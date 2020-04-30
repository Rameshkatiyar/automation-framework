package com.tech.product1.common;

import com.tech.commonHelper.commonApi.TestAutomation;
import com.tech.product1.action.LoginAction;
import com.tech.product1.action.RegistrationAction;

public class Product1TestAutomation extends TestAutomation {

    protected LoginAction loginAction;
    protected RegistrationAction registrationAction;

    @Override
    protected void setInitialConfig() {
        loginAction = (LoginAction) testActionResolver.getResolver(platform, LoginAction.class);
        registrationAction = (RegistrationAction) testActionResolver.getResolver(platform, RegistrationAction.class);
    }
}
