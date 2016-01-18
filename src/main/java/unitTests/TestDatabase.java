package unitTests;

import java.util.ArrayList;
import java.util.List;

import dtos.autDataExtractor.ToExtractor;
import dtos.template.CodeTemplate;
import dtos.template.CodeTemplateStep;
import dtos.templateConfig.ActionTemplateConfig;
import dtos.templateConfig.ElementTemplateConfig;
import dtos.templateConfig.TemplateConfig;
import enums.ActionTemplateEnum;
import enums.ElementSearchConfigEnum;
import enums.TOType;

public class TestDatabase {

	public TemplateConfig getTemplateConfig() {
		TemplateConfig templateConfig = new TemplateConfig();

		templateConfig.setHeader("public class Selenium2Example  { public static void main(String[] args) { ");
		templateConfig.setFooter("} }");

		templateConfig.addAction(
				new ActionTemplateConfig("driver.findElement(<<element>>).click();", ActionTemplateEnum.CLICK, null));

		templateConfig.addAction(new ActionTemplateConfig("driver.findElement(<<element>>).type(<<value>>);",
				ActionTemplateEnum.TYPE, null));
		try {

			ActionTemplateConfig resultATCClick = templateConfig
					.getActionTemplateConfigByAction(ActionTemplateEnum.CLICK);
			ElementTemplateConfig elementTemplateConfig = new ElementTemplateConfig("By.id(<<property>>)",
					ElementSearchConfigEnum.ID);
			resultATCClick.addElement(elementTemplateConfig);

			ActionTemplateConfig resultATCType = templateConfig
					.getActionTemplateConfigByAction(ActionTemplateEnum.TYPE);
			ElementTemplateConfig elementTemplateConfigType = new ElementTemplateConfig("By.idType(<<property>>)",
					ElementSearchConfigEnum.ID);
			resultATCType.addElement(elementTemplateConfigType);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return templateConfig;
	}

	public CodeTemplate getCodeTemplate() {
		CodeTemplate codeTemplate = new CodeTemplate();
		codeTemplate.setName("Selenium");
		codeTemplate.addCodeTemplateStep(
				new CodeTemplateStep(ActionTemplateEnum.CLICK, ElementSearchConfigEnum.ID, "value", "locator"));
		codeTemplate.addCodeTemplateStep(
				new CodeTemplateStep(ActionTemplateEnum.TYPE, ElementSearchConfigEnum.ID, "mail@mail.com", "email"));

		return codeTemplate;
	}
	
	public ToExtractor getToExtractor(){
		// go for database
		ToExtractor extractor = new ToExtractor();
		extractor.setElementSearch(ElementSearchConfigEnum.CSS);
		extractor.setLocator("input[type='text']");
		extractor.setPropertyExtractor("value");
		extractor.setToType(TOType.TEXT);
		
		List<String> propertyScriptExtraction = new ArrayList<String>();
		propertyScriptExtraction.add("id");
		extractor.setPropertyScriptExtractor(propertyScriptExtraction);

		return extractor;
	}
}