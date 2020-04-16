package com.tech.common;

import com.tech.Application;
import com.tech.config.ConfigProperties;
import com.tech.enums.Platform;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;

@Slf4j
@ContextConfiguration(classes = Application.class)
public abstract class AutomateHelper extends AbstractTestNGSpringContextTests {
    @Autowired
    protected ConfigProperties configProperties;

    public final String SMOKE = "SMOKE";
    public final String ACCEPTANCE = "ACCEPTANCE";

    public Platform platform;

    @BeforeClass(alwaysRun = true)
    public void setConfig() {
        this.platform = configProperties.getPlatform();
        log.info("Setting the platform for: {}", platform);
        setInitialConfig();
    }

    protected abstract void setInitialConfig();
}
