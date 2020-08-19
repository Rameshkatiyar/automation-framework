package com.tech.product1.tests;

import com.tech.annotations.Testable;
import com.tech.enums.Platform;
import com.tech.product1.common.Product1BaseAutomation;
import com.tech.annotations.Platforms;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

@Testable(testName = "HomePage")
public class LoginTest extends Product1BaseAutomation {

    @Platforms({Platform.API, Platform.APP, Platform.WEB})
    @Test(groups = {SMOKE, ACCEPTANCE}, description = "Verify for invalid username and password, user is not able to login.")
    public void test1(){
        //Get Test Data
        Map<String, String> testdata = getTestData("test1");
        String username = testdata.get("username");
        String password = testdata.get("password");
        String description = testdata.get("description");


        //Perform Action
        int status = loginAction.doLoginAndGetStatus(username, password);

        //Validate Action's Result
        Assert.assertEquals(status, 300);
    }

    @Platforms({Platform.BACKEND, Platform.API})
    @Test(groups = {SMOKE, ACCEPTANCE, REGRESSION}, description = "Verify invalid user or not existing user can not login.")
    public void test2(){
        System.out.println("Thread: "+Thread.currentThread().getName());
        System.out.println("executing Login Test 2");

        softAssert.assertTrue(false);

        System.out.println("After assertion executing Login Test 2");
    }

    @Platforms
    @Test(groups = {ACCEPTANCE}, description = "Verify that the Registration form contains Username, First Name, Last Name, Password.")
    public void test3(){
        System.out.println("Thread: "+Thread.currentThread().getName());
        System.out.println("Executing login Test 3");
    }

    @Test(
            groups = {SMOKE},
            description = "Verify that the Registration form contains Username, First Name, Last Name, Password.",
            threadPoolSize = 3,
            invocationCount = 6,
            timeOut = 1000
    )
    public void test4(){
        System.out.println("Thread: "+Thread.currentThread().getName());
        System.out.println("Executing login Test 4 without any platform.");
    }
}
