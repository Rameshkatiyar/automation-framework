package com.tech.product1.helpers.login.pages;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class ApiLoginUrl {
    @Value("/signin")
    String loginUrl;

    @Value("/api/v1/employees")
    String employeesUrl;
}
