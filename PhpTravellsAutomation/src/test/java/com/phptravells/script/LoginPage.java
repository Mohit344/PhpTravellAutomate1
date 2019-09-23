package com.phptravells.script;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.atmecs.phptravel.constant.FindLocator;
import com.phptravells.driver.Driver_Class;
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
		logger=extent.startTest("loginpassed");
		logge=Logger.getLogger(LoginPage.class);  // log4j implementation for storing the result 
		logge.info(" enter in login page ");
		CommonUtility.clickElement(driver, loc.getlocator("removefrome"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CommonUtility.clickElement(driver, loc.getlocator("gotitcokie"));
		CommonUtility.clickElement(driver,loc.getlocator("My_Account"))	;
		CommonUtility.clickElement(driver,loc.getlocator("Login"));
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		CommonUtility.clickAndSendText(driver,loc.getlocator("Emailid") ,2,Emailid);
		CommonUtility.clickAndSendText(driver,loc.getlocator("Password") ,2, Password);
		CommonUtility.clickElement(driver,loc.getlocator("Loginbtn"));
		logge=Logger.getLogger(LoginPage.class);  // log4j implementation for storing the result 
		logge.info("login page passed ");
		//	logger.log(LogStatus.PASS, "mohit");
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
			System.out.println("passed"); } 

		else {

			System.out.println("Test failed"); } 
		CommonUtility.clickElement(driver,loc.getlocator("carnav"));// navigate to  clickcar

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions action = new Actions(driver);
		WebElement wb = driver.findElement(By.xpath(loc.getlocator("changecurrency")));
		System.out.println(wb.getText());
		action.moveToElement(wb).build().perform();
		driver.findElement(By.linkText("INR")).click();
		//driver.findElement(By.xpath(loc.getlocator("changecurrencytoinr"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
