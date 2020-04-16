package com.tech.common;

import com.tech.Application;
import com.tech.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;

@ContextConfiguration(classes = Application.class)
public class AutomateTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected PlatformResolver platformResolver;
    @Autowired
    protected ConfigProperties configProperties;

    public final String SMOKE = "SMOKE";
    public final String ACCEPTANCE = "ACCEPTANCE";

    protected PlatformAPI platformAPI;

    @BeforeClass(alwaysRun = true)
    public void init() {
        platformAPI = platformResolver.getPlatformApiResolver(configProperties.getPlatform()).get();
    }
}
