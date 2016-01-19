package dtos.templateConfig;

import java.util.ArrayList;
import java.util.List;

import enums.ActionTemplateEnum;
import enums.ElementSearchConfigEnum;
import exceptions.BlackMoonException;

public class ActionTemplateConfig {
		
	// one of those for each command
	private String substitute;
	private ActionTemplateEnum action;
	private List<ElementTemplateConfig> elements = new ArrayList<ElementTemplateConfig>();

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
		if(elements == null){
			elements = new ArrayList<ElementTemplateConfig>();
		}
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

	public void removeElement(ElementTemplateConfig element) {
		getElements().remove(element);
	}

	public void addElement(ElementTemplateConfig element) {
		getElements().add(element);
	}

	public ElementTemplateConfig searchElement(ElementSearchConfigEnum elementSearch) throws BlackMoonException{
		for(ElementTemplateConfig etc : elements){
			if(etc.getElementSearch().equals(elementSearch)){
				return etc;
			}
		}
		throw new BlackMoonException("Element search not found");
	}

	@Override
	public String toString() {
		return "ActionTemplateConfig [substitute=" + substitute + ", action=" + action + ", elements=" + elements + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((elements == null) ? 0 : elements.hashCode());
		result = prime * result + ((substitute == null) ? 0 : substitute.hashCode());
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
		ActionTemplateConfig other = (ActionTemplateConfig) obj;
		if (action != other.action)
			return false;
		if (elements == null) {
			if (other.elements != null)
				return false;
		} else if (!elements.equals(other.elements))
			return false;
	
		if (substitute == null) {
			if (other.substitute != null)
				return false;
		} else if (!substitute.equals(other.substitute))
			return false;
		return true;
	}
}