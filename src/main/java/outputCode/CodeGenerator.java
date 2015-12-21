package outputCode;

import dtos.templateConfig.ActionTemplateConfig;
import dtos.templateConfig.ElementTemplateConfig;
import dtos.templateConfig.TemplateConfig;
import enums.ActionTemplateEnum;
import enums.ElementSearchConfigEnum;
import exceptions.BlackMoonException;

public class CodeGenerator {

	// Also recieve the script
	public String generateCode(TemplateConfig templateConfig) throws BlackMoonException {
		String code = "";
		code += templateConfig.getHeader();
	
		templateConfig.addAction(new ActionTemplateConfig("driver.findElement(#).click();", ActionTemplateEnum.CLICK, null));
	
		// get the script
		// iterate the test
		// get a dto with the action , the selenium element and the value
		// search the correspondent actionTemplateConfig by the action
	
		
		ActionTemplateConfig resultATC = templateConfig.getActionTemplateConfigByAction(ActionTemplateEnum.CLICK);
		// Create elements and stuff
		ElementTemplateConfig elementTemplateConfig = new ElementTemplateConfig("By.id(#)", ElementSearchConfigEnum.ID);
		

		
		code += templateConfig.getFooter();
		return code;
	}

}