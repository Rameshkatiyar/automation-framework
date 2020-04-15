package com.tech.login;

import com.tech.enums.Platform;

public abstract class LoginAPI {
    protected abstract Platform getPlatform();

    abstract int doLoginAndGetStatus(String username, String password);
}
