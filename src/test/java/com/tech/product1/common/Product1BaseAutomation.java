package com.tech.product1.common;

import com.tech.commonHelper.commonApi.BaseAutomation;
import com.tech.product1.action.LoginAction;
import com.tech.product1.action.RegistrationAction;

public class Product1BaseAutomation extends BaseAutomation {

    protected LoginAction loginAction;
    protected RegistrationAction registrationAction;

    @Override
    protected void setInitialConfig() {
        loginAction = (LoginAction) testActionResolver.getResolver(platform, LoginAction.class);
        registrationAction = (RegistrationAction) testActionResolver.getResolver(platform, RegistrationAction.class);
    }
}
