package com.tech.login;

import com.tech.common.AutomateTest;
import com.tech.enums.Platform;
import com.tech.registration.RegistrationAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends AutomateTest {

    private LoginAPI loginAPI;
    private RegistrationAPI registrationAPI;

    @Autowired
    private LoginResolver loginResolver;

    @BeforeClass
    public void setInit(){
        System.out.println("Test...Pring....");
            loginAPI = (LoginAPI) platformAPI;
//        loginAPI = (LoginAPI) platformResolver.getPlatformApiResolver(configProperties.getPlatform()).get();
//        registrationAPI = (RegistrationAPI) platformResolver.getPlatformApiResolver(configProperties.getPlatform()).get();
    }

    @Test(groups = {SMOKE, ACCEPTANCE}, description = "Verify valid user only can register properly.")
    public void test1(){
        //Get Data
        int status = loginAPI.doLoginAndGetStatus("abc", "zzz");
        System.out.println("Test 1: "+ status);
        System.out.println("List: "+platformResolver.getResolverList());
//        System.out.println("Regis: "+registrationAPI.doRegistration());

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
