package outputCode.dtos.template;

import enums.ActionTemplateEnum;
import enums.ElementSearchConfigEnum;

public class CodeTemplateStep {

	private ActionTemplateEnum action;
	private ElementSearchConfigEnum element;
	private String value;
	private String locator;

	public CodeTemplateStep() {

	}

	public CodeTemplateStep(ActionTemplateEnum action, ElementSearchConfigEnum element, String value, String locator) {
		super();
		this.action = action;
		this.element = element;
		this.value = value;
		this.locator = locator;
	}

	public ActionTemplateEnum getAction() {
		return action;
	}

	public void setAction(ActionTemplateEnum action) {
		this.action = action;
	}

	public ElementSearchConfigEnum getElement() {
		return element;
	}

	public void setElement(ElementSearchConfigEnum element) {
		this.element = element;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CodeTemplateStep [action=" + action + ", element=" + element + ", value=" + value + ", locator="
				+ locator + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((element == null) ? 0 : element.hashCode());
		result = prime * result + ((locator == null) ? 0 : locator.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		CodeTemplateStep other = (CodeTemplateStep) obj;
		if (action != other.action)
			return false;
		if (element != other.element)
			return false;
		if (locator == null) {
			if (other.locator != null)
				return false;
		} else if (!locator.equals(other.locator))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}
}