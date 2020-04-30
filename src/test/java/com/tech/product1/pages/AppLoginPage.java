package com.tech.product1.pages;

import com.tech.commonHelper.appTestHelper.BaseAppPage;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Data
@Component
public class AppLoginPage extends BaseAppPage {
    @Override
    protected Object getCurrentObject() {
        return this;
    }

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "pass")
    WebElement passwordField;

    @FindBy(id = "loginbutton")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"blueBarDOMInspector\"]/div/div[2]/div/div/span/a")
    WebElement createNewAccountButton;


    public void setUsername(String username) {
        emailField.sendKeys(username);
    }

    public void setPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}
