package unitTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import outputCode.dtos.template.CodeTemplate;
import outputCode.dtos.templateConfig.TemplateConfig;
import outputCode.generators.CodeGenerator;

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