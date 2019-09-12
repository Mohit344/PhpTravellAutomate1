package phptravellsdataprovider;

import org.testng.annotations.DataProvider;

import com.phptravell.util.ProviderData;

public class CarBookingTwoDataProvider {

	
	@DataProvider(name = "CartwoBooking")
	public Object[][] getData() {
		ProviderData provideData = new ProviderData("./src/test/resources/Testdata/carbookingtwodataprovider.xlsx");
		Object[][] getData = provideData.provideData();
		return getData;
	}

	public static void main(String[] args) {

		Object[][] data = new CarBookingTwoDataProvider().getData();
		for (Object[] objects : data) {
			String secsendkeyonpick = (String) objects[0];
			String secsenddepartdate = (String) objects[1];
			String secsendkeydrop = (String) objects[2];
			System.out.println(" " + secsendkeyonpick + "   " + secsenddepartdate + " "+ secsendkeydrop);

		}

	}
}
