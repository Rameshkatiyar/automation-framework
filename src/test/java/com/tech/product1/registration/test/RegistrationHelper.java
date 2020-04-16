package com.tech.product1.registration.test;

import com.tech.product1.common.ProductOneAutomateHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationHelper extends ProductOneAutomateHelper {

    @Test(groups = {SMOKE, ACCEPTANCE}, description = "Verify valid user only can register properly.")
    public void test4(){
        //Get Data
        int status = loginAction.doLoginAndGetStatus("abc", "zzz");
        System.out.println("Test 4: "+ status);

        //Validation
        Assert.assertEquals(status, 200);
    }

    @Test(groups = {SMOKE, ACCEPTANCE}, description = "Verify invalid user or not existing user can not register.")
    public void test5(){
        System.out.println("Test 5");
    }

    @Test(groups = {ACCEPTANCE}, description = "Verify that the Registration form contains Username, First Name, Last Name, Password.")
    public void test6(){
        System.out.println("Test 6");
    }

    @Override
    public void setInitialConfig() {

    }
}
