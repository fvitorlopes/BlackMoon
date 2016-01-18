package unitTests;

import org.junit.Test;

import autInteraction.autDataExtraction.DriverSingleton;

public class FieldExtractionTest {

	@Test
	public void test() {
		
		DriverSingleton.getInstance().get("file:///C:/Users/fvitor/git/BlackMoon/src/testPages/pages/basicForm.html");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
