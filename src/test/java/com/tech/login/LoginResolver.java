package com.tech.login;

import com.tech.enums.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class LoginResolver {
    Map<Platform, LoginAPI> loginKeywordResolverList;

    @Autowired
    public LoginResolver(List<LoginAPI> resolverList) {
        loginKeywordResolverList = resolverList.stream()
                .collect(Collectors.toMap(LoginAPI::getPlatform, Function.identity()));
    }

    public Optional<LoginAPI> getResolver(Platform platform) {
        return Optional.ofNullable(loginKeywordResolverList.get(platform));
    }
}
