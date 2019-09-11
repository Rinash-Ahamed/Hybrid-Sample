package MyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Rinash Ahamed
 *
 */
public class LoginPage extends BasePage {

	// page locators:
	private By userName = By.id("username");
	private By password = By.id("password");
	private By loginButton = By.className("loginLnk");
//	private By loginerror = By.xpath("//div[@class='invalid_errors']");
//	private By logo = By.xpath("//a[@class='logo-link']//img");
//	private By Hellocheck = By.xpath("//span[contains(text(),'Hello')]");
//	private By DashboardMetric = By.xpath("//h1[@class='dashTitle'][contains(text(),'Candidates')]");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//public getters:
	public WebElement getUserName() {
		return getElement(userName);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLoginButton() {
		return getElement(loginButton);
	}	
	
	public String getLoginPageTitle() {
		return getPageTitle();
	}
	
	public Dashboard doLogin(String username, String password) {
		getUserName().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginButton().click();
		
		return getInstance(Dashboard.class);
	}

	public void doLogin() {
		getUserName().sendKeys();
		getPassword().sendKeys();
		getLoginButton().click();
	
		}
	
	public void doLogin(String userCredentials) {
		if(userCredentials.contains("username")) {
			getUserName().sendKeys(userCredentials.split(":")[1].trim());
		}else if(userCredentials.contains("password")) {
			getPassword().sendKeys(userCredentials.split(":")[1].trim());
		}
		getLoginButton().click();
	}
}
