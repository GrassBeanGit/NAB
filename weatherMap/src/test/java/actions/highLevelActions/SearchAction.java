package actions.highLevelActions;

import org.openqa.selenium.WebDriver;

import actions.common.ApiActions;
import actions.common.JavaActions;
import actions.controlActions.ButtonActions;
import actions.controlActions.TextActions;
import actions.controlActions.TextFieldActions;
import objects.SearchPageObject;

public class SearchAction {

	private WebDriver driver;

	public SearchAction(WebDriver driver) {
		this.driver = driver;
	}

	public void searchWeather(String searchString) {
		SearchPageObject searchPage = new SearchPageObject(driver);
		TextFieldActions.setValue(searchPage.txtSearch, searchString);
		ButtonActions.click(searchPage.btnSearch);
	}

	public void compareUITemperatureAndApiTemperature(String domain, String searchString) {
		SearchPageObject searchPage = new SearchPageObject(driver);
		String jsonResponse = ApiActions.getResponseAfterSearching(domain, searchString);
		compareUITemperatureAndApiTemperature(searchPage, jsonResponse);
		compareUITemperatureMinMaxAndApiTemperatureMinMax(searchPage, jsonResponse);
	}

	private void compareUITemperatureMinMaxAndApiTemperatureMinMax(SearchPageObject searchPage, String jsonResponse) {
		String uiTempMaxMinString = TextActions.getText(searchPage.txtTempMinMax);
		String uiTempMaxMinSplittedString[] = uiTempMaxMinString.split(" ");
		String uiTempMinString = uiTempMaxMinSplittedString[3];
		String uiTempMaxString = uiTempMaxMinSplittedString[5];

		double uiTempMin = Double.parseDouble(uiTempMinString);
		double uiTempMax = Double.parseDouble(uiTempMaxString);

		double apiCelsiusTempMin = convertKelvinTemperatureToCelsiusTemperature(jsonResponse, "$..main.temp_min");
		double apiCelsiusTempMax = convertKelvinTemperatureToCelsiusTemperature(jsonResponse, "$..main.temp_max");

		System.out.println("UI TEMP MIN = " + uiTempMin);
		System.out.println("API TEMP MIN = " + apiCelsiusTempMin);
		System.out.println("UI TEMP MAX = " + uiTempMax);
		System.out.println("API TEMP MAX = " + apiCelsiusTempMax);

		JavaActions.compareTwoDouble(uiTempMin, apiCelsiusTempMin);
		JavaActions.compareTwoDouble(uiTempMax, apiCelsiusTempMax);
	}

	private void compareUITemperatureAndApiTemperature(SearchPageObject searchPage, String jsonResponse) {
		String uiTempString = TextActions.getText(searchPage.txtTemp);
		uiTempString = uiTempString.substring(0, uiTempString.length() - 2);
		double uiTemp = Double.parseDouble(uiTempString);

		double apiCelsiusTemp = convertKelvinTemperatureToCelsiusTemperature(jsonResponse, "$..main.temp");

		System.out.println("UI TEMP = " + uiTemp);
		System.out.println("API TEMP = " + apiCelsiusTemp);

		JavaActions.compareTwoDouble(uiTemp, apiCelsiusTemp);
	}

	private double convertKelvinTemperatureToCelsiusTemperature(String jsonResponse, String jsonPath) {
		double apiTemp = ApiActions.getTemperatureInFirstSearchResult(jsonResponse, jsonPath);
		double apiCelsiusTemp = ApiActions.convertKelvinTemperatureToCelsius(apiTemp, 1);
		return apiCelsiusTemp;
	}
	
	public void verifyResultWhenSearchStringIsWrong(String expectation) {
		SearchPageObject searchPage = new SearchPageObject(driver);
		String result = TextActions.getText(searchPage.txtNotFound);
		result = result.replace("×\n", "");
		JavaActions.compareTwoString(result, expectation);
	}
}
