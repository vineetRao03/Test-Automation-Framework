package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase{
	
	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	private AddressPOJO address;
	@BeforeMethod(description = "Valid first time User logs into the application")
	public  void setUp() {
		myAccountPage= homePage.goToLoginPage().doLoginWith("kiliwaf467@codverts.com", "password");
		address= FakeAddressUtility.getFakeAddress();
		
	}
	@Test
	public void addNewAddress() {
		String newAddress= myAccountPage.goToAddAddressPage().saveAddress(address);
		Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
	}
	
	

}
