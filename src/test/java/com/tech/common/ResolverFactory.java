package com.tech.common;

import com.tech.enums.Platform;

public abstract class ResolverFactory<T> {

    public T getResolver(Platform platform){
        switch (platform){
            case API: getAPIService();
                break;
            case WEB: getWebService();
                break;
            case APP: getAppService();
                break;
            case BACKEND: getBackendService();
                break;
        }
        return null;
    }

    protected abstract T getAPIService();
    protected abstract T getAppService();
    protected abstract T getWebService();
    protected abstract T getBackendService();
}
