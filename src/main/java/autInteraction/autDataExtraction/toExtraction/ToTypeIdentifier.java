package autInteraction.autDataExtraction.toExtraction;

import org.openqa.selenium.WebElement;

import enums.TOType;
import exceptions.BlackMoonException;

public class ToTypeIdentifier {

	private ToExtractionUtil toExtraction = new ToExtractionUtil();

	public boolean isType (WebElement webElement , TOType toType) throws BlackMoonException{
		if(webElement == null){
			return false;
		}else{
			return identifyTO(webElement).equals(toType);
		}
	}
	public TOType identifyTO(WebElement webElement) throws BlackMoonException{
		if (isInput(webElement)) {
			if (isSubmitButton(webElement)) {
				return TOType.SUBMIT;
			} else if (isTextField(webElement)) {
				return TOType.TEXT;
			}
		}else if (isLabel(webElement)) {
			return TOType.LABEL;
		}
		// throw new BlackMoonException("WebElement could not be categorized");
		return TOType.NONE;
	}
	private boolean isSubmitButton(WebElement webElement){
		return toExtraction.verifyAttribute("type", "submit", webElement);
	}
	
	private boolean isTextField(WebElement webElement){
		return toExtraction.verifyAttribute("type", "text", webElement);
	}

	private boolean isInput(WebElement webElement){
		return webElement.getTagName().equals("input");
	}
	
	private boolean isLabel(WebElement webElement){
		return webElement.getTagName().equals("label");
	}

}