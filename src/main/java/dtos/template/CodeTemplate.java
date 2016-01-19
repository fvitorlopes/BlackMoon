package dtos.template;

import java.util.ArrayList;
import java.util.List;

public class CodeTemplate {
	
	// OK : for entity
	private String name;
	private List<CodeTemplateStep> steps = new ArrayList<CodeTemplateStep>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CodeTemplateStep> getSteps() {
		if(steps == null){
			steps = new ArrayList<CodeTemplateStep>();
		}
		return steps;
	}
	public void setSteps(List<CodeTemplateStep> steps) {
		this.steps = steps;
	}

	
	public void addCodeTemplateStep(CodeTemplateStep codeTemplateStep){
		getSteps().add(codeTemplateStep);
	}
	@Override
	public String toString() {
		return "CodeTemplate [name=" + name + ", steps=" + steps + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((steps == null) ? 0 : steps.hashCode());
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
		CodeTemplate other = (CodeTemplate) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (steps == null) {
			if (other.steps != null)
				return false;
		} else if (!steps.equals(other.steps))
			return false;
		return true;
	}

}