package testModule.ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import actions.controlActions.BrowserActions;
import constants.UrlsConstants;

public class BaseTest {

	public WebDriver driver;
	public String filePath;

	@Parameters("usageBrowserName")

	@BeforeMethod
	public void executePreCondition(String usageBrowserName) throws Exception {
		driver = BrowserActions.openWebsite(usageBrowserName, UrlsConstants.SEARCH_PAGE);
	}

	@AfterMethod
	public void executePosCondition() {
		BrowserActions.closeAllOfBrowsers(driver);
	}

}
