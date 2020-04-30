package com.tech.commonHelper.webTestHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseWebPage {
    protected WebDriver driver;

    public void setDriver(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, getCurrentObject());
    }

    protected abstract Object getCurrentObject();
}
