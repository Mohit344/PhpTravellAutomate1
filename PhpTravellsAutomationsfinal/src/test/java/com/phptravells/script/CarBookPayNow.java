package com.phptravells.script;
import java.util.Date;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.atmecs.phptravel.constant.FindLocator;
import com.phptravells.driver.Driver_Class;
import com.phptravells.pages.CarBookPayNowFlow;
import com.phptravellsdataprovider.PhptravellDataProviderPayNow;

/**
 * 
 * @author Mohit.Jaiswal
 *
 */
public class CarBookPayNow extends Driver_Class {
	Logger logge;
	FindLocator loc = new FindLocator();
	Date date = new Date();

	/**
	 * 
	 * @param fname
	 * @param lname
	 * @param cardno
	 * @param cvvno
	 */
	@Test(priority = 4, dataProvider = "CartwoBookingpaynow", dataProviderClass = PhptravellDataProviderPayNow.class)
	public void carTwoBookingPayNow(String fname, String lname, String cardno, String cvvno) {
		logger=extent.startTest("cartwopaynow");
		// System.out.println("m");
		logge = Logger.getLogger(CarBookPayNow.class); // log4j implementation for storing the result
		logge.info("CarBooked with PayNow  ");
		
		CarBookPayNowFlow.carBookingPayNow(fname, lname, cardno, cvvno, driver, loc);
	}
}
