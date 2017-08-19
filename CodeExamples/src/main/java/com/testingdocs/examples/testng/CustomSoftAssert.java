package com.testingdocs.examples.testng;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.collections.Maps;


public class CustomSoftAssert extends Assertion {
	// LinkedHashMap to preserve the order
	private final Map<AssertionError, IAssert<?>> m_errors = Maps.newLinkedHashMap();
	WebDriver driver;

	public CustomSoftAssert(WebDriver driver) 
	{
		this.driver=driver; 
	}

	@Override
	protected void doAssert(IAssert<?> a) {
		onBeforeAssert(a);
		try {
			a.doAssert();
			onAssertSuccess(a);
		} catch (AssertionError ex) {
			onAssertFailure(a, ex);
			m_errors.put(ex, a);
		} finally {
			onAfterAssert(a);
		}
	}

	public void assertAll() {
		if (!m_errors.isEmpty()) {
			StringBuilder sb = new StringBuilder("The following asserts failed:");
			boolean first = true;
			for (Map.Entry<AssertionError, IAssert<?>> ae : m_errors.entrySet()) {
				if (first) {
					first = false;
				} else {
					sb.append(",");
				}
				sb.append("\n\t");
				sb.append(ae.getKey().getMessage());
			}
			throw new AssertionError(sb.toString());
		}
	}

	@Override
	public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex)
	{
		// TakingScreen here
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("images/SoftAssertFailure+" + assertCommand.getMessage()+ ".jpg"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
