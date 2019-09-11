package MyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import MyPages.BasePage;
import MyPages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	public Page page;
	
	@BeforeMethod
	@Parameters(value = {"browser"})
	public void setUpTest(String browser) throws InterruptedException {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
		}else {
			System.out.println("no browser is defined in xml file...");
		}
		
		driver.get("url");
		try {
		Thread.sleep(6000);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("timeout waiting fot getting URL");
		}
		page = new BasePage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
