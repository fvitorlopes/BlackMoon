package autInteraction.autDataExtraction.htmlExtraction;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import autInteraction.autDataExtraction.toExtraction.DriverSingleton;

public class TableExtraction {
	// TODO : do find table also

	public TableEntity extractTable(WebElement table) {
		TableEntity tableEntity = new TableEntity();
		tableEntity.setTableElement(table);
		tableEntity.setTableLines(getLinesTable(table));
		tableEntity.setHeaders(getHeadersTable(table));
		tableEntity.setTableColumns(getColumns(table));
		return tableEntity;
	}

	public static void main(String[] args) {
		TableExtraction tableExtraction = new TableExtraction();
		tableExtraction.testTableExtraction();
	}

	public void testTableExtraction() {
		DriverSingleton.getInstance().get("file:///C:/Users/fvitor/git/BlackMoon/src/testPages/pages/basicTable.html");

		WebElement table = DriverSingleton.findElement(By.id("tabelaExemplo"));
		extractTable(table);
	}
	
	// TODO : consider tables without thead and tbody
	private List<String> getHeadersTable(WebElement table) {
		List<String> out = new ArrayList<String>();
		WebElement header = table.findElement(By.tagName("thead"));
		for (WebElement thHeadTable : header.findElements(By.tagName("th"))) {
			out.add(thHeadTable.getText());
		}
		return out;
	}

	private List<TableLineEntity> getLinesTable(WebElement table) {
		List<TableLineEntity> out = new ArrayList<TableLineEntity>();
		WebElement header = table.findElement(By.tagName("tbody"));

		for (WebElement thHeadTable : header.findElements(By.tagName("tr"))) {
			TableLineEntity tableLineEntity = new TableLineEntity();
			for (WebElement tdHeadTable : thHeadTable.findElements(By.tagName("td"))) {
				tableLineEntity.addValue(tdHeadTable.getText());
			}
			out.add(tableLineEntity);
		}
		return out;
	}

	private List<TableColumn> getColumns(WebElement table) {
		List<TableColumn> tableColumns = new ArrayList<TableColumn>();
		List<String> tableHeaders = getHeadersTable(table);
		List<TableLineEntity> tablesLines = getLinesTable(table);

		for (String header : tableHeaders) {
			TableColumn tableColumn = new TableColumn();
			tableColumn.setName(header);

			for (TableLineEntity line : tablesLines) {
				String contentCell = line.getValues().get(tableHeaders.indexOf(header));
				tableColumn.addValue(contentCell);
			}
			tableColumns.add(tableColumn);
		}

		return tableColumns;
	}

}