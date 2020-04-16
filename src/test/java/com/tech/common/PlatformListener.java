package com.tech.common;

import com.tech.config.ConfigProperties;
import com.tech.enums.Platform;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class PlatformListener implements ITestListener {

    @Autowired
    private ConfigProperties configProperties;

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Platform: "+ configProperties);
        Platform platform = Platform.API;

        List<String> listOfGroups = Arrays.asList(result.getMethod().getGroups());
        if (!listOfGroups.contains(platform.toString())){
            result.setStatus(ITestResult.SKIP);//Skipped test based on platform!
            log.info("Ignoring Test: {}, because this test is not available for the platform: {}", result.getName(), platform);
        }
    }
}
