package actions.lowLevelActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenActions {

	public static WebDriver openWebsite(String usageBrowserName, String websiteLink) {
		WebDriver driver = null;
		driver = getWebDriver(usageBrowserName);
		driver.get(websiteLink);
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
		return driver;
	}

	private static WebDriver getWebDriver(String usageBrowserName) {
		WebDriver driver = null;
		switch (usageBrowserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		}
		return driver;
	}

	public static WebDriver openWebsite(String usageBrowserName, String websiteLink, int pageLoadTimeOutInMinutes) {
		WebDriver driver = null;
		driver = getWebDriver(usageBrowserName);
		driver.get(websiteLink);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOutInMinutes, TimeUnit.MINUTES);
		return driver;
	}
}
