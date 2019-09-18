package com.phptravellsdataprovider;

import org.testng.annotations.DataProvider;

import com.atmecs.phptravel.constant.FileConstant;
import com.phptravell.util.ProviderData;

public class PhpTravellsLoginDataProvider {


	@DataProvider(name = "logininput")
	public Object[][] getData() {
		ProviderData provideData = new ProviderData(FileConstant.inputlogin);
		Object[][] getData = provideData.provideData();
		return getData;
	}
	/**
	 * read the data from xlsx file for login
	 * @param args
	 */
	public static void main(String[] args) {

		Object[][] data = new PhpTravellsLoginDataProvider().getData();
		for (Object[] objects : data) {
			String Emailid = (String) objects[0];
			String password = (String) objects[1];
			System.out.println(" " + Emailid + "   " + password);
		}
	}
}


