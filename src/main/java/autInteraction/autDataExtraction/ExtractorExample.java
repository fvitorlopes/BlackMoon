package autInteraction.autDataExtraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExtractorExample {

	public static void main(String[] args) {
		System.out.println("begin");
		WebDriver driver = new FirefoxDriver();

		driver.get("http://desenvolvimento/siop/");

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.findElement(By.cssSelector("img.siop_img_acesso_siop")).click();

		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// read the page
		// get forms
		// read a field
		// get the name
		// get the value
		// get the element
		// create code with it

		// object with thses parameters
	
		for (WebElement element : driver.findElements(By.cssSelector("input[type='text']"))) {
			if (element.getAttribute("id").trim().equals("frmLogin:txtUsuario")) {
				System.out.println("Value : " + element.getAttribute("value"));
				System.out.println("");
			}
		}

		driver.quit();
		System.out.println("end");

	}

}
