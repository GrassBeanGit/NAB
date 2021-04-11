package actions.controlActions;

import org.openqa.selenium.WebElement;

import actions.lowLevelActions.ClickActions;

public class ButtonActions {

	public static void click(WebElement element) {
		ClickActions.clickOnElement(element);
	}

}
