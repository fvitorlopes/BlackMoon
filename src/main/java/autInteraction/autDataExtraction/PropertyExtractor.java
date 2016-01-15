package autInteraction.autDataExtraction;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dtos.autDataExtractor.ToLocator;
import dtos.autDataExtractor.ToSearchResult;
import enums.TOType;

public class PropertyExtractor {
	
	// TODO : do it as a list 
	public List<ToSearchResult> getAutData(ToLocator toLocator,WebDriver driver ){
		// get an out
		List<ToSearchResult> out = new ArrayList<ToSearchResult>();
		
		for(WebElement element : driver.findElements(By.cssSelector(toLocator.getLocator()))){
			ToSearchResult toResult = new ToSearchResult();
			toResult.setToType(TOType.TEXT);
			
			// Expand for proximit and hierarchy
			toResult.setValue(element.getAttribute(toLocator.getComparator()));
		}
		return out;
	}

}