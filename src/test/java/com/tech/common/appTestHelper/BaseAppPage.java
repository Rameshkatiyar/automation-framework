package com.tech.common.appTestHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseAppPage {
    protected AppiumDriver<MobileElement> driver;

    public void setDriver(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), getCurrentObject());
    }

    protected abstract Object getCurrentObject();
}