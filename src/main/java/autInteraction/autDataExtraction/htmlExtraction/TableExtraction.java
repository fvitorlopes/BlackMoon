package autInteraction.autDataExtraction.htmlExtraction;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import autInteraction.autDataExtraction.toExtraction.DriverSingleton;

public class TableExtraction {
	// TODO : do find table also

	public TableEntity extractTable(WebElement tableElement) {
		TableEntity tableEntity = new TableEntity();

		return tableEntity;
	}

	public static void main(String[] args) {
		TableExtraction tableExtraction = new TableExtraction();
		tableExtraction.testTableExtraction();
	}

	public void testTableExtraction() {
		DriverSingleton.getInstance().get("file:///C:/Users/fvitor/git/BlackMoon/src/testPages/pages/basicTable.html");

		WebElement table = DriverSingleton.findElement(By.id("tabelaExemplo"));
		System.out.println(getHeadersTable(table));
		// get the element

	}

	// TODO : consider tables without thead and tbody
	public List<String> getHeadersTable(WebElement table) {
		List<String> out = new ArrayList<String>();
		WebElement header = table.findElement(By.tagName("thead"));
		for (WebElement thHeadTable : header.findElements(By.tagName("th"))) {
			out.add(thHeadTable.getText());
		}
		return out;
	}

	public List<TableLineEntity> getLinesTable(WebElement table) {
		List<TableLineEntity> out = new ArrayList<TableLineEntity>();
		WebElement header = table.findElement(By.tagName("tbody"));

		for (WebElement thHeadTable : header.findElements(By.tagName("tr"))) {
			TableLineEntity tableLineEntity = new TableLineEntity();
			for (WebElement tdHeadTable : header.findElements(By.tagName("td"))) {
				tableLineEntity.addValue(tdHeadTable.getText());
			}
			out.add(tableLineEntity);
		}
		return out;
	}

}