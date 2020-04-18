package com.tech.common.webTestHelper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public abstract class WebAutomationHelper {

    @Autowired
    protected SeleniumService seleniumService;
}
