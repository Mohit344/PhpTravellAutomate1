package com.phptravells;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.phptravel.constant.FindLocator;

import com.phptravells.Driver.Driver_Class;
import com.phptravells.helper.CommonUtility;
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
		logge=Logger.getLogger(LoginPage.class);  // log4j implementation for storing the result 
		logge.info(" enter in login page ");
		CommonUtility.clickElement(driver,loc.getlocator("My_Account"))	;
		CommonUtility.clickElement(driver,loc.getlocator("Login"));

		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		CommonUtility.clickAndSendText(driver,loc.getlocator("Emailid") ,2,Emailid);
		CommonUtility.clickAndSendText(driver,loc.getlocator("Password") ,2, Password);
		CommonUtility.clickElement(driver,loc.getlocator("Loginbtn"));
		logge=Logger.getLogger(LoginPage.class);  // log4j implementation for storing the result 
		logge.info("login page passed ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualUrl= "https://www.phptravels.net/account/";
		String expectedUrl= driver.getCurrentUrl();
		if(actualUrl.equalsIgnoreCase(expectedUrl))
		{ 
			  System.out.println("Test passed"); } 
		
		else {
			
			System.out.println("Test failed"); } 
		
		
		
//// validation of url lofin page for to navigate the to car 
//		String actualurl= "https://www.phptravels.net/account/";
//		String expectedurl= driver.getCurrentUrl();
//		Assert.assertEquals(actualurl,expectedurl);

		CommonUtility.clickElement(driver,loc.getlocator("carnav"));// navigate to  clickcar


	}


}
