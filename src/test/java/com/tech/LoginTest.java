package com.tech;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test(description = "Verify valid user only can register properly.")
    public void test1(){
        System.out.println("Test 1");
        Assert.assertEquals("1", "2");
    }

    @Test(description = "Verify invalid user or not existing user can not register.")
    public void test2(){
        System.out.println("Test 2");
    }

    @Test(description = "Verify that the Registration form contains Username, First Name, Last Name, Password.")
    public void test3(){
        System.out.println("Test 3");
    }
}
