package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners(com.ui.listerners.TestListener.class)
public class SearchProductTest extends TestBase {
	
	private MyAccountPage myAccountPage; 
	private static final String SEARCH_TERM= "Printed Summer Dress";
	
	
	@BeforeMethod(description = "Valid user logs into the application")
	
	public void setUp() {
		myAccountPage=homePage.goToLoginPage().doLoginWith("kiliwaf467@codverts.com", "password");
	}
	
	
	
	
	@Test(description = "Verify if the logged in user is able to search for a product and correct products search result are displayed",
			groups = {"e2e","Smoke ", "sanity" })
	public void verifyProductSeachTest() {
		
	boolean actualResult=	myAccountPage.SearchForAProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
		
	}
	
	

}
