package dtos.autDataExtractor;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class ToFormExtractor {
	// Ok for entity
	private List<ToExtractor> toExtractors = new ArrayList<ToExtractor>();
	private WebElement form;

	public List<ToExtractor> getToExtractors() {
		return toExtractors;
	}

	public void setToExtractors(List<ToExtractor> toExtractors) {
		this.toExtractors = toExtractors;
	}

	public void addExtractor(ToExtractor extractor) {
		this.toExtractors.add(extractor);
	}

	public WebElement getForm() {
		return form;
	}

	public void setForm(WebElement form) {
		this.form = form;
	}

	public ToFormExtractor() {
	}

	public ToFormExtractor(List<ToExtractor> toExtractors, WebElement form) {
		super();
		this.toExtractors = toExtractors;
		this.form = form;
	}

	public ToFormExtractor(List<ToExtractor> toExtractors) {
		super();
		this.toExtractors = toExtractors;
	}

	@Override
	public String toString() {
		return "ToFormExtractor [toExtractors=" + toExtractors + ", form=" + form + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((form == null) ? 0 : form.hashCode());
		result = prime * result + ((toExtractors == null) ? 0 : toExtractors.hashCode());
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
		ToFormExtractor other = (ToFormExtractor) obj;
		if (form == null) {
			if (other.form != null)
				return false;
		} else if (!form.equals(other.form))
			return false;
		if (toExtractors == null) {
			if (other.toExtractors != null)
				return false;
		} else if (!toExtractors.equals(other.toExtractors))
			return false;
		return true;
	}

}