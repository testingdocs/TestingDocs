package com.testingdocs.examples.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class WebElementHighlighter extends AbstractWebDriverEventListener {


	public void beforeFindBy(By by, WebElement element, WebDriver driver){

		WebElement webelement = driver.findElement(by);

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='5px solid blue'", webelement);
		}
		
		File scrFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("images/HighlighterScreenCapture"  + currentTime() + ".jpg"));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public String currentTime()
	{
		Date todayDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy_HHmmss");
		String formattDate = formatter.format(todayDate);
		return formattDate;

	}
}