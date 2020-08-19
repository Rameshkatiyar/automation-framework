package com.tech.appProduct.pages;

import com.tech.commonHelper.appTestHelper.BaseAppPage;
import io.appium.java_client.MobileElement;
import lombok.Data;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Data
@Component
public class AppHomePage extends BaseAppPage {
    @Override
    protected Object getCurrentObject() {
        return this;
    }

    @FindBy(id="abc")
    MobileElement logo;

    @FindBy(xpath="xyz")
    MobileElement disclamer;
}
