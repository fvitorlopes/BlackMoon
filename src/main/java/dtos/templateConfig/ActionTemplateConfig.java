package dtos.templateConfig;

import java.util.List;

import enums.ActionTemplateEnum;

public class ActionTemplateConfig {

	// one of those for each command
	private String substitute;
	private ActionTemplateEnum action;
	private List<ElementTemplateConfig> elements;

	public ActionTemplateConfig() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ActionTemplateConfig(String substitute, ActionTemplateEnum action, List<ElementTemplateConfig> elements) {
		super();
		this.substitute = substitute;
		this.action = action;
		this.elements = elements;
	}


	public List<ElementTemplateConfig> getElements() {
		return elements;
	}

	public void setElements(List<ElementTemplateConfig> elements) {
		this.elements = elements;
	}

	public String getSubstitute() {
		return substitute;
	}

	public void setSubstitute(String substitute) {
		this.substitute = substitute;
	}

	public ActionTemplateEnum getAction() {
		return action;
	}

	public void setAction(ActionTemplateEnum action) {
		this.action = action;
	}

}