package com.tech.config;

import com.tech.enums.Platform;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class ConfigProperties {
    @Value("${platform:API}") //Default value of platform = API
    private Platform platform;
}
