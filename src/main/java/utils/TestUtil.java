package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import executor.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class TestUtil  {
	
//	public static AndroidDriver driver;   
	
	public static AndroidDriver driver =BaseTest.driver;
	
	 		
	/**
     * Capture a screenshot and save it with a timestamp.
     * 
     * @param screenshotName The name to give to the screenshot file.
     * @return The path where the screenshot was saved.
     */
    public static String captureScreenshot(String screenshotName) {
    	
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotFileName = screenshotName + "_" + timestamp + ".png";
        String screenshotPath =System.getProperty("user.dir")+ "/test-output/screenshots/" + screenshotFileName;

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Save the screenshot to the specified path
        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
            System.out.println("Screenshot saved at: " + screenshotPath);
        } catch (IOException e) {
            System.out.println("Error saving screenshot: " + e.getMessage());
        }

        return screenshotPath;
    }
		
	
	  /**
     * Click on an element with the specified locator.
     *
     * @param elementClick Locator for the element to be clicked.
     * @param elementName  The name of the element (for logging purposes).
     */
    public static void click(By elementClick, String elementName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(elementClick));
            driver.findElement(elementClick).click();
            System.out.println("Step Passed: Clicked on the Element: " + elementName);

            captureScreenshot("click_action");
            ExtentReport.getTest().log(Status.PASS, "Clicked on the element: " + elementName);

        } catch (NoSuchElementException | TimeoutException | ElementNotInteractableException e) {
            System.out.println("Step Failed: NOT Clicked on the Element: " + elementName);
            ExtentReport.getTest().log(Status.FAIL, "Failed to click on the element: " + elementName);
            throw e;
        }
    }
		
	
	 /**
     * Send keys to an element with the specified locator.
     *
     * @param element     Locator for the element to send keys to.
     * @param value       The value to be sent to the element.
     * @param elementName The name of the element (for logging purposes).
     */
    public static void sendKeys(By element, String value, String elementName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            driver.findElement(element).sendKeys(value);
            System.out.println("Step Passed: Entered data '" + value + "' successfully in " + elementName);

            captureScreenshot("send_keys_action");
            ExtentReport.getTest().log(Status.PASS, "Entered data '" + value + "' successfully in " + elementName);

        } catch (NoSuchElementException | TimeoutException | ElementNotInteractableException e) {
            System.out.println("Step Failed: Failed to enter data '" + value + "' in " + elementName);
            ExtentReport.getTest().log(Status.FAIL, "Failed to enter data '" + value + "' in " + elementName);
            throw e;
        }
    }
	
	
	/**
     * Get the text of an element with the specified locator.
     *
     * @param element     Locator for the element to get text from.
     * @param elementName The name of the element (for logging purposes).
     * @return The text of the element.
     */
    public static String getText(By element, String elementName) {
        String text = null;
        try {
            text = driver.findElement(element).getText();
            System.out.println("Step Passed: Captured text for " + elementName + " is: " + text);
            ExtentReport.getTest().log(Status.PASS, "Captured text for" + elementName);
        } catch (Exception e) {
            System.out.println("Step Failed: Failed to capture text for " + elementName);
            ExtentReport.getTest().log(Status.FAIL, "Failed to capture text for " + elementName);
            throw e;
        }
        return text;
    }
	


}
