package com.tech.common;

import com.tech.enums.Platform;

/**
 * Using Factory Design Pattern
 * @param <T>
 */
public abstract class ResolverFactory<T> {

    public T getResolver(Platform platform){
        switch (platform){
            case API: return getAPIService();
            case WEB: return getWebService();
            case APP: return getAppService();
            case BACKEND:return getBackendService();
        }
        return null;
    }

    abstract public T getAPIService();
    abstract public T getAppService();
    abstract public T getWebService();
    abstract public T getBackendService();
}
