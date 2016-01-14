package autInteraction.autDataExtraction;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dtos.autDataExtractor.ToLocator;
import dtos.autDataExtractor.ToResult;
import enums.TOType;

public class PropertyExtractor {
	
	// TODO : do it as a list 
	public List<ToResult> getAutData(ToLocator toLocator,WebDriver driver ){
		// get an out
		List<ToResult> out = new ArrayList<ToResult>();
		
		for(WebElement element : driver.findElements(By.cssSelector(toLocator.getLocator()))){
			ToResult toResult = new ToResult();
			toResult.setToType(TOType.TEXT);
	
			// Expand for proximit and hierarchy
			toResult.setValue(element.getAttribute(toLocator.getComparator()));
		}
		return out;
	}

}