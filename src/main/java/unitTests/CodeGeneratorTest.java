package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import dtos.template.CodeTemplate;
import dtos.template.CodeTemplateStep;
import dtos.templateConfig.ActionTemplateConfig;
import dtos.templateConfig.ElementTemplateConfig;
import dtos.templateConfig.TemplateConfig;
import enums.ActionTemplateEnum;
import enums.ElementSearchConfigEnum;
import outputCode.CodeGenerator;

public class CodeGeneratorTest {
	
	@Test
	public void test() {
		CodeGenerator codeGenerator = new CodeGenerator();
		
		// Template config test generation
		TemplateConfig templateConfig = new TemplateConfig();
		CodeTemplate codeTemplate = new CodeTemplate();
		
		try {
			templateConfig.setHeader("public class Selenium2Example  { public static void main(String[] args) { ");
			templateConfig.setFooter("} }");

			templateConfig.addAction(new ActionTemplateConfig("driver.findElement(<<element>>).click();",
					ActionTemplateEnum.CLICK, null));

			templateConfig.addAction(new ActionTemplateConfig("driver.findElement(<<element>>).type(<<value>>);",
					ActionTemplateEnum.TYPE, null));
			
			ActionTemplateConfig resultATCClick = templateConfig.getActionTemplateConfigByAction(ActionTemplateEnum.CLICK);
			ElementTemplateConfig elementTemplateConfig = new ElementTemplateConfig("By.id(<<property>>)",
					ElementSearchConfigEnum.ID);
			resultATCClick.addElement(elementTemplateConfig);
			
			ActionTemplateConfig resultATCType = templateConfig.getActionTemplateConfigByAction(ActionTemplateEnum.TYPE);
			ElementTemplateConfig elementTemplateConfigType = new ElementTemplateConfig("By.idType(<<property>>)",
					ElementSearchConfigEnum.ID);
			resultATCType.addElement(elementTemplateConfigType);
			
			codeTemplate.setName("Selenium");
			
			codeTemplate.addCodeTemplateStep(new CodeTemplateStep(ActionTemplateEnum.CLICK,ElementSearchConfigEnum.ID, "value", "locator"));
			codeTemplate.addCodeTemplateStep(new CodeTemplateStep(ActionTemplateEnum.TYPE,ElementSearchConfigEnum.ID, "mail@mail.com", "email"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			assertTrue(codeGenerator.generateCode(templateConfig,codeTemplate) != null);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
}