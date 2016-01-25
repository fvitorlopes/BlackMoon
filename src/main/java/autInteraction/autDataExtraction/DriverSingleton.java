package autInteraction.autDataExtraction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

	private static final WebDriver driver = new FirefoxDriver();
	
	private DriverSingleton(){};
	
	public static WebDriver getInstance(){
		return driver;
	}
	public static List<WebElement> findElements(By by){
		return driver.findElements(by);
	}
	
	public static WebElement findElement(By by){
		return driver.findElement(by);
	}
}
