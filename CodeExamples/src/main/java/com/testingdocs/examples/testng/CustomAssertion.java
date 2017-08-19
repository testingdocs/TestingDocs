package com.testingdocs.examples.testng;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;

public class CustomAssertion extends Assertion {
	WebDriver driver;

	public CustomAssertion(WebDriver driver) 
	{
		this.driver=driver; 
	}

	@Override
	public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
		// TakingScreen here
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("images/AssertFailure_" + assertCommand.getMessage()+ ".jpg"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}


}
