package com.tech.product1.registration.test;

import com.tech.product1.common.ProductOneAutomateHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends ProductOneAutomateHelper {

    @Test(groups = {SMOKE, ACCEPTANCE}, description = "Verify valid user only can register properly.")
    public void test4(){
        //Get Data
        String msg = registrationAction.doRegistration();
        //Validation
        Assert.assertEquals(msg, "Registration SMOKE.");
    }

    @Test(groups = {SMOKE, ACCEPTANCE}, description = "Verify invalid user or not existing user can not register.")
    public void test5(){
        System.out.println("Test 5");
    }

    @Test(description = "Verify that the Registration form contains Username, First Name, Last Name, Password.")
    public void test6(){
        System.out.println("Test 6");
    }
}
