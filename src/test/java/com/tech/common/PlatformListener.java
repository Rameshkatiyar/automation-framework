package com.tech.common;

import com.tech.config.ConfigInitializer;
import com.tech.config.ConfigProperties;
import com.tech.enums.Platform;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class PlatformListener extends ConfigProperties implements ITestListener {

    private Platform platformValue;

    public void setPlatformValue(Platform platformValue){
        this.platformValue = platformValue;
    }

    public Platform getPlatformValue(){
        return this.platformValue;
    }

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Platform: "+ getPlatform());
        Platform platform = Platform.WEB;

        List<String> listOfGroups = Arrays.asList(result.getMethod().getGroups());
        if (!listOfGroups.contains(platform.toString())){
            result.setStatus(ITestResult.SKIP);//Skipped test based on platform!
            throw new SkipException("Skipping / Ignoring - Script not Ready for platform: "+platform);
        }
    }
}
