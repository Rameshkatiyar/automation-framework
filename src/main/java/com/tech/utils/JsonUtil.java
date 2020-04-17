package com.tech.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JsonUtil {
    @Autowired
    private ObjectMapper objectMapper;

    public <T> T mapJsonToObject(String jsonString, Class<T> tClass) {
        try {
            return objectMapper.readValue(jsonString, tClass);
        } catch (Exception e) {
            log.error("Failed Json To Object mapping. {}", e.getMessage());
            return null;
        }
    }

    public String mapObjectToJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            log.error("Failed Object to Json mapping. {}", e.getMessage());
            return "";
        }
    }
}
