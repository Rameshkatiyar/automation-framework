package com.tech.config;

import com.tech.enums.Environment;
import com.tech.enums.Platform;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class TestConfig {
    @Value("${platform:API}") //Default value of platform = API
    private Platform platform;

    @Value("${appium.server.url}")
    private String appiumServerUrl;

    @Value("${selenium.browserstack.url}")
    private String seleniumBrowserstackUrl;

    @Value("${environment:LOCAL}") //Default value of platform = API
    private Environment environment;

    @Value("${test.data.path}")
    private String testDataPath;

    @Value("${screenshot.path}")
    private String screenshotPath;
}
