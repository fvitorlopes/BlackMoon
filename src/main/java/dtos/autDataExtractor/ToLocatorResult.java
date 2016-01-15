package dtos.autDataExtractor;

public class ToLocatorResult {
	private String parameter;
	private String value;

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ToLocatorResult() {
	}

	public ToLocatorResult(String parameter, String value) {
		super();
		this.parameter = parameter;
		this.value = value;
	}

}