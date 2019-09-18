package com.phptravells.script;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.atmecs.phptravel.constant.FindLocator;
import com.phptravells.Driver.Driver_Class;
import com.phptravells.helper.CommonUtility;
import com.phptravellsdataprovider.CarBookingTwoDataProvider;
import com.phptravellsvalidation.ValidationMethod;

public class CarTwoBooking extends Driver_Class {
	static String strrtwocar;
	static String srtamt2;
	static String strdepositnow2;
	static String strvat2;
	

	Logger logge;
	FindLocator loc = new FindLocator();

	/**
	 * 
	 * @param secsendkeyonpick
	 * @param secsenddepartdate
	 * @param secsendkeydrop
	 * @throws InterruptedException
	 */

	@Test(priority = 3, dataProvider = "CartwoBooking", dataProviderClass = CarBookingTwoDataProvider.class)
	public void carTwoBooking(String secsendkeyonpick, String secsenddepartdate, String secsendkeydrop)
			throws InterruptedException {
		
		logger=extent.startTest("CarTwoBooking");
		
		logge = Logger.getLogger(CarTwoBooking.class); // log4j implementation for storing the result
		logge.info("CarBooking Two starts ");
	
    
		//System.out.println("mohit");
		Thread.sleep(3000);
		CommonUtility.clickElement(driver, loc.getlocator("clickcaragain"));
		Actions action = new Actions(driver);
		WebElement wb = driver.findElement(By.xpath(loc.getlocator("changecurrency")));
		 action.moveToElement(wb).build().perform();
		 driver.findElement(By.linkText("INR")).click();
		
	//	CommonUtility.clickElement(loc.getlocator("loc.inrcurrency.btn"));
		//driver.findElement(By.xpath(loc.getlocator("changecurrencytoinr"))).click();
		
      try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
		CommonUtility.clickElement(driver, loc.getlocator("clickpick1"));
		Thread.sleep(1000);
		CommonUtility.clickAndSendText(driver, loc.getlocator("sendkeyonpick"), 3, secsendkeyonpick);
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

		WebElement getdata = driver.findElement(By.xpath(loc.getlocator("car2valid")));// get the car2 name for
																						// validation
		strrtwocar = getdata.getText();
		System.out.println(strrtwocar);

		WebElement getpicktm = driver.findElement(By.xpath(loc.getlocator("car2picktmvalid")));// get the car2 picktime
																								// for validation
		String strrpicktm = getpicktm.getText();
		System.out.println(strrpicktm);
		WebElement getdroptm = driver.findElement(By.xpath(loc.getlocator("car2drptmvalid")));// get the car2 drptime
																								// for validation
		String strrdrptm = getdroptm.getText();
		System.out.println(strrdrptm);
		
		WebElement amtcar2 = driver.findElement(By.xpath(loc.getlocator("totalamount2")));
		srtamt2 = amtcar2.getText();
		System.out.println(srtamt2);

		WebElement amtdepnow2 = driver.findElement(By.xpath(loc.getlocator("depositamount2")));
		strdepositnow2 = amtdepnow2.getText();
		System.out.println(strdepositnow2);

		WebElement amtvat2 = driver.findElement(By.xpath(loc.getlocator("amountvat2")));
		strvat2 = amtvat2.getText();
		System.out.println(strvat2);
		
		CommonUtility.clickElement(driver, loc.getlocator("clickonbooknow"));
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("window.scrollBy(0,1000)");
		CommonUtility.clickElement(driver, loc.getlocator("confirmthisbooking"));

		WebElement ele = driver.findElement(By.xpath(loc.getlocator("car2location")));// car2location validation
		String strr = ele.getText();
		//CommonUtility car = new CommonUtility();
		ValidationMethod car = new ValidationMethod();
		
		WebElement pickdate = driver.findElement(By.xpath(loc.getlocator("car2pickdate")));// car2pickdate validation
		String strr1 = pickdate.getText();
	
		WebElement dropdate = driver.findElement(By.xpath(loc.getlocator("car2drpdate")));
		String strr2 = dropdate.getText();

		WebElement strrtwopicktmm = driver.findElement(By.xpath(loc.getlocator("car2picktm"))); // car2picktm validation
		String strrtwopicktmm1 = strrtwopicktmm.getText();
		WebElement strrdroptmm = driver.findElement(By.xpath(loc.getlocator("car2drptm")));
		String Strrdroptm1 = strrdroptmm.getText();
		
		car.verify(strrdrptm, Strrdroptm1, "incorrect droptime");// drop time verifictaion 
		car.verify(strrpicktm, strrtwopicktmm1, "incorrect picktime");//picktime verification
		car.verify(strr, secsendkeyonpick, "placenotmatch");// pick location verifictaion 
		car.verify(strr1, secsenddepartdate, "date is not  correct");// departdate validation 
		car.verify(strr2, secsendkeydrop, "date is not   correct");// drop date verifictaion 
		
		
	}
}