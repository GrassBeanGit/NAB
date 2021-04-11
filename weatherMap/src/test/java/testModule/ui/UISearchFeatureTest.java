package testModule.ui;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import actions.common.JavaActions;
import actions.highLevelActions.SearchAction;
import actions.lowLevelActions.WaitActions;
import constants.UrlsConstants;

public class UISearchFeatureTest extends BaseTest {

	@Test
	public void verifyCelsiusTemperatureIsConvertedFromKelvinTemperatureCorrectly() {

		JavaActions.printNameOfCurrentMethod();

		SearchAction searchAction = new SearchAction(driver);
		searchAction.searchWeather("London, GB");

		WaitActions.waitUntilVisibilityOfElementLocated(driver, By.xpath("//td[2]/p/span"), 10);

		searchAction.compareUITemperatureAndApiTemperature(UrlsConstants.HOME, "London, GB");
	}

	@Test
	public void verifyNotFoundStringIsReturnWhenSearchValueIsWrong() {

		JavaActions.printNameOfCurrentMethod();

		SearchAction searchAction = new SearchAction(driver);
		searchAction.searchWeather("London1");

		WaitActions.waitUntilVisibilityOfElementLocated(driver, By.xpath("//div[@class='alert alert-warning']"), 10);

		searchAction.verifyResultWhenSearchStringIsWrong("Not found");
	}
}
