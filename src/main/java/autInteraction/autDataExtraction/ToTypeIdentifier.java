package autInteraction.autDataExtraction;

import org.openqa.selenium.WebElement;

import enums.TOType;

public class ToTypeIdentifier {

	private ToExtractionUtil toExtraction = new ToExtractionUtil();

	public boolean isType (WebElement webElement , TOType toType){
		return identifyTO(webElement).equals(toType);
	}
	public TOType identifyTO(WebElement webElement){
		if (isInput(webElement)) {
			if (isSubmitButton(webElement)) {
				return TOType.SUBMIT;
			} else if (isTextField(webElement)) {
				return TOType.TEXT;
			}
		}
		
		return null;
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
}