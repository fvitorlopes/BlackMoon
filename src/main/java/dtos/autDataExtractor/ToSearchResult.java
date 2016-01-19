package dtos.autDataExtractor;

import org.openqa.selenium.WebElement;

import enums.TOType;

public class ToSearchResult {
	private TOType toType;
	private WebElement webElement;
	private String value;
	private ToExtractor extractor;
	
	public TOType getToType() {
		return toType;
	}

	public void setToType(TOType toType) {
		this.toType = toType;
	}

	public WebElement getWebElement() {
		return webElement;
	}

	public void setWebElement(WebElement webElement) {
		this.webElement = webElement;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ToExtractor getExtractor() {
		return extractor;
	}

	public void setExtractor(ToExtractor extractor) {
		this.extractor = extractor;
	}

	public ToSearchResult() {
	}

	public ToSearchResult(TOType toType, WebElement webElement, String value, ToExtractor extractor) {
		super();
		this.toType = toType;
		this.webElement = webElement;
		this.value = value;
		this.extractor = extractor;
	}
	
	public ToSearchResult(TOType toType, WebElement webElement, ToExtractor extractor) {
		super();
		this.toType = toType;
		this.webElement = webElement;
		this.extractor = extractor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((extractor == null) ? 0 : extractor.hashCode());
		result = prime * result + ((toType == null) ? 0 : toType.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((webElement == null) ? 0 : webElement.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToSearchResult other = (ToSearchResult) obj;
		if (extractor == null) {
			if (other.extractor != null)
				return false;
		} else if (!extractor.equals(other.extractor))
			return false;
		if (toType != other.toType)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (webElement == null) {
			if (other.webElement != null)
				return false;
		} else if (!webElement.equals(other.webElement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ToSearchResult [toType=" + toType + ", webElement=" + webElement + ", value=" + value + ", extractor="
				+ extractor + "]";
	}
}