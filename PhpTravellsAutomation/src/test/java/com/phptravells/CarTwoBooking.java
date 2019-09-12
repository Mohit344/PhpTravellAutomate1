package com.phptravells;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.atmecs.phptravel.constant.FindLocator;
import com.phptravells.Driver.Driver_Class;
import com.phptravells.helper.CommonUtility;

import phptravellsdataprovider.CarBookingTwoDataProvider;
import phptravellsdataprovider.PhpTravellsCarBookDataProvider;

public class CarTwoBooking  extends Driver_Class{
	

	FindLocator loc = new FindLocator();

	@Test(priority = 3, dataProvider = "CartwoBooking", dataProviderClass = CarBookingTwoDataProvider.class)
	public void carTwoBooking(String secsendkeyonpick, String secsenddepartdate, String secsendkeydrop) throws InterruptedException {
		System.out.println("mohit");
		Thread.sleep(3000);
	CommonUtility.clickElement(driver, loc.getlocator("clickcaragain"));
	CommonUtility.clickElement(driver, loc.getlocator("clickpick1"));
	CommonUtility.clickAndSendText(driver,loc.getlocator("sendkeyonpick") , 3, secsendkeyonpick);

	CommonUtility.clickElement(driver, loc.getlocator("clickonpick"));

	CommonUtility.clearElement(driver, loc.getlocator("cleardepartdate"));
	CommonUtility.clickAndSendText(driver, loc.getlocator("senddepartdate"), 2, secsenddepartdate);
	CommonUtility.clickElement(driver, loc.getlocator("senddepartdate"));
	CommonUtility.clickElement(driver, loc.getlocator("departclick"));
	
	CommonUtility.clickElement(driver, loc.getlocator("selectonthepicktime"));
	CommonUtility.clickElement(driver, loc.getlocator("clickonpicktime"));
	CommonUtility.clearElement(driver, loc.getlocator("clickondropdate"));
	CommonUtility.clickAndSendText(driver, loc.getlocator("sendkeydrop"), 2, secsendkeydrop);
	CommonUtility.clickElement(driver, loc.getlocator("clickondrop"));
	CommonUtility.clickElement(driver, loc.getlocator("clickondroptime"));
	CommonUtility.clickElement(driver, loc.getlocator("selectthetimedrop"));
	CommonUtility.clickElement(driver, loc.getlocator("selectdroptime"));
	CommonUtility.clickElement(driver, loc.getlocator("clickonsearch"));
	CommonUtility.clickElement(driver, loc.getlocator("clickondeatils"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	CommonUtility.clickElement(driver, loc.getlocator("clickonbooknow"));
	JavascriptExecutor jss = (JavascriptExecutor) driver;
	jss.executeScript("window.scrollBy(0,1000)");
	CommonUtility.clickElement(driver, loc.getlocator("confirmthisbooking"));
	
	

}}