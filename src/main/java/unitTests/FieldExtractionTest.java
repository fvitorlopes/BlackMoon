package unitTests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import autInteraction.autDataExtraction.DriverSingleton;
import autInteraction.autDataExtraction.FormExtractor;
import dtos.autDataExtractor.ToExtractor;
import dtos.autDataExtractor.ToSearchResult;
import dtos.template.CodeTemplate;
import dtos.template.CodeTemplateStep;
import dtos.templateConfig.TemplateConfig;
import outputCode.CodeGenerator;

public class FieldExtractionTest {
	
	@Test
	public void test() {
		CodeGenerator codeGenerator = new CodeGenerator();
		FormExtractor formExtractor = new FormExtractor();
		TestDatabase testDatabase = new TestDatabase();
		TemplateConfig templateConfig = testDatabase.getTemplateConfig();
		
		DriverSingleton.getInstance().get("file:///C:/Users/fvitor/git/BlackMoon/src/testPages/pages/basicForm.html");
		ToExtractor toE = testDatabase.getToExtractor();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<ToSearchResult> result = formExtractor.getFormTestObjects(toE);
		CodeTemplateStep codeTemplateStep = formExtractor.generateCodeTemplate(result, toE);
	
		CodeTemplate codeTemplate = new CodeTemplate();
		codeTemplate.addCodeTemplateStep(codeTemplateStep);
		
		try {
			assertTrue(codeGenerator.generateCode(templateConfig,codeTemplate) != null);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
}