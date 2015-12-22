package enums;

public enum SubstitutesEnum {

	ELEMENT("<<element>>"), PROPERTY("<<property>>"), VALOR("<<valor>>");

	private String substitute;

	private SubstitutesEnum(String s) {
		substitute = s;
	}

	public String getSubstitute() {
		return substitute;
	}
	
}