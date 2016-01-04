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
	public String generateCode(TemplateConfig templateConfig, CodeTemplate codeTemplate) throws BlackMoonException {
		
		String code = "";
		code += templateConfig.getHeader();
		
		
		for (CodeTemplateStep step : codeTemplate.getSteps()) {
			// for each step generate the code
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