package enums;

public enum TOType {
	
	TEXT(ActionTemplateEnum.TYPE), 
	PASSWORD(ActionTemplateEnum.TYPE), 
	BUTTON(ActionTemplateEnum.CLICK),
	SUBMIT(ActionTemplateEnum.CLICK),
	LABEL(ActionTemplateEnum.NONE),
	NONE(ActionTemplateEnum.NONE);
	
	
	private ActionTemplateEnum action;

	private TOType(ActionTemplateEnum action){
		this.action = action;
	}
	
	public ActionTemplateEnum getAction() {
		return action;
	}
}