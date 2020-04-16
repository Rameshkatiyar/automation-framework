package com.tech.common;

import com.tech.enums.Platform;

import java.util.Optional;

/**
 * Using Factory Design Pattern
 * @param <T>
 */
public abstract class ResolverFactory<T> {

    public Optional<T> getResolver(Platform platform){
        switch (platform){
            case API: return getAPIService();
            case WEB: return getWebService();
            case APP: return getAppService();
            case BACKEND:return getBackendService();
        }
        return Optional.empty();
    }

    abstract public Optional<T> getAPIService();
    abstract public Optional<T> getAppService();
    abstract public Optional<T> getWebService();
    abstract public Optional<T> getBackendService();
}
