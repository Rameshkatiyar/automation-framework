package com.tech;

import com.tech.config.ConfigInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.tech", lazyInit = true)
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .initializers(new ConfigInitializer())
                .run(args);
    }
}
