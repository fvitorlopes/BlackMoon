package dtos.autDataExtractor;

import org.openqa.selenium.WebElement;

import enums.TOType;

public class ToSearchResult {
	
	private TOType toType;
	private WebElement webElement;
	private String value;
	
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
	
	public ToSearchResult() {
		// TODO Auto-generated constructor stub
	}
	public ToSearchResult(TOType toType, WebElement webElement) {
		super();
		this.toType = toType;
		this.webElement = webElement;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}