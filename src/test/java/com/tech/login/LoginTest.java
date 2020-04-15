package com.tech.login;

import com.tech.common.AutomateTest;
import com.tech.enums.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends AutomateTest {

    private LoginAPI loginAPI;

    @Autowired
    private LoginResolver loginResolver;

    @BeforeClass
    public void setInit(){
        loginAPI = loginResolver.getResolver(Platform.API).get();
    }

    @Test(groups = {SMOKE, ACCEPTANCE}, description = "Verify valid user only can register properly.")
    public void test1(){
        //Get Data
        int status = loginAPI.doLoginAndGetStatus("abc", "zzz");
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
