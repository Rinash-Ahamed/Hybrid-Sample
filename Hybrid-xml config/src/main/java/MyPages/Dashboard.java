package MyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard extends BasePage {

	private By DashboardMetric = By.xpath("//h1[@class='dashTitle'][contains(text(),'Candidates')]");

	public Dashboard(WebDriver driver) {
		super(driver);
	}

	public WebElement getDashboardMetric() {
		return getElement(DashboardMetric);
	}

	public String getLoginPageTitle() {
		return getPageTitle();
	}
}
