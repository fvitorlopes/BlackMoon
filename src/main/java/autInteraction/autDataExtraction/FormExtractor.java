package autInteraction.autDataExtraction;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dtos.autDataExtractor.ToExtractor;
import dtos.autDataExtractor.ToSearchResult;
import dtos.template.CodeTemplateStep;
import enums.ElementSearchConfigEnum;
import exceptions.BlackMoonException;

public class FormExtractor {

	public List<ToSearchResult> getFormTestObjects(ToExtractor extractor){
		List<ToSearchResult> toSearchResult = new ArrayList<ToSearchResult>();
		if (extractor.getElementSearch().equals(ElementSearchConfigEnum.CSS)) {
			for (WebElement webElement : DriverSingleton.getInstance()
					.findElements(By.cssSelector(extractor.getLocator()))) {
				toSearchResult.add(new ToSearchResult(extractor.getToType(), webElement, extractor));
			}
		}
		return toSearchResult;
	}
	
	public CodeTemplateStep generateCodeTemplate(List<ToSearchResult> listToSearchResult, ToExtractor toExtractor){
		// TODO : add multiple
		CodeTemplateStep codeTemplateStep = new CodeTemplateStep();
		for (ToSearchResult toResult : listToSearchResult) {
			try {
				codeTemplateStep.setAction(toExtractor.getToType().getAction());
				for (String propertyScript : toResult.getExtractor().getPropertyScriptExtractor()) {
					if (isAtributePresent(toResult.getWebElement(), propertyScript)) {
						codeTemplateStep.setLocator(propertyScript);
						codeTemplateStep.setValue(toResult.getWebElement().getAttribute(propertyScript));
						codeTemplateStep.setElement(elementSearchConvesor(propertyScript));
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return codeTemplateStep;
	}
	
	public static void main(String[] args) {
		System.out.println("begin");
	
		// go for test
		DriverSingleton.getInstance().get("file:///C:/Users/fvitor/git/BlackMoon/src/testPages/pages/basicForm.html");
	
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DriverSingleton.getInstance().quit();
		System.out.println("end");
	}

	private boolean isAtributePresent(WebElement webElement, String attribute) {
		boolean result = false;
		try {
			String value = webElement.getAttribute(attribute);
			if (value != null) {
				result = true;
			}
		} catch (Exception e) {
			// Silenced for not found attribute
		}
		return result;
	}


	private ElementSearchConfigEnum elementSearchConvesor(String property) throws BlackMoonException{
		ElementSearchConfigEnum elementReturn = null;
		if(property.equals("id")){
			elementReturn = ElementSearchConfigEnum.ID;
		}else{
			throw new BlackMoonException("Not possible convert element");
		}
		return elementReturn;
	}

}