package autInteraction.autDataExtraction;

import java.util.ArrayList;
import java.util.List;

import org.cyberneko.html.HTMLElements.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import enums.TOType;
import exceptions.BlackMoonException;

public class NameExtractor {

	
	
	// TODO : implement label
	public String extractName(WebElement webElement) throws BlackMoonException {
		ToTypeIdentifier toIdentifer = new ToTypeIdentifier();
		
		switch (toIdentifer.identifyTO(webElement)) {
		case BUTTON:
			return getInputButtonName(webElement);
		case TEXT:
			return getInputTextName(webElement);

		default:
			throw new BlackMoonException("Name of the element not found");
		}
	}

		
	private String getInputTextName(WebElement webElement) {
		return getExternalLabelNameElement(webElement, TOType.TEXT);
	}
	
	private String getInputButtonName(WebElement webElement) {
		List<String> parameters = new ArrayList<String>();
		parameters.add("value");
		String out = null;

		for (String parameter : parameters) {
			try {
				out = webElement.getAttribute(parameter);
				if (out != null) {
					break;
				}
			} catch (Exception e) {// Silenced for not found attributes}
			}
		}
		return out;
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
	
	private String getExternalLabelNameElement(WebElement element , TOType typeElement){
		
		return null;
	}
}