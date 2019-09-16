package com.phptravells.script;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.phptravel.constant.FindLocator;

import com.phptravells.Driver.Driver_Class;
import com.phptravells.helper.CommonUtility;
import com.phptravellsdataprovider.PhpTravellsCarBookPayArrivalDataProvider;
/**
 * 
 * @author Mohit.Jaiswal
 *
 */

public class CarFirstBookingPayArrival extends Driver_Class {
	Logger logge;
	FindLocator loc = new FindLocator();
	static String strronecar;
	Date date = new Date();

	/**
	 * 
	 * @param sendkeyonpick
	 * @param senddepartdate
	 * @param sendkeydrop
	 * @throws InterruptedException
	 */
	@Test(priority = 2, dataProvider = "CarBooking", dataProviderClass = PhpTravellsCarBookPayArrivalDataProvider.class)
	public void carBookinPayArrival(String sendkeyonpick, String senddepartdate, String sendkeydrop)
			throws InterruptedException {

		logge = Logger.getLogger(CarFirstBookingPayArrival.class); // log4j implementation for storing the result
		logge.info("Enter to carBookinPayArrivalpage ");
       		
		Thread.sleep(2000);
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getlocator("clickpick1")))).click();
		CommonUtility.clickElement(driver, loc.getlocator("clickpick1"));
		CommonUtility.clickAndSendText(driver, loc.getlocator("sendkeyonpick"), 3, sendkeyonpick);

		CommonUtility.clickElement(driver, loc.getlocator("clickonpick"));

		CommonUtility.clearElement(driver, loc.getlocator("cleardepartdate"));
		CommonUtility.clickAndSendText(driver, loc.getlocator("senddepartdate"), 2, senddepartdate);
		CommonUtility.clickElement(driver, loc.getlocator("senddepartdate"));
		CommonUtility.clickElement(driver, loc.getlocator("departclick"));

		CommonUtility.clickElement(driver, loc.getlocator("selectonthepicktime"));
		CommonUtility.clickElement(driver, loc.getlocator("clickonpicktime"));
		CommonUtility.clearElement(driver, loc.getlocator("clickondropdate"));
		CommonUtility.clickAndSendText(driver, loc.getlocator("sendkeydrop"), 2, sendkeydrop);
		CommonUtility.clickElement(driver, loc.getlocator("clickondrop"));
		CommonUtility.clickElement(driver, loc.getlocator("clickondroptime"));
		CommonUtility.clickElement(driver, loc.getlocator("selectthetimedrop"));
		CommonUtility.clickElement(driver, loc.getlocator("selectdroptime"));
		CommonUtility.clickElement(driver, loc.getlocator("clickonsearch"));
		CommonUtility.clickElement(driver, loc.getlocator("clickondeatils"));
		//		JavascriptExecutor js = (JavascriptExecutor) driver;
		//		js.executeScript("window.scrollBy(0,900)");

		// for scroll down to click booknow 
		WebElement amtcar1=driver.findElement(By.xpath(loc.getlocator("totalamt1")));
		String srtamt1 = amtcar1.getText();
		System.out.println(srtamt1);
		
		WebElement amtdepnow = driver.findElement(By.xpath(loc.getlocator("deposit1")));
		String strdepositnow = amtdepnow.getText();
		System.out.println(strdepositnow);
		
		WebElement amtvat = driver.findElement(By.xpath(loc.getlocator("amountvat2")));
		String strvat = amtvat.getText();
		System.out.println(strvat);

		
		
		
		
		
		
		
		
		WebElement element = driver.findElement(By.xpath(loc.getlocator("booknowjs")));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", element);// javascript executor for scroll down

		WebElement eleme = driver.findElement(By.xpath(loc.getlocator("getcarname")));// get the car anme for validation
		strronecar = eleme.getText();
		System.out.println(strronecar);
		WebElement picktm = driver.findElement(By.xpath(loc.getlocator("getcartmpick")));//get the picktm
		String  strrpicktime = picktm.getText();
		System.out.println(strrpicktime);

		WebElement droptm = driver.findElement(By.xpath(loc.getlocator("getcartmdrp")));
		String strrdrptm=droptm.getText();
		System.out.println(strrdrptm);

		CommonUtility.clickElement(driver, loc.getlocator("clickonbooknow"));
		JavascriptExecutor jss = (JavascriptExecutor) driver;

		jss.executeScript("window.scrollBy(0,900)");
		CommonUtility.clickElement(driver, loc.getlocator("confirmthisbooking"));
		CommonUtility.clickElement(driver, loc.getlocator("click_on_payonarrival"));
	//	 CommonUtility.clickElement(driver,loc.getlocator("click_on_payonarrival"));// for firefox uncomment it .

		// driver.manage().timeouts().implicitlyWait(000, TimeUnit.SECONDS);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	

		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		System.out.println("before");
		WebElement ele = driver.findElement(By.xpath(loc.getlocator("getlocation")));// validate the pick location
		String strr = ele.getText();
		String date = ele.getAttribute("innerHTML");
		CommonUtility car = new CommonUtility();
		car.verify(strr, sendkeyonpick, "placenotmatch");
		
		
		
		WebElement pickdate = driver.findElement(By.xpath(loc.getlocator("getpickdate")));//validate the pickdate
		String strr1 = pickdate.getText();
		car.verify(strr1, senddepartdate, "date is not correct");
		WebElement dropdate = driver.findElement(By.xpath(loc.getlocator("getpickdate2")));//validate the dropdate 
		String strr2 = dropdate.getText();
		car.verify(strr2, sendkeydrop, "date is not   correct");

		Thread.sleep(1000);

		WebElement strrpicktmm = driver.findElement(By.xpath(loc.getlocator("getpicktm")));//validate the picktime
		String strrpicktmm1= strrpicktmm.getText();
		car.verify(strrpicktime,strrpicktmm1 , "incorrect picktime");

		WebElement strrdroptmm = driver.findElement(By.xpath(loc.getlocator("getdroptm")));//validate the droptime 
		String Strrdroptm1 = strrdroptmm.getText();
		car.verify(strrdrptm,Strrdroptm1 , "incorrect droptime");
		
		WebElement amtdeposit = driver.findElement(By.xpath(loc.getlocator("depositamoutinvoice1")));
		String  inr_Strdepositnow = amtdeposit.getText();
		inr_Strdepositnow = CommonUtility.removeINR(inr_Strdepositnow);
		System.out.println(inr_Strdepositnow);
		 
		WebElement arramtvat = driver.findElement(By.xpath(loc.getlocator("amountvat1")));
		String arrstrvat = arramtvat.getText();
		System.out.println(arrstrvat);
		arrstrvat=CommonUtility.removeINR(arrstrvat);
		System.out.println(arrstrvat);
		
		WebElement amttotal = driver.findElement(By.xpath(loc.getlocator("totalamount1")));
		String arrstrtotal =amttotal.getText();
		System.out.println(arrstrtotal);
		arrstrtotal=CommonUtility.removeINR(arrstrtotal);
		System.out.println(arrstrtotal);
		LocalDate date1 = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String t=date1.format(formatter);
		System.out.println(t);
		
		
		
		WebElement todaydate2 = driver.findElement(By.xpath(loc.getlocator("todaydate2")));
		String todaydate = todaydate2.getText();
		System.out.println(todaydate);
		
		 
		car.verify(strdepositnow,inr_Strdepositnow , "not matched");
		car.verify(strvat, arrstrvat, "not matched");
		car.verify(srtamt1, arrstrtotal, "not matched");
		car.verify(t, todaydate, "not correct");
		
		

		logge = Logger.getLogger(CarFirstBookingPayArrival.class); // log4j implementation for storing the result
		logge.info("Car booked by the payArrival ");
		
		
		

	}

}
