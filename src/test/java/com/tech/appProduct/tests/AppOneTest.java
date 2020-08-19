package com.tech.appProduct.tests;

import com.tech.commonHelper.appTestHelper.AppBaseAutomation;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class AppOneTest extends AppBaseAutomation {

    @Test(description = "Verify home page.", groups = {SMOKE, REGRESSION})
    public void test1() {
        String logoName = appHomePage.getLogo().getText();
        Assert.assertEquals(logoName, "hindi");

    }

    @Test(description = "Verify home page.", groups = {REGRESSION})
    public void test2() {
        log.info("Test 2 is starting.");

    }

}
