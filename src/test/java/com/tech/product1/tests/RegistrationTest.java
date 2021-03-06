package com.tech.product1.tests;

import com.tech.annotations.Platforms;
import com.tech.annotations.Testable;
import com.tech.product1.common.Product1BaseAutomation;
import org.testng.Assert;
import org.testng.annotations.Test;

@Testable(testName = "HomePage")
public class RegistrationTest extends Product1BaseAutomation {

    @Platforms
    @Test(groups = {SMOKE, ACCEPTANCE}, description = "Verify valid user only can register properly.")
    public void test4(){
        System.out.println("Thread: "+Thread.currentThread().getId());
        //Get Data
        String msg = registrationAction.doRegistration();
        //Validation
        Assert.assertEquals(msg, "Registration SMOKE.");
    }

    @Test(groups = {SMOKE, ACCEPTANCE}, description = "Verify invalid user or not existing user can not register.")
    public void test5(){
        System.out.println("Thread: "+Thread.currentThread().getName());
        System.out.println("Test 5");
    }

    @Test(description = "Verify that the Registration form contains Username, First Name, Last Name, Password.")
    public void test6(){
        System.out.println("Thread: "+Thread.currentThread().getName());
        System.out.println("Test 6");
    }
}
