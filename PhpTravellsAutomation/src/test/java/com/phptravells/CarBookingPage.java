package com.phptravells;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.atmecs.phptravel.constant.FindLocator;
import com.phptravells.Driver.Driver_Class;
import com.phptravells.helper.CommonUtility;

import phptravellsdataprovider.PhpTravellsCarBookDataProvider;

public class CarBookingPage extends Driver_Class {

	FindLocator loc = new FindLocator();

	@Test(priority = 2, dataProvider ="CarBooking", dataProviderClass = PhpTravellsCarBookDataProvider.class)
	public void CarBookingpage(String sendkeyonpick, String senddepartdate, String sendkeydrop) {
		System.out.println("arjun");
		CommonUtility.clickElement(driver, loc.getlocator("clickOnPick"));
		CommonUtility.clickAndSendText(driver, loc.getlocator("sendkeyonpick"), 3, sendkeyonpick);
		CommonUtility.clickElement(driver, "//*[@id=\\\"select2-drop\\\"]/ul/li/div/span");
	    driver.findElement(By.xpath("(//span[@class=\"select2-chosen\"])[2]")).click();
     	driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("Manchester");//pick_cation
		driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li/div/span")).click();
		driver.findElement(By.xpath("//input[@id=\"departcar\"]")).click();
	
		
		
		CommonUtility.clickElement(driver, loc.getlocator("clickonpick"));
		CommonUtility.clearElement(driver, loc.getlocator("cleardepartdate"));
		CommonUtility.clickAndSendText(driver,loc.getlocator("senddepartdate"), 2, senddepartdate);
		CommonUtility.clickElement(driver, loc.getlocator("senddepartdate"));
		CommonUtility.clickElement(driver, loc.getlocator("selectonthepicktime"));
		CommonUtility.clearElement(driver, loc.getlocator("clickonpicktime"));
		CommonUtility.clickAndSendText(driver, loc.getlocator("sendkeydrop"), 2, sendkeydrop);
		CommonUtility.clickElement(driver, loc.getlocator("clickondrop"));
		CommonUtility.clickElement(driver, loc.getlocator("clickondroptime"));
		CommonUtility.clickElement(driver, loc.getlocator("selectthetimedrop"));
		CommonUtility.clickElement(driver, loc.getlocator("selectdroptime"));
		CommonUtility.clearElement(driver, loc.getlocator("clickonsearch"));
		CommonUtility.clickElement(driver, loc.getlocator("clickondeatils"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		CommonUtility.clickElement(driver, loc.getlocator("clickonbooknow"));
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("window.scrollBy(0,1000)");
		CommonUtility.clickElement(driver, loc.getlocator("confirmthisbooking"));

	}

}
