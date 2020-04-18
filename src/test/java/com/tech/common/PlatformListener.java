package com.tech.common;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class PlatformListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result){
        log.info("Test is started: {}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        log.error("Test failed because of error: {}", result.getThrowable().getCause());
        result.setStatus(ITestResult.FAILURE);
    }
}
