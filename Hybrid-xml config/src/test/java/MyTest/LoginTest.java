package MyTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import MyPages.Dashboard;
import MyPages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Heptagon Portal");
	}
	
	@Test
	public void doLogintest() {
		Dashboard homepage = page.getInstance(LoginPage.class).doLogin("USERNAME","PASSWORD");
		WebElement metric = homepage.getDashboardMetric();
		System.out.println(metric.toString());
		Assert.assertEquals(metric, "Candidates");
	}
}
