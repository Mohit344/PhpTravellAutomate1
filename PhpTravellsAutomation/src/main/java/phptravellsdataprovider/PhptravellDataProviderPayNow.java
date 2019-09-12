package phptravellsdataprovider;

import org.testng.annotations.DataProvider;

import com.phptravell.util.ProviderData;

public class PhptravellDataProviderPayNow {

	

	@DataProvider(name = "CartwoBookingpaynow")
	public Object[][] getData() {
		ProviderData provideData = new ProviderData("./src/test/resources/Testdata/PayOnDataProvider.xlsx");
		Object[][] getData = provideData.provideData();
		return getData;
	}

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
