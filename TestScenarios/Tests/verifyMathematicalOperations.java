package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import executor.BaseTest;
import gui.page.android.CalculatorPage;



public class verifyMathematicalOperations extends BaseTest{	
		
	CalculatorPage objCalculatorPage= new CalculatorPage();
	
	@Test
    public void testAddition() {	
		// Enter the first number
		objCalculatorPage.enterNumber("17");
		// Click on the plus operator
		objCalculatorPage.clickPlus();
		// Enter the second number
		objCalculatorPage.enterNumber("27");
		 // Click equals
		objCalculatorPage.clickEquals();
		 // Get the result
		String result=objCalculatorPage.getFinalRsult();
		 // Assert the result
		Assert.assertEquals(result, "44", "The result of 17 + 27 should be 44");		 
    }
	
	@Test
    public void testSubtraction() {		       
		// Enter the first number
		objCalculatorPage.enterNumber("9");
		// Click on the minus operator
		objCalculatorPage.clickMinus();
		// Enter the second number
		objCalculatorPage.enterNumber("7");
		// Click equals
		objCalculatorPage.clickEquals();
		 // Get the result
		String result=objCalculatorPage.getFinalRsult();
		 // Assert the result
		Assert.assertEquals(result, "2", "The result of 9 - 7 should be 2");	
    }
	
	@Test
    public void testMultiply() {	       
		// Enter the first number
		objCalculatorPage.enterNumber("7");
		// Click on the multiply operator
		objCalculatorPage.clickMultiply();
		// Enter the second number
		objCalculatorPage.enterNumber("7");
		// Click equals
		objCalculatorPage.clickEquals();
		// Get the result
		String result=objCalculatorPage.getFinalRsult();
		 // Assert the result
		Assert.assertEquals(result, "49", "The result of 7 * 7 should be 49");	
    }
	
	@Test
    public void testDivision() {		
		// Enter the first number
		objCalculatorPage.enterNumber("7");
		// Click on the division operator
		objCalculatorPage.clickDivide();
		// Enter the second number
		objCalculatorPage.enterNumber("7");
		// Click equals
		objCalculatorPage.clickEquals();
		// Get the result
		String result=objCalculatorPage.getFinalRsult();
		// Assert the result
		Assert.assertEquals(result, "1", "The result of 7 / 7 should be 1");	

    }

}
