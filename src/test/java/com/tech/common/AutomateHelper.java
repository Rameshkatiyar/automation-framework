package com.tech.common;

import com.tech.Application;
import com.tech.config.ConfigInitializer;
import com.tech.config.ConfigProperties;
import com.tech.enums.Platform;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Slf4j
@Listeners(PlatformListener.class)
@ContextConfiguration(classes = Application.class, initializers = ConfigInitializer.class)
public abstract class AutomateHelper extends AbstractTestNGSpringContextTests {
    @Autowired
    protected ConfigProperties configProperties;

    public final String API = "API";
    public final String APP = "APP";
    public final String WEB = "WEB";
    public final String BACKEND = "BACKEND";

    public Platform platform;

    @BeforeClass(alwaysRun = true)
    public void setConfig() {
        this.platform = configProperties.getPlatform();
        log.info("Setting the platform for: {}", platform);
        setInitialConfig();
    }

    protected abstract void setInitialConfig();
}
