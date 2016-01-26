package unitTests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import autInteraction.autDataExtraction.toExtraction.DriverSingleton;
import autInteraction.autDataExtraction.toExtraction.FormExtractor;
import dtos.autDataExtractor.ToExtractor;
import dtos.autDataExtractor.ToFormExtractor;
import dtos.autDataExtractor.ToSearchResult;
import dtos.template.CodeTemplate;
import dtos.template.CodeTemplateStep;
import dtos.templateConfig.TemplateConfig;
import outputCode.CodeGenerator;

public class FieldExtractionTest {
	
	@Test
	public void test() {
		TestDatabase testDatabase = new TestDatabase();
		
		CodeGenerator codeGenerator = new CodeGenerator();
		FormExtractor formExtractor = new FormExtractor();
		TemplateConfig templateConfig = testDatabase.getTemplateConfig();
		ToFormExtractor toFormExtractor = testDatabase.getToFormExtractor();
		
		
		DriverSingleton.getInstance().get("file:///C:/Users/fvitor/git/BlackMoon/src/testPages/pages/basicForm.html");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CodeTemplate codeTemplate = new CodeTemplate();
		for (ToExtractor toE : toFormExtractor.getToExtractors()) {
			List<ToSearchResult> result = formExtractor.getFormTestObjects(toE);
			CodeTemplateStep codeTemplateStep = formExtractor.generateCodeTemplate(result, toE);
			
			codeTemplate.addCodeTemplateStep(codeTemplateStep);
		}try {
			assertTrue(codeGenerator.generateCode(templateConfig, codeTemplate) != null);
		} catch (Exception e) {
			assertTrue(false);
		} 
	}
}