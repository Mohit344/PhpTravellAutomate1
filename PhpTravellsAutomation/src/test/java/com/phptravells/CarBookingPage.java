package com.phptravells;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.phptravel.constant.FindLocator;
import com.phptravells.Driver.Driver_Class;
import com.phptravells.helper.CommonUtility;

import phptravellsdataprovider.PhpTravellsCarBookDataProvider;

public class CarBookingPage extends Driver_Class {

	FindLocator loc = new FindLocator();

	@Test(priority = 2, dataProvider = "CarBooking", dataProviderClass = PhpTravellsCarBookDataProvider.class)
	public void CarBookingpage(String sendkeyonpick, String senddepartdate, String sendkeydrop) {
		System.out.println("arjun");
		CommonUtility.clickElement(driver, loc.getlocator("clickpick1"));
		CommonUtility.clickAndSendText(driver,loc.getlocator("sendkeyonpick") , 3, sendkeyonpick);

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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		CommonUtility.clickElement(driver, loc.getlocator("clickonbooknow"));
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("window.scrollBy(0,1000)");
		CommonUtility.clickElement(driver, loc.getlocator("confirmthisbooking"));
		CommonUtility.clickElement(driver,loc.getlocator("click_on_payonarrival"));

		
		driver.switchTo().alert().accept();
		System.out.println("www");
		
	WebElement ele=driver.findElement(By.xpath("//*[@id=\"invoiceTable\"]/tbody/tr[4]/td/table/tbody/tr[2]/td/table[1]/tbody/tr[1]/td[2]"));
	String st=ele.getText();
    System.out.println(st);
      
   Assert.assertEquals(st,sendkeydrop );
     System.out.println("validate");
   WebElement pick= driver.findElement(By.xpath("//*[@id=\"invoiceTable\"]/tbody/tr[4]/td/table/tbody/tr[2]/td/table[1]/tbody/tr[3]/td[2]"));
   String picking=pick.getText();
  System.out.println(picking);
  Assert.assertEquals(picking,sendkeyonpick);
  System.out.println("validate the pick location");
  WebElement t1 = driver.findElement(By.xpath("//*[@id=\"invoiceTable\"]/tbody/tr[4]/td/table/tbody/tr[2]/td/table[1]/tbody/tr[6]/td[2]"));
  String picktime= t1.getText();
  System.out.println(picktime);
  WebElement pt = driver.findElement(By.xpath("selectonthepicktime"));
  String pt1=pt.getText();
  System.out.println(pt1);
Assert.assertEquals(pt1,picktime );  
		
		
		
		driver.quit();
		
	}

}
