package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReport implements ITestListener {

    private ExtentReports extent;
    private static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        // Initialize ExtentReports
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a test entry in the report
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log test passed in report
        test.pass("Test passed");
        
        test.addScreenCaptureFromPath(TestUtil.captureScreenshot(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log test failure in report
        test.fail("Test failed");

        test.addScreenCaptureFromPath(TestUtil.captureScreenshot(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log test skipped in report
        test.skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Write the final report
        extent.flush();
    }
    
    public static ExtentTest getTest() {
		return test;
	}

   
   
}
