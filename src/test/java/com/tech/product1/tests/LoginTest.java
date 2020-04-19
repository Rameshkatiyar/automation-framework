package com.tech.product1.tests;

import com.tech.enums.Platform;
import com.tech.product1.common.Product1TestAutomation;
import com.tech.annotations.Platforms;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Product1TestAutomation {

    @Platforms({Platform.API, Platform.APP, Platform.WEB})
    @Test(groups = {SMOKE, ACCEPTANCE}, description = "Verify for invalid username and password, user is not able to login.")
    public void test1(){
        //Get status after login
        int status = loginAction.doLoginAndGetStatus("abc", "zzz");

        //Validation
        Assert.assertEquals(status, 300);
    }

    @Platforms({Platform.BACKEND, Platform.API})
    @Test(groups = {SMOKE, ACCEPTANCE, REGRESSION}, description = "Verify invalid user or not existing user can not login.")
    public void test2(){
        System.out.println("executing Login Test 2");
    }

    @Platforms
    @Test(groups = {ACCEPTANCE}, description = "Verify that the Registration form contains Username, First Name, Last Name, Password.")
    public void test3(){
        System.out.println("Executing login Test 3");
    }
}
