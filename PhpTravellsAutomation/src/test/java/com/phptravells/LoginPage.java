package com.phptravells;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.atmecs.phptravel.constant.FindLocator;
import com.phptravells.Driver.Driver_Class;
import com.phptravells.helper.CommonUtility;

import phptravellsdataprovider.PhpTravellsLoginDataProvider;

public class LoginPage extends Driver_Class {

	
	FindLocator loc=new FindLocator();
	/** 
	 * This method is used to Setup  the file-locators.properties . 
	 * driver.manage() is call to maximize the Browser_window and deleteAllCookies
	 * implicitwait method is use to wait the browser till the all properties file get upload.
	 * 
	 */
  
	
		
	
	@Test(priority = 1, dataProvider = "logininput", dataProviderClass = PhpTravellsLoginDataProvider.class)
	public void homePage(String Emailid, String Password)
{
	CommonUtility.clickElement(driver,loc.getlocator("My_Account"))	;
	CommonUtility.clickElement(driver,loc.getlocator("Login"));
	CommonUtility.clickAndSendText(driver,loc.getlocator("Emailid") ,2,Emailid);
	CommonUtility.clickAndSendText(driver,loc.getlocator("Password") ,2, Password);
	CommonUtility.clickElement(driver,loc.getlocator("Loginbtn"));
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	CommonUtility.clickElement(driver,loc.getlocator("carnav"));
	
	
}
	
	
	
	
}
