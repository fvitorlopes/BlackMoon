package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import enums.ActionTemplateEnum;
import outputCode.dtos.templateConfig.ActionTemplateConfig;
import outputCode.dtos.templateConfig.TemplateConfig;

public class ActionTemplateConfigSearchTemplateTest {

	@Test
	public void test() {

		TemplateConfig templateConfig = new TemplateConfig();
		templateConfig
				.addAction(new ActionTemplateConfig("driver.findElement(#).click();", ActionTemplateEnum.CLICK, null));
		try {
			assertTrue(templateConfig.getActionTemplateConfigByAction(ActionTemplateEnum.CLICK) != null);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
}
