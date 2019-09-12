package com.phptravells;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.atmecs.phptravel.constant.FindLocator;
import com.phptravells.Driver.Driver_Class;
import com.phptravells.helper.CommonUtility;

import phptravellsdataprovider.PhptravellDataProviderPayNow;

public class CarBookPayNow  extends Driver_Class{

	FindLocator loc = new FindLocator();

	@Test(priority = 4, dataProvider = "CartwoBookingpaynow", dataProviderClass = PhptravellDataProviderPayNow.class)
	public void carTwoBookingpaynow(String fname, String lname, String cardno, String cvvno) {
		
		System.out.println("m");
		CommonUtility.clickElement(driver, loc.getlocator("Paynow"));
	//	CommonUtility.clickElement(driver,loc.getlocator("clickonpaymethod") );
		Select drop= new Select(driver.findElement(By.xpath("//select[@name=\"gateway\"]")));
		drop.selectByVisibleText("Credit Card");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CommonUtility.clickAndSendText(driver,loc.getlocator("fname") , 2, fname);
		CommonUtility.clickAndSendText(driver, loc.getlocator("lname"), 2, lname);
		//CommonUtility.clickAndSendText(driver, loc.getlocator("cardnumber") ,cardno);
		CommonUtility.clickAndSendText(driver, loc.getlocator("cardnumber"), 3,cardno );
		JavascriptExecutor jss2 = (JavascriptExecutor) driver;
		jss2.executeScript("window.scrollBy(0,1000)");
	    CommonUtility.clickElement(driver, loc.getlocator("clickonexpirydate"));
	    CommonUtility.clickElement(driver,loc.getlocator("select2023"));
	  CommonUtility.clickAndSendText(driver,loc.getlocator("cvvno") , 2, cvvno);
	    CommonUtility.clickElement(driver, loc.getlocator("clickbtnpaynow"));
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    CommonUtility.clickElement(driver, loc.getlocator("clickcaragain"));
	    CommonUtility.clickElement(driver, "(//a[@class=\"dropdown-toggle go-text-right\"])[3]");
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    CommonUtility.clickElement(driver, "(//a[text()='  Account'])[2]");
	    
	    
	    
	    
	
	}
	
	
	
	
}
