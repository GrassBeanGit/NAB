package testModule.api;

import org.testng.annotations.Test;

import actions.common.ApiActions;
import actions.common.JavaActions;
import constants.UrlsConstants;

public class ApiSearchFeatureTest {

	@Test
	public void verifyErrorCode429IsReturnedWhenCallingApiMoreThan61Times() {
		JavaActions.printNameOfCurrentMethod();

		long startTime = System.nanoTime();
		for (int i = 0; i < 61; i++) {
			ApiActions.getResponseAfterSearching(UrlsConstants.HOME, "London, GB");
		}
		long endTime = System.nanoTime();
		long executionTime = endTime - startTime;

		if (executionTime / 1000000000 > 60) {
			JavaActions.compareTwoInteger(1, 0);
		} else {
			String jsonResponse = ApiActions.getResponseAfterSearching(UrlsConstants.HOME, "London, GB");

			int statusCode = ApiActions.getStatusCode(jsonResponse);
			JavaActions.compareTwoInteger(statusCode, 429);
		}
	}
}
