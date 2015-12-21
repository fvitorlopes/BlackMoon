package dtos.template;

import java.util.List;

public class Template {

	private String name;
	private List<TemplateStep> steps;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TemplateStep> getSteps() {
		return steps;
	}
	public void setSteps(List<TemplateStep> steps) {
		this.steps = steps;
	}
	
}