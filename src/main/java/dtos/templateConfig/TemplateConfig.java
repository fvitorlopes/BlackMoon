package dtos.templateConfig;

import java.util.ArrayList;
import java.util.List;

public class TemplateConfig {

	private String header;
	private String footer;
	private List<ActionTemplateConfig> actions = new ArrayList<ActionTemplateConfig>();

	
	
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

}