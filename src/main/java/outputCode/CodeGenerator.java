package outputCode;

import dtos.template.CodeTemplate;
import dtos.template.CodeTemplateStep;
import dtos.templateConfig.ActionTemplateConfig;
import dtos.templateConfig.ElementTemplateConfig;
import dtos.templateConfig.TemplateConfig;
import enums.ActionTemplateEnum;
import enums.ElementSearchConfigEnum;
import enums.SubstitutesEnum;
import exceptions.BlackMoonException;

public class CodeGenerator {

	// Also recieve the script
	public String generateCode(TemplateConfig templateConfig) throws BlackMoonException {
		templateConfig.setHeader("begining");
		templateConfig.setHeader("end");

		
		String code = "";
		code += templateConfig.getHeader();

		templateConfig.addAction(
				new ActionTemplateConfig("driver.findElement(<<element>>).click();", ActionTemplateEnum.CLICK, null));

		// get the script
		// iterate the test
		// get a dto with the action , the selenium element and the value
		// search the correspondent actionTemplateConfig by the action
		// get the element by the propertie and substitute

		ActionTemplateConfig resultATC = templateConfig.getActionTemplateConfigByAction(ActionTemplateEnum.CLICK);
		// Create elements and stuff
		ElementTemplateConfig elementTemplateConfig = new ElementTemplateConfig("By.id(<<property>>)",
				ElementSearchConfigEnum.ID);
		resultATC.addElement(elementTemplateConfig);
		// get from here
		// what i need
		// step with click and id

		CodeTemplate codeTemplate = new CodeTemplate();
		codeTemplate.addCodeTemplateStep(
				new CodeTemplateStep(ActionTemplateEnum.CLICK, ElementSearchConfigEnum.ID, "", "Salvar"));

		// do the actual method
		for (CodeTemplateStep step : codeTemplate.getSteps()) {
			// for each step generate the code
			ActionTemplateConfig resultTemplateConfig = templateConfig
					.getActionTemplateConfigByAction(step.getAction());
			ElementTemplateConfig resultElementConfig = resultTemplateConfig.searchElement(step.getElement());

			
			String codeLine = resultTemplateConfig.getSubstitute();
			codeLine = codeLine.replace(SubstitutesEnum.ELEMENT.getSubstitute(), resultElementConfig.getSubstitute());
			codeLine = codeLine.replace(SubstitutesEnum.PROPERTY.getSubstitute(), step.getLocator());
	
			code = code + codeLine + System.lineSeparator();
		}

		code += templateConfig.getFooter();
		System.out.println(code);
		return code;
	}

	public static void main(String[] args) {

		try {
			CodeGenerator codeGenerator = new CodeGenerator();
			try {
				codeGenerator.generateCode(new TemplateConfig());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}