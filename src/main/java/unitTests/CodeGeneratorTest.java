package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import dtos.templateConfig.TemplateConfig;
import outputCode.CodeGenerator;

public class CodeGeneratorTest {

	@Test
	public void test() {
		CodeGenerator codeGenerator = new CodeGenerator();

		TemplateConfig templateConfig = new TemplateConfig();
		templateConfig.setHeader("begining");
		templateConfig.setHeader("end");

		assertTrue(codeGenerator.generateCode(templateConfig) != null);
		
		// implementation of unity test
	}
}