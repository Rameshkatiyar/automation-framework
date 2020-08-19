package com.tech.commonHelper.appTestHelper;

import com.tech.appProduct.pages.AppHomePage;
import com.tech.commonHelper.commonApi.BaseAutomation;
import io.appium.java_client.AppiumDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@Service
public class AppBaseAutomation extends BaseAutomation {

    @Autowired
    protected AppAutomationHelper appAutomationHelper;
    @Autowired
    protected AppHomePage appHomePage;

    protected AppiumDriver globalDriver;

    @BeforeClass(alwaysRun = true)
    public void initBaseSetup(){
        appAutomationHelper.installApp();
        this.globalDriver = appAutomationHelper.openApp();
    }

    @AfterClass
    public void tearDown(){
        globalDriver.quit();
    }

    @Override
    protected void setInitialConfig() {

    }
}
