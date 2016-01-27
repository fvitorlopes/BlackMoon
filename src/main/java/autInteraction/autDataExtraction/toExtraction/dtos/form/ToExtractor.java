package autInteraction.autDataExtraction.toExtraction.dtos.form;

import java.util.ArrayList;
import java.util.List;

import enums.ElementSearchConfigEnum;
import enums.TOType;

/**
 * @author fvitor
 *
 */
public class ToExtractor {
	
	private String name;
	private ElementSearchConfigEnum elementSearch;
	private ElementSearchConfigEnum elementComparator;
	private String locator;
	private String propertyExtractor;
	private TOType toType;
	private List<String> propertyScriptExtractor = new ArrayList<String>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ElementSearchConfigEnum getElementSearch() {
		return elementSearch;
	}

	public void setElementSearch(ElementSearchConfigEnum elementSearch) {
		this.elementSearch = elementSearch;
	}

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

	public String getPropertyExtractor() {
		return propertyExtractor;
	}

	public void setPropertyExtractor(String propertyExtractor) {
		this.propertyExtractor = propertyExtractor;
	}

	public TOType getToType() {
		return toType;
	}

	public void setToType(TOType toType) {
		this.toType = toType;
	}

	public ElementSearchConfigEnum getElementComparator() {
		return elementComparator;
	}

	public void setElementComparator(ElementSearchConfigEnum elementComparator) {
		this.elementComparator = elementComparator;
	}

	public List<String> getPropertyScriptExtractor() {
		return propertyScriptExtractor;
	}

	public void setPropertyScriptExtractor(List<String> propertyScriptExtractor) {
		this.propertyScriptExtractor = propertyScriptExtractor;
	}
}