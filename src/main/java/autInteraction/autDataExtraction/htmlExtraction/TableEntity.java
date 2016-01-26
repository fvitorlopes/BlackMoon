package autInteraction.autDataExtraction.htmlExtraction;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class TableEntity {

	private WebElement tableElement;
	private String source;
	private List<TableEntityValue> entityValues = new ArrayList<TableEntityValue>();

	public WebElement getTableElement() {
		return tableElement;
	}

	public void setTableElement(WebElement tableElement) {
		this.tableElement = tableElement;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<TableEntityValue> getEntityValues() {
		return entityValues;
	}

	public void setEntityValues(List<TableEntityValue> entityValues) {
		this.entityValues = entityValues;
	}

	public TableEntity() {
	
	}

	public TableEntity(WebElement tableElement, String source, List<TableEntityValue> entityValues) {
		super();
		this.tableElement = tableElement;
		this.source = source;
		this.entityValues = entityValues;
	}
	
}