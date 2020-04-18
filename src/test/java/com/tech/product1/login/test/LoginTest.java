package com.tech.product1.login.test;

import com.tech.enums.Platform;
import com.tech.product1.common.ProductOneAutomateHelper;
import com.tech.service.Platforms;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends ProductOneAutomateHelper {

    @Platforms({Platform.API, Platform.APP})
    @Test(groups = {SMOKE, ACCEPTANCE},
            description = "Verify valid user only can login.")
    public void test1(){
        //Get Data
        int status = loginAction.doLoginAndGetStatus("abc", "zzz");
        System.out.println("executing Login Test 1");
        //Validation
        Assert.assertEquals(status, 200);
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
