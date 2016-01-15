package autInteraction.autDataExtraction;



import dtos.autDataExtractor.ToSearchResult;
import enums.TOType;
import exceptions.BlackMoonException;

public class LabelExtractor {
	
	public String extractLabel(ToSearchResult toResult) throws BlackMoonException{
		if(toResult.getToType().equals(TOType.TEXT)){
			String label = toResult.getWebElement().getAttribute("title");
			return label;
		}
		throw new BlackMoonException("label for element not found");
	}
}