package actions.common;

import java.util.List;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiActions {

	public static String getResponseAfterSearching(String domain, String searchString) {
		RestAssured.baseURI = domain + "/data/2.5/find";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.queryParam("q", searchString)
				.queryParam("appid", "439d4b804bc8187953eb36d2a8c26a02").get();
		String jsonResponse = response.asPrettyString();
		return jsonResponse;
	}

	public static double getTemperatureInFirstSearchResult(String jsonResponse, String jsonPath) {
		List<Double> temperatureList = JsonPath.parse(jsonResponse).read(jsonPath);
		double tempurature = temperatureList.get(0);
		return tempurature;
	}

	public static double convertKelvinTemperatureToCelsius(double kelvinTemperature, int decimalDigits) {
		double celsiusTemperature;
		celsiusTemperature = kelvinTemperature - 273;
		celsiusTemperature = JavaActions.roundUpDoubleNumber(celsiusTemperature, decimalDigits);
		return celsiusTemperature;
	}

	public static int getStatusCode(String jsonResponse) {
		String status = JsonPath.parse(jsonResponse).read("cod");
		int statusCode = Integer.parseInt(status);
		return statusCode;
	}
}
