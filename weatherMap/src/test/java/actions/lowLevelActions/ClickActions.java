package actions.lowLevelActions;

import org.openqa.selenium.WebElement;

public class ClickActions {

	public static void clickOnElement(WebElement element) {
		if (element.isEnabled()) {
			element.click();
		} else {
			WaitActions.waitUntilElementToBeClickable(element, 10);
		}
	}

	public static void clickOnElement(WebElement element, int timeOutInSeconds) {
		if (element.isEnabled()) {
			element.click();
		} else {
			WaitActions.waitUntilElementToBeClickable(element, timeOutInSeconds);
		}
	}
}
