package actions.controlActions;

import org.openqa.selenium.WebElement;

import actions.lowLevelActions.GetActions;

public class TextActions {

	public static String getText(WebElement element) {
		return GetActions.getText(element);
	}
}
