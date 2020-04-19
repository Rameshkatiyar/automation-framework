package com.tech.product1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DummyAndroidTest {
    private static String serverUrl = "http://localhost:4723/wd/hub";
    private static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) throws MalformedURLException {
        System.out.println("Testing Calculator App!");

        connectWithAppiumServer();
        addTwoNumber();

        System.out.println("Testing Done!");
    }

    private static void addTwoNumber(){
        MobileElement two = driver.findElement(By.id("com.oneplus.calculator:id/digit_2"));
        MobileElement five = driver.findElement(By.id("com.oneplus.calculator:id/digit_5"));
        MobileElement plus = driver.findElement(By.id("com.oneplus.calculator:id/op_add"));
        MobileElement equal = driver.findElement(By.id("com.oneplus.calculator:id/eq"));

        MobileElement result = driver.findElement(By.id("com.oneplus.calculator:id/result"));

        two.click();
        plus.click();
        five.click();
        equal.click();

        String text = result.getText();
        System.out.println("Result: "+text);

    }

    private static void connectWithAppiumServer() throws MalformedURLException {
        Capabilities capabilities = getDesiredCapabilities();
        URL appiumServerUrl = new URL(serverUrl);// Appium Server URL;

        //Send these desire capabilities to Appium Server
        driver = new AndroidDriver<MobileElement>(appiumServerUrl, capabilities);

        System.out.println("Connected With Appium Server.");
    }

    /**
     * DesiredCapability = AboutDevice + AboutApplication
     * @return
     */
    private static DesiredCapabilities getDesiredCapabilities(){
        DesiredCapabilities cap = new DesiredCapabilities();

        //About Device
        cap.setCapability("deviceName", "OnePlus 6");
        cap.setCapability("udid", "497f66d4");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "10");

        //About Application
        cap.setCapability("appPackage", "com.oneplus.calculator");
        cap.setCapability("appActivity", "com.oneplus.calculator.Calculator");

        return cap;
    }
}
