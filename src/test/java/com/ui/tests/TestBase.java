package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;
	Logger logger = LoggerUtility.getlogger(this.getClass());
	private boolean isLambdaTest;

	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	@BeforeMethod(description = "Load the Homepage of the website")
	
	public void setUp(
			@Optional("chrome") String browser, 
			@Optional("false") boolean isLambdaTest,
			@Optional("false") boolean isHeadless, ITestResult result) {

		this.isLambdaTest = isLambdaTest;
//		System.out.println("Received browser parameter: " + browser);

		WebDriver lambdaDriver;
		if (isLambdaTest) {

			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);

		} else {
			// running on local machine
			logger.info("Loads the homepage of the website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}

	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "Tear down the browser")
	public void teadDown() {
		if (isLambdaTest) {
			LambdaTestUtility.quitSession(); // quit the browser session on lambda test
		} else {
			homePage.quit();
		}
	}

}
