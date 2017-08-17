package com.testingdocs.examples.selenium.chrome;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChromeBrowserExample {
	 private WebDriver driver;

	@Test
	 public void sampleTest() {
	 driver.get("https://www.google.com");
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 Assert.assertEquals(driver.getTitle(), "Google", "I'm verifying window title here in this test");

	}

	@BeforeClass
	 public void beforeClass() {
	 System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	 driver = new ChromeDriver();
	 }

	@AfterClass
	 public void afterClass() {
	 if(driver != null)
	 {
	 driver.quit();
	 }
	 }

	}


