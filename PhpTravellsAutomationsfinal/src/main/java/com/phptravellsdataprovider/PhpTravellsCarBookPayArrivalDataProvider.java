package com.phptravellsdataprovider;


import org.testng.annotations.DataProvider;

import com.atmecs.phptravel.constant.FileConstant;
import com.phptravell.util.ProviderData;

public class PhpTravellsCarBookPayArrivalDataProvider {

	@DataProvider(name = "CarBooking")
	public Object[][] getData() {
		ProviderData provideData = new ProviderData(FileConstant.CarBookingtestdataPatArrival);
		Object[][] getData = provideData.provideData();
		return getData;
	}
	/**
	 * read the data from xlsx file for car booking
	 * @param args
	 */
	public static void main(String[] args) {

		Object[][] data = new PhpTravellsCarBookPayArrivalDataProvider().getData();
		for (Object[] objects : data) {
			String sendkeyonpick = (String) objects[0];
			String senddepartdate = (String) objects[1];
			String sendkeydrop = (String) objects[2];
			System.out.println(" " + sendkeyonpick + "   " + senddepartdate + " "+ sendkeydrop);

		}

	}
}
