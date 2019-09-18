package com.phptravellsdataprovider;

import org.testng.annotations.DataProvider;

import com.atmecs.phptravel.constant.FileConstant;
import com.phptravell.util.ProviderData;

public class CarBookingTwoDataProvider {

/**
 * Data provider to bookcartwo
 * @return
 */
	@DataProvider(name = "CartwoBooking")
	public Object[][] getData() {
		ProviderData provideData = new ProviderData(FileConstant.carbookingtwodataprovider);
		Object[][] getData = provideData.provideData();
		return getData;
	}
	/**
	 * Read the data from xlsx file for cartwo
	 * @param args
	 */
	public static void main(String[] args) {

		Object[][] data = new CarBookingTwoDataProvider().getData();// cartwo booking data 
		for (Object[] objects : data) {
			String secsendkeyonpick = (String) objects[0];
			String secsenddepartdate = (String) objects[1];
			String secsendkeydrop = (String) objects[2];
			System.out.println(" " + secsendkeyonpick + "   " + secsenddepartdate + " "+ secsendkeydrop);

		}

	}
}
