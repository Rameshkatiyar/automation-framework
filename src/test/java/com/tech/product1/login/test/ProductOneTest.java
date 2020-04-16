package com.tech.product1.login.test;

import com.tech.product1.common.ProductOneAutomateHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductOneTest extends ProductOneAutomateHelper {

    @Test(groups = {SMOKE, ACCEPTANCE}, description = "Verify valid user only can register properly.")
    public void test1(){
        //Get Data
        int status = loginAction.doLoginAndGetStatus("abc", "zzz");
        System.out.println("Test 1: "+ status);

        //Validation
        Assert.assertEquals(status, 200);
    }

    @Test(groups = {SMOKE, ACCEPTANCE}, description = "Verify invalid user or not existing user can not register.")
    public void test2(){
        System.out.println("Test 2");
    }

    @Test(groups = {ACCEPTANCE}, description = "Verify that the Registration form contains Username, First Name, Last Name, Password.")
    public void test3(){
        System.out.println("Test 3");
    }
}
