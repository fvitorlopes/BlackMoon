package autInteraction.autDataExtraction;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dtos.autDataExtractor.ToExtractor;
import dtos.autDataExtractor.ToSearchResult;
import dtos.template.CodeTemplateStep;
import enums.ElementSearchConfigEnum;
import enums.TOType;

public class FormExtractor {
	
	// get the elements by extractor (in extractor , out ?)

	// extract label and value (in ? , out value and label)

	// emit a
	// CodeTemplateStep(ActionTemplateEnum.CLICK,ElementSearchConfigEnum.ID,
	// "value", "locator")

	
	public List<ToSearchResult> getFormElements(ToExtractor toExtractor){
		List<ToSearchResult> toSearchResult = new ArrayList<ToSearchResult>();
		if (toExtractor.getElementSearch().equals(ElementSearchConfigEnum.CSS)) {
			for (WebElement webElement : DriverSingleton.getInstance().findElements(By.cssSelector(toExtractor.getLocator()))) {
				toSearchResult.add(new ToSearchResult(toExtractor.getToType(), webElement));
			}
		}
		return toSearchResult;
	}
	
	public static void main(String[] args) {
		System.out.println("begin");

		// get the element
		DriverSingleton.getInstance().get("file:///C:/Users/fvitor/git/BlackMoon/src/testPages/pages/basicForm.html");
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// depois implementar como lista
		ToExtractor extractor = new ToExtractor();
		extractor.setElementSearch(ElementSearchConfigEnum.CSS);
		extractor.setLocator("input[type='text']");
		extractor.setPropertyExtractor("value");
		extractor.setToType(TOType.TEXT);
		
		
		// method 1

		List<ToSearchResult> toSearchResult = new ArrayList<ToSearchResult>();
		if (extractor.getElementSearch().equals(ElementSearchConfigEnum.CSS)) {
			for (WebElement webElement : DriverSingleton.getInstance().findElements(By.cssSelector(extractor.getLocator()))) {
				toSearchResult.add(new ToSearchResult(extractor.getToType(), webElement));
			}
		}
		
		// method 2
		for (ToSearchResult toResult : toSearchResult) {
			try {
				String label = new LabelExtractor().extractLabel(toResult);
				String value = new ValueExtractor().extractValue(toResult);
				
				CodeTemplateStep codeTemplateStep = new CodeTemplateStep();
				codeTemplateStep.setAction(extractor.getToType().getAction());
				codeTemplateStep.setLocator(label);
				codeTemplateStep.setValue(value);
				// id and stuff
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// method 3 
		CodeTemplateStep codeTemplateStep = new CodeTemplateStep();
		codeTemplateStep.setAction(extractor.getToType().getAction());
		codeTemplateStep.setElement(extractor.getElementSearch());
		codeTemplateStep.setElement(extractor.getElementSearch());

		// out as this
		// new
		// CodeTemplateStep(ActionTemplateEnum.CLICK,ElementSearchConfigEnum.ID,
		// "value", "locator")
		for (WebElement element : DriverSingleton.getInstance().findElements(By.cssSelector("input[type='text']"))) {
			if (element.getAttribute("id").trim().equals("frmLogin:txtUsuario")) {
				System.out.println("Value : " + element.getAttribute("value"));
				System.out.println("");
			}
		}
		DriverSingleton.getInstance().quit();
		System.out.println("end");
	}
}