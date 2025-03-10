package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listerners.TestListener.class)
public class InvalidCredLoginTest extends TestBase {

	Logger logger = LoggerUtility.getlogger(this.getClass());
	private static final String EMAIL_ADDRESS = "jatinvsharma@gmail.com";
	private static final String PASSWORD = "Qwerty123";

	
	@Test(description = "Verifies if proper error message is shown for the user when they enter invalid credentials ", groups = {
			"e2e", "sanity" })

	public void loginTest() {

		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(EMAIL_ADDRESS, PASSWORD).getErrorMessage(),
				"Authentication failed.");

	}
}