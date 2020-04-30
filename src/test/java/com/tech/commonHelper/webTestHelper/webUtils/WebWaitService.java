package com.tech.commonHelper.webTestHelper.webUtils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


@Slf4j
public class WebWaitService {

    /**
     * This will wait till 'document.readyState' value is not 'complete'.
     * This will value marked as complete after full page load only.
     * @param driver
     */
    public static void waitForPageLoad(WebDriver driver) {
        long startTime = 0l;
        long endTime = 0l;
        long pageLoadTimeout = 30;

        startTime = System.currentTimeMillis();
        ExpectedCondition<Boolean> pageLoadCondition =
                driver1 -> ((JavascriptExecutor) driver1)
                        .executeScript("return document.readyState")
                        .equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, pageLoadTimeout);
        wait.until(pageLoadCondition);
        endTime = System.currentTimeMillis();

        long waitingTime = endTime - startTime;
        log.info("Ended waiting for page load. Total time : {} ms.", waitingTime);
    }
}
