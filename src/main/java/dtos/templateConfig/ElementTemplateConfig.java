package dtos.templateConfig;

import enums.ElementSearchConfigEnum;

public class ElementTemplateConfig {
	private String substitute;
	private ElementSearchConfigEnum elementSearch;
	
	
	public ElementTemplateConfig() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ElementTemplateConfig(String substitute, ElementSearchConfigEnum elementSearch) {
		super();
		this.substitute = substitute;
		this.elementSearch = elementSearch;
	}


	public String getSubstitute() {
		return substitute;
	}

	public void setSubstitute(String substitute) {
		this.substitute = substitute;
	}

	public ElementSearchConfigEnum getElementSearch() {
		return elementSearch;
	}

	public void setElementSearch(ElementSearchConfigEnum elementSearch) {
		this.elementSearch = elementSearch;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((elementSearch == null) ? 0 : elementSearch.hashCode());
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
		ElementTemplateConfig other = (ElementTemplateConfig) obj;
		if (elementSearch != other.elementSearch)
			return false;
		if (substitute == null) {
			if (other.substitute != null)
				return false;
		} else if (!substitute.equals(other.substitute))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ElementTemplateConfig [substitute=" + substitute + ", elementSearch=" + elementSearch + "]";
	}
}