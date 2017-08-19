package com.testingdocs.examples.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TakeScreenShotOnAssertFail {

	private CustomAssertion m_custom;
	public static WebDriver driver ;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.edge.driver", "drivers/MicrosoftWebDriver.exe");
		driver=new EdgeDriver();
		m_custom = new CustomAssertion(driver);
	}

	@Test
	public void sampleTilteFailureTest()
	{
		driver.get("https://www.twitter.com");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.titleContains("Twitter"));
		m_custom.assertEquals("Facebook", driver.getTitle(),"Assert1");

		driver.get("https://www.bing.com");
		driver.manage().window().maximize();
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		wait1.until(ExpectedConditions.titleContains("Bing"));
		m_custom.assertEquals("NotFound", driver.getTitle(),"Assert2");

	}

	@Test
	public void sampleFailureTest()
	{
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.titleContains("Facebook"));
		m_custom.assertEquals("Bing", driver.getTitle(),"Assert3");

	}


	@AfterClass
	public void close() {
		driver.quit();
	}

}
