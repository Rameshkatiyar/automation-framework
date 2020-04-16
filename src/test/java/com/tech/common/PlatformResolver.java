package com.tech.common;

import com.tech.enums.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PlatformResolver {
    Map<Platform, PlatformAPI> platformApiResolverList;

    @Autowired
    public PlatformResolver(List<PlatformAPI> resolverList) {
        platformApiResolverList = resolverList.stream()
                .collect(Collectors.toMap(PlatformAPI::getPlatform, Function.identity()));
    }

    public Optional<PlatformAPI> getPlatformApiResolver(Platform platform) {
        return Optional.ofNullable(platformApiResolverList.get(platform));
    }

    public Map<Platform, PlatformAPI> getResolverList(){
        return platformApiResolverList;
    }

    public void prnt(){
        System.out.println("Pringing......");
    }
}
