package outputCode.generators;

import enums.ActionTemplateEnum;
import enums.ElementSearchConfigEnum;
import enums.SubstitutesEnum;
import exceptions.BlackMoonException;
import outputCode.dtos.template.CodeTemplate;
import outputCode.dtos.template.CodeTemplateStep;
import outputCode.dtos.templateConfig.ActionTemplateConfig;
import outputCode.dtos.templateConfig.ElementTemplateConfig;
import outputCode.dtos.templateConfig.TemplateConfig;

public class CodeGenerator {

	// Also recieve the script
	public String generateCode(TemplateConfig templateConfig, CodeTemplate codeTemplate) throws BlackMoonException {
		
		String code = "";
		code += templateConfig.getHeader();
		
		for (CodeTemplateStep step : codeTemplate.getSteps()) {
			ActionTemplateConfig resultTemplateConfig = templateConfig
					.getActionTemplateConfigByAction(step.getAction());
			ElementTemplateConfig resultElementConfig = resultTemplateConfig.searchElement(step.getElement());

			
			String codeLine = resultTemplateConfig.getSubstitute();
			codeLine = codeLine.replace(SubstitutesEnum.ELEMENT.getSubstitute(), resultElementConfig.getSubstitute());
			codeLine = codeLine.replace(SubstitutesEnum.PROPERTY.getSubstitute(), step.getLocator());
			codeLine = codeLine.replace(SubstitutesEnum.VALUE.getSubstitute(), step.getValue());
			
			code = code + codeLine + System.lineSeparator();
		}

		code += templateConfig.getFooter();
		System.out.println(code);
		return code;
	}

}