package enums;

public enum SubstitutesEnum {

	ELEMENT("<<element>>"), PROPERTY("<<property>>"), VALUE("<<value>>");

	private String substitute;

	private SubstitutesEnum(String s) {
		substitute = s;
	}

	public String getSubstitute() {
		return substitute;
	}
	
}