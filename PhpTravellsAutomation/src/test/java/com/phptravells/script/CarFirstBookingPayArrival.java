package com.phptravells.script;

import java.util.Date;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.atmecs.phptravel.constant.FindLocator;
import com.phptravells.driver.Driver_Class;
import com.phptravells.pages.CarFirstBookingPayArrivalFlow;
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

		logger=extent.startTest("carbookingPayaOn Arrival");
		
		logge = Logger.getLogger(CarFirstBookingPayArrivalFlow.class); // log4j implementation for storing the result
		logge.info("Enter to carBookinPayArrivalpage ");
		CarFirstBookingPayArrivalFlow.carFirstPayArrival1(sendkeyonpick, senddepartdate, sendkeydrop, driver, loc);
		
	}

}
