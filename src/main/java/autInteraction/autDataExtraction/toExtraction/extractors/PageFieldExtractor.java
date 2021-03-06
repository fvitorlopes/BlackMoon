package autInteraction.autDataExtraction.toExtraction.extractors;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import autInteraction.autDataExtraction.toExtraction.dtos.field.PageField;
import autInteraction.autDataExtraction.toExtraction.dtos.form.ToExtractor;
import exceptions.BlackMoonException;

public class PageFieldExtractor {

	private NameExtractor nameExtractor = new NameExtractor();
	
	public List<PageField> getPageFields() throws BlackMoonException{
		List<PageField> out = new ArrayList<PageField>();	
		// Add buttons
		out.addAll(listAllInputSubmitButtons());
		
		// Add textFields
		out.addAll(listAllInputTextField());
		return out;
	}
	
	// Call method 
	// Change to form after
	public List<PageField> listAllInputSubmitButtons() throws BlackMoonException{
		return listPageFields(By.cssSelector("input[type=submit]"));
	}
	
	public List<PageField> listAllInputTextField() throws BlackMoonException{
		return listPageFields(By.cssSelector("input[type=text]"));
	}
	
	// Implement search by label
	private List<PageField> listPageFields(By by) throws BlackMoonException{
		List<PageField> out = new ArrayList<PageField>();
		for(WebElement webElement : DriverSingleton.findElementsVisible(by)){
			System.out.println(new ToExtractionUtil().getSource(webElement));
			
			String elementName = nameExtractor.extractName(webElement);
			out.add(new PageField(elementName, ""));
		}
		return out;	
	}
}