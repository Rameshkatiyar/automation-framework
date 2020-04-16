package com.tech.product1.login.test;

import com.tech.product1.common.ProductOneAutomateHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends ProductOneAutomateHelper {

    @Test(groups = {API, APP}, description = "Verify valid user only can login.")
    public void test1(){
        //Get Data
        int status = loginAction.doLoginAndGetStatus("abc", "zzz");

        //Validation
        Assert.assertEquals(status, 200);
    }

    @Test(groups = {API, APP}, description = "Verify invalid user or not existing user can not login.")
    public void test2(){
        System.out.println("Test 2");
    }

    @Test(groups = {APP}, description = "Verify that the Registration form contains Username, First Name, Last Name, Password.")
    public void test3(){
        System.out.println("Test 3");
    }
}
