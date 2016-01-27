package languageProcessing.messageRecognition.search;

public class MessageValue {
	// TODO put other categories

	private String message;
	private MessageCategoryStatusEnum messageStatus;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageCategoryStatusEnum getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(MessageCategoryStatusEnum messageStatus) {
		this.messageStatus = messageStatus;
	}

	public MessageValue(String message, MessageCategoryStatusEnum messageStatus) {
		super();
		this.message = message;
		this.messageStatus = messageStatus;
	}
	


}