package unitTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dtos.template.CodeTemplate;
import dtos.templateConfig.TemplateConfig;
import outputCode.CodeGenerator;

public class CodeGeneratorTest {
	
	@Test
	public void test() {
		CodeGenerator codeGenerator = new CodeGenerator();
		
		TestDatabase testDatabase = new TestDatabase();
		TemplateConfig templateConfig = testDatabase.getTemplateConfig();
		CodeTemplate codeTemplate = testDatabase.getCodeTemplate();
		
		
		try {
			assertTrue(codeGenerator.generateCode(templateConfig,codeTemplate) != null);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
}