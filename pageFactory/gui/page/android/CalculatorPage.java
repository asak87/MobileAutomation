package gui.page.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import utils.TestUtil;


public class CalculatorPage {	
	
	// Locators
	private By plusIcon= By.id("com.google.android.calculator:id/op_add");	
	private By minusIcon= By.id("com.google.android.calculator:id/op_sub");	
	private By multiplyIcon= By.id("com.google.android.calculator:id/op_mul");	
	private By divideIcon= By.id("com.google.android.calculator:id/op_div");	
	private By equalsIcon= By.id("com.google.android.calculator:id/eq");	
	private By finalResult= By.xpath("//android.widget.TextView[@resource-id='com.google.android.calculator:id/result_final']");	
	private By input= By.xpath("//android.widget.EditText[@content-desc='No formula']");	

	
	
	public void  enterNumber(String number) {	
		
		for(String digit :number.split("")){
			By ele=  By.xpath("//android.widget.ImageButton[@content-desc='"+digit+"']");
			TestUtil.click(ele, number);
		}
	}
	
	public void enterNumberDirect(String number) {		
		
	TestUtil.sendKeys(input, number, "Enter number directly");
			
	}
	
		
	public void clickPlus() {
		
		TestUtil.click(plusIcon, "Plus");
		
	}
	
	public void clickMinus() {
		
		TestUtil.click(minusIcon, "Minus");
		
	}
	
	public void clickMultiply() {
		
		TestUtil.click(multiplyIcon, "Multiply");
		
	}
	
	public void clickDivide() {
		
		TestUtil.click(divideIcon, "Divide");
		
	}
	
	public void clickEquals() {
		
		TestUtil.click(equalsIcon, "Equals");
		
	}
	
	public  String getFinalRsult() {
		
		
		return TestUtil.getText(finalResult, "Final result");
		
		
	}
	

}
