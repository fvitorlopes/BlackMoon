package unitTests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import autInteraction.autDataExtraction.toExtraction.dtos.form.ToExtractor;
import autInteraction.autDataExtraction.toExtraction.dtos.form.ToFormExtractor;
import autInteraction.autDataExtraction.toExtraction.dtos.form.ToSearchResult;
import autInteraction.autDataExtraction.toExtraction.extractors.DriverSingleton;
import autInteraction.autDataExtraction.toExtraction.extractors.FormExtractor;
import outputCode.dtos.template.CodeTemplate;
import outputCode.dtos.template.CodeTemplateStep;
import outputCode.dtos.templateConfig.TemplateConfig;
import outputCode.generators.CodeGenerator;

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