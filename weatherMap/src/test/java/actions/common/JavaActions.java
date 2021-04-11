package actions.common;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.testng.asserts.SoftAssert;

public class JavaActions {

	public static void printNameOfCurrentMethod() {
		String currentMethod = new Throwable().getStackTrace()[1].getMethodName();
		System.out.println(
				"\n\n\n########################################################################################################");
		System.out.println("\033[43m " + currentMethod + "\033[0m");
		System.out.println(
				"########################################################################################################");
	}

	public static double roundUpDoubleNumber(double doubleNumber, int decimalDigits) {
		double result = 0;
		String decimalDigitsString = "";
		for (int i = 0; i < decimalDigits; i++) {
			decimalDigitsString = decimalDigitsString + "0";
		}
		DecimalFormat decimalFormat = new DecimalFormat("0." + decimalDigitsString);
		decimalFormat.setRoundingMode(RoundingMode.UP);
		result = Double.parseDouble(decimalFormat.format(doubleNumber));
		return result;
	}

	public static void compareTwoDouble(double actual, double expected) {
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(actual, expected);
		softAssertion.assertAll();
	}

	public static void compareTwoInteger(int actual, int expected) {
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(actual, expected);
		softAssertion.assertAll();
	}

	public static void compareTwoString(String actual, String expected) {
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(actual, expected);
		softAssertion.assertAll();
	}
}
