package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    // Load the properties file
    static {
        try (FileInputStream inputStream = new FileInputStream("src/main/resources/_config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get a property by key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Get capability values
    public static String getPlatformName() {
        return getProperty("platformName");
    }

    public static String getDeviceName() {
        return getProperty("deviceName");
    }

    public static String getAppPackage() {
        return getProperty("app");
    }

    public static String getAutomationName() {
        return getProperty("automationName");
    }

    public static String getAppiumServerUrl() {
        return getProperty("appiumServerUrl");
    }
}
