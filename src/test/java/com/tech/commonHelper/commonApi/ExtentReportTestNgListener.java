package com.tech.commonHelper.commonApi;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * http://extentreports.com/docs/versions/3/java/#basic-example
 */
@Slf4j
public class ExtentReportTestNgListener implements ITestListener {
    private ExtentHtmlReporter htmlReporter;
    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        // start reporters
        this.htmlReporter = new ExtentHtmlReporter("extent.html");

        // create ExtentReports and attach reporter(s)
        this.extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        String name = result.getName();
        String description = result.getMethod().getDescription();

        // creates a toggle for the given test, adds all log events under it
        this.test = extent.createTest(name, description);
    }

    @Override
    public void onFinish(ITestContext context) {
        // calling flush writes everything to the log file
        extent.flush();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable().toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
    }
}
