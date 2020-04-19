package com.tech.config;

import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

import java.util.List;

@Slf4j
@Configuration
public class ConfigInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static final List<String> propertiesFiles = ImmutableList.of("config.properties", "testUrl.properties");

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        final ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String propFilePath = environment.getProperty("props.file.path");
        final MutablePropertySources mutablePropertySources = environment.getPropertySources();

        for (String file : propertiesFiles) {
            try {
                mutablePropertySources
                        .addLast(new ResourcePropertySource("file:" + propFilePath + "/" + file));
            } catch (Exception e) {
                log.error("Not able to read file from path: {} and Error: {}", propFilePath, e);
            }
        }
    }
}
