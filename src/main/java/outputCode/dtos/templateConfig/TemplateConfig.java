package outputCode.dtos.templateConfig;

import java.util.ArrayList;
import java.util.List;

import enums.ActionTemplateEnum;
import exceptions.BlackMoonException;

// OK for entity
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

	@Override
	public String toString() {
		return "TemplateConfig [header=" + header + ", footer=" + footer + ", actions=" + actions + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actions == null) ? 0 : actions.hashCode());
		result = prime * result + ((footer == null) ? 0 : footer.hashCode());
		result = prime * result + ((header == null) ? 0 : header.hashCode());
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
		TemplateConfig other = (TemplateConfig) obj;
		if (actions == null) {
			if (other.actions != null)
				return false;
		} else if (!actions.equals(other.actions))
			return false;
		if (footer == null) {
			if (other.footer != null)
				return false;
		} else if (!footer.equals(other.footer))
			return false;
		if (header == null) {
			if (other.header != null)
				return false;
		} else if (!header.equals(other.header))
			return false;
		return true;
	}
}