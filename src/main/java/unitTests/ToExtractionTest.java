package unitTests;

import org.junit.Test;

import autInteraction.autDataExtraction.toExtraction.DriverSingleton;
import autInteraction.autDataExtraction.toExtraction.PageFieldExtractor;
import dtos.pageInteraction.PageContext;
import dtos.pageInteraction.PageEntity;
import dtos.pageInteraction.PageField;

public class ToExtractionTest {
	
	@Test
	public void test() {
		
		DriverSingleton.getInstance().get("file:///C:/Users/fvitor/git/BlackMoon/src/testPages/pages/basicForm.html");
	
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