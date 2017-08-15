package com.testingdocs.examples.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class SearchWeb { 
	public WebDriver webDriver = null; 
	public EventFiringWebDriver driver = null;  

	@Test 
	public void Search_Bing() throws Throwable {   
		webDriver = new FirefoxDriver();    
		driver = new EventFiringWebDriver(webDriver);   
		WebElementHighlighter highlighter = new WebElementHighlighter();
		driver.register(highlighter);     
		driver.navigate().to("https://www.bing.com"); 
		driver.findElement(By.id("sb_form_q")).clear();
		driver.findElement(By.id("sb_form_q")).sendKeys("https://www.testingDocs.com");
		driver.findElement(By.id("sb_form_go")).click();
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.titleContains("Bing"));
		Assert.assertTrue(true,"Sample Assert");  
	} 

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}