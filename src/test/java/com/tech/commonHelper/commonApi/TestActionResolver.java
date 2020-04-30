package com.tech.commonHelper.commonApi;

import com.tech.enums.Platform;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.util.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
@NoArgsConstructor
public class TestActionResolver {
    Map<String, TestAction> testActionMap; //Here we are using key as ActionInterface-Platform

    @Autowired
    public TestActionResolver(List<TestAction> resolverList) {
        testActionMap = resolverList.stream()
                .collect(Collectors.toMap(testAction -> {
                    return getKeyByClassName(testAction.getPlatformType(), testAction.getClass());
                }, Function.identity()));
    }

    public TestAction getResolver(Platform platform, Class<?> actionClass) {
        String resolverKey = getKeyByInterfaceName(platform, actionClass);
        return testActionMap.get(resolverKey);
    }

    private String getKeyByClassName(Platform platform, Class<?> actionClass){
        String platformType = platform.toString();
        String interfaceName;

        Class[] interfaces = actionClass.getInterfaces();
        if (null == interfaces || interfaces.length == 0){
            interfaceName = null;
        }else {
            interfaceName = Arrays.asList(interfaces).stream().findFirst().get().getSimpleName();
        }

        if (Strings.isNullOrEmpty(interfaceName))
            return platformType;
        else
            return interfaceName +"-"+ platformType;
    }

    private String getKeyByInterfaceName(Platform platform, Class<?> actionClass){
        String platformType = platform.toString();
        String interfaceName = actionClass.getSimpleName();
        return interfaceName +"-"+ platformType;
    }
}
