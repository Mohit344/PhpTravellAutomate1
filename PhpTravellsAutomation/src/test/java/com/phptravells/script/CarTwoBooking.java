package com.phptravells.script;

import org.apache.log4j.Logger;


import org.testng.annotations.Test;

import com.atmecs.phptravel.constant.FindLocator;
import com.phptravells.driver.Driver_Class;

import com.phptravells.pages.CarTwoBookingFlow;
import com.phptravellsdataprovider.CarBookingTwoDataProvider;


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
		CarTwoBookingFlow.CarTwoBooking1(secsendkeyonpick, secsenddepartdate, secsendkeydrop, driver, loc);
	}}