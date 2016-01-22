package autInteraction.autDataExtraction;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import dtos.pageInteraction.PageField;

public class PageFieldExtractor {

	private NameExtractor nameExtractor = new NameExtractor();
	
	public List<PageField> getPageFields(){
		List<PageField> out = new ArrayList<PageField>();	
		
		out = listAllInputSubmitButtons();
		
		return out;
	}
	
	// Call method 
	// Change to form after
	public List<PageField> listAllInputSubmitButtons(){
		List<PageField> out = new ArrayList<PageField>();
		for(WebElement webElement :DriverSingleton.getInstance().findElements(By.cssSelector("input[type=submit]"))){
			String elementName = nameExtractor.extractName(webElement);
			out.add(new PageField(elementName, ""));
		}
		return out;
	}
}