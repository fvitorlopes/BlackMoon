package autInteraction.autDataExtraction;

import dtos.autDataExtractor.ToSearchResult;
import enums.TOType;
import exceptions.BlackMoonException;

public class ValueExtractor {
	public String extractValue(ToSearchResult toResult) throws BlackMoonException{
		if(toResult.getToType().equals(TOType.TEXT)){
			String label = toResult.getWebElement().getAttribute("value");
			return label;
		}if(toResult.getToType().equals(TOType.SUBMIT)){
			String label = toResult.getWebElement().getAttribute("value");
			return label;
		}
		throw new BlackMoonException("value of element not found");
	}
}
