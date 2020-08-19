package com.tech.config;

import com.tech.enums.Environment;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class AppConfig {

    @Value("${appium.server.url}")
    private String appiumServerUrl;

    @Value("${browserstack.userName}")
    private String browserStackUserName;

    @Value("${browserstack.accessKey}")
    private String browserStackAccessKey;

    @Value("${localAppBinaryPath}")
    private String localAppBinaryPath;

    @Value("${app.binaryName}")
    private String appBinaryName;

    @Value("${app.platform}")
    private String appPlatform;

    @Value("${app.environment}")
    private Environment appEnvironment;

    @Value("${app.device}")
    private String appDevice;

    @Value("${app.osVersion}")
    private String appOsVersion;

    @Value("${app.projectName}")
    private String appProjectName;

    @Value("${app.testName}")
    private String appTestName;

    @Value("${app.package}")
    private String appPackage;

    @Value("${app.activity}")
    private String appActivity;

    @Value("${app.udid}")
    private String appUdid;
}
