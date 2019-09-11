package phptravellsdataprovider;

import org.testng.annotations.DataProvider;

import com.atmecs.phptravel.constant.FilePath;
import com.phptravell.util.ProviderData;

public class PhpTravellsLoginDataProvider {

	
	@DataProvider(name = "logininput")
	public Object[][] getData() {
		ProviderData provideData = new ProviderData("./src/test/resources/Testdata/inputlogin.xlsx");
		Object[][] getData = provideData.provideData();
		return getData;
	}

	public static void main(String[] args) {

		Object[][] data = new PhpTravellsLoginDataProvider().getData();
		for (Object[] objects : data) {
			String Emailid = (String) objects[0];
			String password = (String) objects[1];
			System.out.println(" " + Emailid + "   " + password);
		}
	}
}
	

