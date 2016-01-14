package dtos.autDataExtractor;

import org.openqa.selenium.WebElement;

public class ToLocator {
	
	private String name;
	private String locator;
	private String comparator;
	private WebElement element;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocator() {
		return locator;
	}
	public void setLocator(String locator) {
		this.locator = locator;
	}
	public String getComparator() {
		return comparator;
	}
	public void setComparator(String comparator) {
		this.comparator = comparator;
	}
	
	public ToLocator() {
	}
	public ToLocator(String name, String locator, String comparator) {
		super();
		this.name = name;
		this.locator = locator;
		this.comparator = comparator;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comparator == null) ? 0 : comparator.hashCode());
		result = prime * result + ((locator == null) ? 0 : locator.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ToLocator other = (ToLocator) obj;
		if (comparator == null) {
			if (other.comparator != null)
				return false;
		} else if (!comparator.equals(other.comparator))
			return false;
		if (locator == null) {
			if (other.locator != null)
				return false;
		} else if (!locator.equals(other.locator))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ToLocator [name=" + name + ", locator=" + locator + ", comparator=" + comparator + "]";
	}
	public WebElement getElement() {
		return element;
	}
	public void setElement(WebElement element) {
		this.element = element;
	}
}