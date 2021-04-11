package actions.controlActions;

import org.openqa.selenium.WebElement;

import actions.lowLevelActions.SetActions;

public class TextFieldActions {

	public static void setValue(WebElement element, String value) {
		SetActions.setValue(element, value);
	}
}
