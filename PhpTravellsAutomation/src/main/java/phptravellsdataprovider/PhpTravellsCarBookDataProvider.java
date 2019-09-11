package phptravellsdataprovider;

import org.testng.annotations.DataProvider;

import com.phptravell.util.ProviderData;

public class PhpTravellsCarBookDataProvider {

	@DataProvider(name = "CarBooking")
	public Object[][] getData() {
		ProviderData provideData = new ProviderData("./src/test/resources/Testdata/CarBookingtestdata.xlsx");
		Object[][] getData = provideData.provideData();
		return getData;
	}

	public static void main(String[] args) {

		Object[][] data = new PhpTravellsCarBookDataProvider().getData();
		for (Object[] objects : data) {
			String sendkeyonpick = (String) objects[0];
			String senddepartdate = (String) objects[1];
			String sendkeydrop = (String) objects[2];
			System.out.println(" " + sendkeyonpick + "   " + senddepartdate + " "+ sendkeydrop);

		}

	}
}
