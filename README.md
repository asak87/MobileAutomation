## **Mobile Automation Testing Project**

This project is a mobile automation testing framework designed for Android applications using Appium, TestNG, and Java. 

## **Introduction**

This automation framework simplifies mobile app testing by providing reusable components, utilities, and reporting. The framework supports:

1.  Performing mathematical operations
2.  Validating user interactions using robust test scripts
3.  Providing detail reports using Extent Reports

## **Technologies Used**

1. Programming Language: Java
2. Testing Framework: TestNG
3. Automation Framework: Appium
4. Build Tool: Maven
5. Reporting: Extent Reports
6. Version Control: Git and GitHub

## **Installation**

**Prerequisites**
1. Install Java JDK 11+.
2. Install Maven.
3. Install Appium Server.
4. Install an Android Emulator or connect a physical Android device.
5. Install Git.

**Setup**
1. Clone the repository.
2. Navigate to project dir.
3. Install dependencies: mvn clean install.
4. Update config.prop in resource folder with desired configurations.

## **To Run Tests**
- Run All Tests: mvn test
- Run a Specific Test: mvn test -DsuiteXmlFile=src/test/resources/testng.xml
