package languageProcessing.messageRecognition.enums;

public enum MessageErrorCategoriesEnum {
	EMPTY_FIELD(0),INVALID_INPUT(1),INVALID_OPTION(2),INVALID_FORMAT(3);
	
	private MessageErrorCategoriesEnum(int categoryCode){
		this.categoryCode = categoryCode;
	}
	
	private int categoryCode;

	public int getCategoryCode() {
		return categoryCode;
	}

}