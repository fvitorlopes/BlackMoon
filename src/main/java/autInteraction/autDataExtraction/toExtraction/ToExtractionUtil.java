package autInteraction.autDataExtraction.toExtraction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ToExtractionUtil {

	public boolean verifyAttribute(String attribute, String value, WebElement webElement) {
		return isAttribtuePresent(webElement, attribute) && webElement.getAttribute(attribute).equals(value);
	}

	private boolean isAttribtuePresent(WebElement element, String attribute) {
		Boolean result = false;
		try {
			String value = element.getAttribute(attribute);
			if (value != null) {
				result = true;
			}
		} catch (Exception e) {// Silenced for element not found
		}
		return result;
	}

	public WebElement getParent(WebElement webElement){
		return webElement.findElement(By.xpath(".."));
	}
	
	public List<WebElement> getChildren(WebElement webElement){
		return webElement.findElements(By.xpath(".//*"));
	}

	public List<WebElement> getDescendant(WebElement webElement){
		return webElement.findElements(By.xpath(".//*"));
	}

	public String getSource(WebElement webElement){
		return webElement.getAttribute("outerHTML");
	}
}