package executor;


import io.appium.java_client.android.AndroidDriver;
import utils.ConfigReader;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;


import java.net.URL;
import java.util.concurrent.TimeUnit;


public class BaseTest {
	
	
    public static AndroidDriver driver;   
  

    @BeforeSuite
    public void setUp() throws Exception {
    	try {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Read capabilities from the config.properties file
        capabilities.setCapability("platformName", ConfigReader.getPlatformName());       
        capabilities.setCapability("deviceName", ConfigReader.getDeviceName());      
        capabilities.setCapability("app", ConfigReader.getAppPackage());      
        capabilities.setCapability("automationName", ConfigReader.getAutomationName());   
        
        // Initialize the driver
        driver = new AndroidDriver(new URL("http://localhost:4723/"), capabilities);
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
    }catch (Exception e) {
            System.err.println("Error initializing AndroidDriver: " + e.getMessage());
            throw new RuntimeException(e);
        }
      
    }
    
    @BeforeMethod
    public void launchAPP() {
    	 // Launch the calculator app
    	driver.activateApp("com.google.android.calculator"); 
    }
    
    @AfterMethod
    public void resetApp() {
    	  // Terminate the calculator app to reset its state
    	driver.terminateApp("com.google.android.calculator");  	
    }    
    
    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }   	

}

