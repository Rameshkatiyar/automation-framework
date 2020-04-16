package com.tech.login;

import com.tech.common.PlatformAPI;

public abstract class LoginAPI implements PlatformAPI {
    abstract int doLoginAndGetStatus(String username, String password);
}
