package actions.controlActions;

import org.openqa.selenium.WebDriver;

import actions.lowLevelActions.OpenActions;

public class BrowserActions {

	public static WebDriver openWebsite(String usageBrowserName, String websiteLink) {
		return OpenActions.openWebsite(usageBrowserName, websiteLink);
	}

	public static WebDriver openWebsite(String usageBrowserName, String websiteLink, int pageLoadTimeOutInMinutes) {
		return OpenActions.openWebsite(usageBrowserName, websiteLink, pageLoadTimeOutInMinutes);
	}

	public static void closeAllOfBrowsers(WebDriver driver) {
		driver.quit();
	}

	public static String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
}
