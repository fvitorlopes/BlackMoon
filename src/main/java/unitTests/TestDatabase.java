package unitTests;

import java.util.ArrayList;
import java.util.List;

import dtos.autDataExtractor.ToExtractor;
import dtos.autDataExtractor.ToFormExtractor;
import dtos.template.CodeTemplate;
import dtos.template.CodeTemplateStep;
import dtos.templateConfig.ActionTemplateConfig;
import dtos.templateConfig.ElementTemplateConfig;
import dtos.templateConfig.TemplateConfig;
import enums.ActionTemplateEnum;
import enums.ElementSearchConfigEnum;
import enums.TOType;

public class TestDatabase {
	// Template config
	
	
	public TemplateConfig getTemplateConfig() {
		TemplateConfig templateConfig = new TemplateConfig();

		String newline = System.getProperty("line.separator");
		
		templateConfig.setHeader("public class Selenium2Example { " + newline + newline + "		public static void main(String[] args) { " +newline);
		templateConfig.setFooter("    }"+newline+"}");

		templateConfig.addAction(
				new ActionTemplateConfig(newline +"        driver.findElement(<<element>>).click();" + newline, ActionTemplateEnum.CLICK, null));

		templateConfig.addAction(new ActionTemplateConfig(newline +"        driver.findElement(<<element>>).type(<<value>>);",
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
	
	public ToFormExtractor getToFormExtractor(){
		ToFormExtractor out = new ToFormExtractor();
		out.addExtractor(getToExtractor());
		out.addExtractor(getToExtractorButton());
		return out;
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

	public ToExtractor getToExtractorButton(){
		// go for database
		ToExtractor extractor = new ToExtractor();
		extractor.setElementSearch(ElementSearchConfigEnum.CSS);
		extractor.setLocator("input[type='submit']");
		extractor.setPropertyExtractor("value");
		extractor.setToType(TOType.SUBMIT);
		
		List<String> propertyScriptExtraction = new ArrayList<String>();
		propertyScriptExtraction.add("id");
		extractor.setPropertyScriptExtractor(propertyScriptExtraction);

		return extractor;
	}
}