package autInteraction.autDataExtraction.toExtraction.extractors;

import autInteraction.autDataExtraction.toExtraction.dtos.form.ToSearchResult;
import enums.TOType;
import exceptions.BlackMoonException;

class ValueExtractor {
	String extractValue(ToSearchResult toResult) throws BlackMoonException{
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
