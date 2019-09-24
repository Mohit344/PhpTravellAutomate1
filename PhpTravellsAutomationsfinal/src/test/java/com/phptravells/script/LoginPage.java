package com.phptravells.script;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.atmecs.phptravel.constant.FindLocator;
import com.phptravells.driver.Driver_Class;
import com.phptravells.pages.LoginPageFlow;
import com.phptravellsdataprovider.PhpTravellsLoginDataProvider;

public class LoginPage extends Driver_Class {

	Logger logge ;

	FindLocator loc=new FindLocator();
	/**
	 *  login method to login to website
	 * @param Emailid
	 * @param Password
	 */

	@Test(priority = 1, dataProvider = "logininput", dataProviderClass = PhpTravellsLoginDataProvider.class)
	public void loginPage(String Emailid, String Password)
	{
		logger=extent.startTest("loginpassed");
		logge=Logger.getLogger(LoginPage.class);  // log4j implementation for storing the result 
		logge.info(" enter in login page ");
		LoginPageFlow.login(Emailid, Password, driver, loc);
	}

}
