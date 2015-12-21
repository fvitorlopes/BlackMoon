package dtos.templateConfig;

import java.util.ArrayList;
import java.util.List;

import enums.ActionTemplateEnum;
import exceptions.BlackMoonException;

public class TemplateConfig {

	private String header;
	private String footer;
	private List<ActionTemplateConfig> actions = new ArrayList<ActionTemplateConfig>();

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public List<ActionTemplateConfig> getActions() {
		return actions;
	}

	public void setActions(List<ActionTemplateConfig> actions) {
		this.actions = actions;
	}

	public void addAction(ActionTemplateConfig actionTemplateConfig){
		actions.add(actionTemplateConfig);
	}

	public void removeAction(ActionTemplateConfig actionTemplateConfig){
		actions.remove(actionTemplateConfig);
	}

	public ActionTemplateConfig getActionTemplateConfigByAction(ActionTemplateEnum action) throws BlackMoonException{
		for(ActionTemplateConfig atcIteration : actions){
			if(atcIteration.getAction().equals(action)){
				return atcIteration;
			}
		}
		throw new BlackMoonException("Action not found");
	}
}