package unitTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import autInteraction.autDataExtraction.toExtraction.dtos.field.PageContext;
import autInteraction.autDataExtraction.toExtraction.dtos.field.PageEntity;
import autInteraction.autDataExtraction.toExtraction.dtos.field.PageField;
import autInteraction.autDataExtraction.toExtraction.extractors.DriverSingleton;
import autInteraction.autDataExtraction.toExtraction.extractors.PageFieldExtractor;

public class ToExtractionTest {
	
	@Test
	public void test() {

		DriverSingleton.getInstance().get("file:///C:/Users/fvitor/git/BlackMoon/src/testPages/pages/basicForm.html");
		WebElement tabelaExemplo = DriverSingleton.findElement(By.id("tabelaExemplo"));
		
		
		PageContext pageContext = new PageContext();
		PageEntity pageEntity = new PageEntity();
		pageEntity.setName("Usuário");
		pageContext.setPageEntity(pageEntity);
		
		PageFieldExtractor pageFieldExtractor = new PageFieldExtractor();
		
		while (true) {
			try {
				for(PageField pageField : pageFieldExtractor.getPageFields()){
					System.out.println("Name : " + pageField.getName());
					System.out.println("Value : " + pageField.getValue());
					System.out.println("=======================================");
				}			
			} catch (Exception e) {
				
			}
		}
	}
}