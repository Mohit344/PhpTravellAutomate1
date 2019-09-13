package com.phptravellsdataprovider;

import org.testng.annotations.DataProvider;

import com.phptravell.util.ProviderData;

public class PhptravellDataProviderPayNow {
/**
 * data provider is used
 * @return
 */


	@DataProvider(name = "CartwoBookingpaynow")
	public Object[][] getData() {
		ProviderData provideData = new ProviderData("./src/test/resources/Testdata/paynowDataProvider.xlsx");
		Object[][] getData = provideData.provideData();
		return getData;
	}
	/**
	 * read the data from .xlsx file
	 * @param args
	 */
	public static void main(String[] args) {

		Object[][] data = new PhptravellDataProviderPayNow().getData();
		for (Object[] objects : data) {
			String fname = (String) objects[0];
			String lname = (String) objects[1];
			String cardno = (String) objects[2];
			String cvvdno = (String) objects[3];
			System.out.println(" " + fname + "   " + lname + "  "+ cardno +"  "+cvvdno);

		}

	}


}
