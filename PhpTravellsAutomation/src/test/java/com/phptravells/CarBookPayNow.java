package com.phptravells;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.atmecs.phptravel.constant.FindLocator;

import com.phptravells.Driver.Driver_Class;
import com.phptravells.helper.CommonUtility;
import com.phptravellsdataprovider.PhptravellDataProviderPayNow;

/**
 * 
 * @author Mohit.Jaiswal
 *
 */
public class CarBookPayNow extends Driver_Class {
	Logger logge;
	FindLocator loc = new FindLocator();
/**
 * 
 * @param fname
 * @param lname
 * @param cardno
 * @param cvvno
 */
	@Test(priority = 4, dataProvider = "CartwoBookingpaynow", dataProviderClass = PhptravellDataProviderPayNow.class)
	public void carTwoBookingPayNow(String fname, String lname, String cardno, String cvvno) {

		System.out.println("m");
		logge = Logger.getLogger(CarBookPayNow.class); // log4j implementation for storing the result
		logge.info("CarBooked with PayNow  ");
    try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		CommonUtility.clickElement(driver, loc.getlocator("Paynow"));
		// CommonUtility.clickElement(driver,loc.getlocator("clickonpaymethod") );
		Select drop = new Select(driver.findElement(By.xpath(loc.getlocator("selectpaycard"))));
		drop.selectByVisibleText("Credit Card");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CommonUtility.clickAndSendText(driver, loc.getlocator("fname"), 2, fname);
		CommonUtility.clickAndSendText(driver, loc.getlocator("lname"), 2, lname);
		// CommonUtility.clickAndSendText(driver, loc.getlocator("cardnumber") ,cardno);
		CommonUtility.clickAndSendText(driver, loc.getlocator("cardnumber"), 3, cardno);
		JavascriptExecutor jss2 = (JavascriptExecutor) driver;
		jss2.executeScript("window.scrollBy(0,500)");
		CommonUtility.clickElement(driver, loc.getlocator("clickonexpirydate"));
		CommonUtility.clickElement(driver, loc.getlocator("select2023"));
		CommonUtility.clickAndSendText(driver, loc.getlocator("cvvno"), 2, cvvno);
		CommonUtility.clickElement(driver, loc.getlocator("clickbtnpaynow"));
		logge=Logger.getLogger(CarBookPayNow.class);  // log4j implementation for storing the result 
		logge.info(" car two booked by paynow option  ");


		CommonUtility.clickElement(driver, loc.getlocator("clickcaragain"));
		logge = Logger.getLogger(CarBookPayNow.class); // log4j implementation for storing the result
		logge.info("Back to  homePage ");
		CommonUtility.clickElement(driver, loc.getlocator("ClickDemo"));

		CommonUtility.clickElement(driver, loc.getlocator("ClickAccount"));

		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);

		Assert.assertTrue(driver.getTitle().equals("My Account"));
		System.out.println("validate that the car is presnt  in  the booking tab");

		WebElement car1 = driver.findElement(By.xpath(loc.getlocator("car1namevalid")));// validate the first car name in booking
		String strcarmatch2 = car1.getText();
		System.out.println(strcarmatch2);

		WebElement car2 = driver.findElement(By.xpath(loc.getlocator("car2namevalid")));
		String strcarmatch1 = car2.getText();
		System.out.println(strcarmatch1);

		CommonUtility carr = new CommonUtility();

		carr.verify(CarFirstBookingPayArrival.strronecar, strcarmatch1.toUpperCase(), "not correct");
		carr.verify(CarTwoBooking.strrtwocar, strcarmatch2.toUpperCase(), "not correct");


		logge = Logger.getLogger(CarBookPayNow.class); // log4j implementation for storing the result
		logge.info("shows the  car in the Booking tab ");
	}

/**
 * quitdown method  to quit the browser
 */
	@AfterClass
	public void quitDown() {

		driver.quit();// close the browser_window
		logge = Logger.getLogger(CarBookPayNow.class); // log4j implementation for storing the result
		logge.info("close the browser ");
	}

}
