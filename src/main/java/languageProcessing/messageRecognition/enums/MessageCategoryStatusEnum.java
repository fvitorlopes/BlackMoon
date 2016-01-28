package languageProcessing.messageRecognition.enums;

public enum MessageCategoryStatusEnum {
	ERROR(0),SUCCESS(1);

	private MessageCategoryStatusEnum(int categoryCode){
		this.categoryCode = categoryCode;
	}
	
	private int categoryCode;

	public int getCategoryCode() {
		return categoryCode;
	}
	
}
