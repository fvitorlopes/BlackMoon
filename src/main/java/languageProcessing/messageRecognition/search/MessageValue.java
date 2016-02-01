package languageProcessing.messageRecognition.search;

import languageProcessing.messageRecognition.enums.MessageCategoryStatusEnum;
import languageProcessing.messageRecognition.enums.MessageErrorCategoriesEnum;

public class MessageValue {
	
	private String message;
	private MessageCategoryStatusEnum messageStatus;
	private MessageErrorCategoriesEnum messageErrorCategory;
	
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

	public MessageErrorCategoriesEnum getMessageErrorCategory() {
		return messageErrorCategory;
	}

	public void setMessageErrorCategory(MessageErrorCategoriesEnum messageErrorCategory) {
		this.messageErrorCategory = messageErrorCategory;
	}
	
	public MessageValue(String message, MessageCategoryStatusEnum messageStatus,
			MessageErrorCategoriesEnum messageErrorCategory) {
		super();
		this.message = message;
		this.messageStatus = messageStatus;
		this.messageErrorCategory = messageErrorCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((messageErrorCategory == null) ? 0 : messageErrorCategory.hashCode());
		result = prime * result + ((messageStatus == null) ? 0 : messageStatus.hashCode());
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
		MessageValue other = (MessageValue) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (messageErrorCategory != other.messageErrorCategory)
			return false;
		if (messageStatus != other.messageStatus)
			return false;
		return true;
	}

	public MessageValue() {
	}

	@Override
	public String toString() {
		return "MessageValue [message=" + message + ", messageStatus=" + messageStatus + ", messageErrorCategory="
				+ messageErrorCategory + "]";
	}
}