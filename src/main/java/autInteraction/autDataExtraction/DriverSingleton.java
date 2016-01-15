package autInteraction.autDataExtraction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

	private static final WebDriver driver = new FirefoxDriver();
	
	private DriverSingleton(){};
	
	public static WebDriver getInstance(){
		return driver;
	}
	
}
