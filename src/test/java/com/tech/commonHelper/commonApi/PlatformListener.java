package com.tech.commonHelper.commonApi;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class PlatformListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result){
        log.error("Test failed because of error: {}", result.getThrowable());
        result.setStatus(ITestResult.FAILURE);
    }
}
