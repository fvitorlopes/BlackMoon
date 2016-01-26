package autInteraction.autDataExtraction.toExtraction;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import enums.TOType;
import exceptions.BlackMoonException;

public class NameExtractor {

	private ToExtractionUtil toExtractor = new ToExtractionUtil();
	private WebElement foundWebElement;
	private ToTypeIdentifier toIdentifer = new ToTypeIdentifier();
	private WebElement actualParent;

	// TODO : implement label
	public String extractName(WebElement webElement) throws BlackMoonException {

		switch (toIdentifer.identifyTO(webElement)) {
		case BUTTON:
			return getInputButtonName(webElement);
		case SUBMIT:
			return getInputSubmitName(webElement);
		case TEXT:
			return getInputTextName(webElement);
		default:
			throw new BlackMoonException("Name of the element not found");
		}
	}

	private String getInputTextName(WebElement webElement) throws BlackMoonException {
		String labelName = "";
		try {
			labelName = getExternalLabelNameElement(webElement).getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: silenced for test
		}
		return labelName;
	}

	private String getInputSubmitName(WebElement webElement) {
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

	private WebElement getParentElement(WebElement element) {
		if (actualParent == null) {
			return toExtractor.getParent(element);
		} else {
			return toExtractor.getParent(actualParent);
		}
	}
	
	private WebElement getExternalLabelNameElement(WebElement webElement) throws BlackMoonException {
		System.out.println("Source webElement " + toExtractor.getSource(webElement));
		
		for (int i = 0; i < 2; i++) {
			actualParent = getParentElement(webElement);
			System.out.println("Souce parent " + toExtractor.getSource(actualParent));

			
			WebElement foundLabel = getRecursiveLabel(actualParent);
			if (foundLabel != null) {
				return foundLabel;
			}
		}
		return null;
		// throw new BlackMoonException("Label of object could not be found");
	}
	
	public WebElement getRecursiveLabel(WebElement webElement) throws BlackMoonException {
		for (WebElement internalWebElement : toExtractor.getChildren(webElement)) {
			System.out.println("Internal web element  " + toExtractor.getSource(internalWebElement));
			
			if (foundWebElement != null) {
				break;
			}
			if (toIdentifer.isType(internalWebElement, TOType.LABEL)) {
				foundWebElement = internalWebElement;
			} else if (!toExtractor.getChildren(internalWebElement).isEmpty()) {
				getRecursiveLabel(internalWebElement);
			}
		}
		return foundWebElement;
	}
}