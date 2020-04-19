package com.tech.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class TestUrlConfig {
    @Value("${facebook.web.url}")
    private String facebookWebUrl;
}
