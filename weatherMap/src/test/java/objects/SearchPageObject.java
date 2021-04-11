package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SearchPageObject {

	public SearchPageObject(WebDriver driver) {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
	}

	@FindBy(xpath = "//input[@id='search_str']")
	public WebElement txtSearch;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement btnSearch;

	@FindBy(xpath = "//td[2]/p/span")
	public WebElement txtTemp;

	@FindBy(xpath = "//td[2]/p[1]")
	public WebElement txtTempMinMax;

	@FindBy(xpath="//div[@class='alert alert-warning']")
	public WebElement txtNotFound;

}
