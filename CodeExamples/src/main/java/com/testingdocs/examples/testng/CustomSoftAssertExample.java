package com.testingdocs.examples.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CustomSoftAssertExample {
	public WebDriver driver;
	CustomSoftAssert csa;

	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.edge.driver", "drivers/MicrosoftWebDriver.exe");
		driver=new EdgeDriver();
		csa = new CustomSoftAssert(driver);
	}

	// Comments on www.TestingDocs.com to show all failed asserts..
	@Test
	public void sampleTilteFailureTests()
	{
		driver.get("https://www.bing.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.titleContains("Bing"));
		csa.assertEquals("BogusTitle", driver.getTitle(),"Assert1,this will fail");

		driver.get("https://start.duckduckgo.com/");
		driver.manage().window().maximize();
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		wait1.until(ExpectedConditions.titleContains("Duck"));
		csa.assertEquals("BogusTitle", driver.getTitle(),"Assert2,this too will fail");
		csa.assertAll();

	}

	@AfterClass
	public void closeBrowser(){
		if(driver!=null){
			driver.quit();
		}
	}

}
