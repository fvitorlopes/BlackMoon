package autInteraction.autDataExtraction;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class NameExtractor {
	public String extractName(WebElement webElement) {
		// is input
		if (webElement.getTagName().equals("input")) {
			if (isAttribtuePresent(webElement, "type") && webElement.getAttribute("type").equals("submit")) {
				return getInputButtonName(webElement);
			}
		}

		return null;
	}

	private String getInputButtonName(WebElement webElement) {
		List<String> parameters = new ArrayList<String>();
		parameters.add("value");
		String out = null;

		for (String parameter : parameters) {
			try {
				out = webElement.getAttribute(parameter);
				if (out != null) {
					break;
				}
			} catch (Exception e) {// Silenced for not found attributes}
			}
		}
		return out;
	}

	private boolean isAttribtuePresent(WebElement element, String attribute) {
		Boolean result = false;
		try {
			String value = element.getAttribute(attribute);
			if (value != null) {
				result = true;
			}
		} catch (Exception e) {
		}

		return result;
	}

}