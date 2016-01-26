package autInteraction.autDataExtraction.htmlExtraction;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class TableEntity {

	private WebElement tableElement;
	private List<TableEntityValue> entityValues = new ArrayList<TableEntityValue>();
	private List<TableLineEntity> tableLines = new ArrayList<TableLineEntity>();
	private List<TableColumn> tableColumns = new ArrayList<TableColumn>();
	private List<String> headers = new ArrayList<String>();

	public WebElement getTableElement() {
		return tableElement;
	}

	public void setTableElement(WebElement tableElement) {
		this.tableElement = tableElement;
	}

	public List<TableEntityValue> getEntityValues() {
		return entityValues;
	}

	public void setEntityValues(List<TableEntityValue> entityValues) {
		this.entityValues = entityValues;
	}

	public List<TableLineEntity> getTableLines() {
		return tableLines;
	}

	public void setTableLines(List<TableLineEntity> tableLines) {
		this.tableLines = tableLines;
	}

	public List<TableColumn> getTableColumns() {
		return tableColumns;
	}

	public void setTableColumns(List<TableColumn> tableColumns) {
		this.tableColumns = tableColumns;
	}

	public List<String> getHeaders() {
		return headers;
	}

	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entityValues == null) ? 0 : entityValues.hashCode());
		result = prime * result + ((headers == null) ? 0 : headers.hashCode());
		result = prime * result + ((tableColumns == null) ? 0 : tableColumns.hashCode());
		result = prime * result + ((tableElement == null) ? 0 : tableElement.hashCode());
		result = prime * result + ((tableLines == null) ? 0 : tableLines.hashCode());
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
		TableEntity other = (TableEntity) obj;
		if (entityValues == null) {
			if (other.entityValues != null)
				return false;
		} else if (!entityValues.equals(other.entityValues))
			return false;
		if (headers == null) {
			if (other.headers != null)
				return false;
		} else if (!headers.equals(other.headers))
			return false;
		if (tableColumns == null) {
			if (other.tableColumns != null)
				return false;
		} else if (!tableColumns.equals(other.tableColumns))
			return false;
		if (tableElement == null) {
			if (other.tableElement != null)
				return false;
		} else if (!tableElement.equals(other.tableElement))
			return false;
		if (tableLines == null) {
			if (other.tableLines != null)
				return false;
		} else if (!tableLines.equals(other.tableLines))
			return false;
		return true;
	}

	public TableEntity() {
		// TODO Auto-generated constructor stub
	}

	public TableEntity(WebElement tableElement, List<TableEntityValue> entityValues, List<TableLineEntity> tableLines,
			List<TableColumn> tableColumns, List<String> headers) {
		super();
		this.tableElement = tableElement;
		this.entityValues = entityValues;
		this.tableLines = tableLines;
		this.tableColumns = tableColumns;
		this.headers = headers;
	}

	@Override
	public String toString() {
		return "TableEntity [tableElement=" + tableElement + ", entityValues=" + entityValues + ", tableLines="
				+ tableLines + ", tableColumns=" + tableColumns + ", headers=" + headers + "]";
	}
}