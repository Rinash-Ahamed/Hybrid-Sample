package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BasePage extends BrowserFactory{

	BrowserFactory activity = BrowserFactory.getInstance();

	@Parameters("browserName")
	@Test
	public void launch(String browserName) throws Exception {
		try {
		activity.setBrowser(browserName);
		activity.driver().get(activity.readData("url"));
		activity.waitUntil(username, 50, "visibility");
		activity.sendKeys(username, readData("Username"));
		activity.sendKeys(password, readData("Password"));
		activity.click(loginBT);
		Thread.sleep(5000);
		activity.driver().get(readData("ninjaUrl"));
		activity.waitUntil(homePageVerify, 50, "visibility");
//		activity.waitUntil(messagesTab, 40, "clickable");
//		activity.click(messagesTab);
//		Thread.sleep(2000);
//		activity.waitUntil(spinner, 50, "invisibility");
//		activity.waitUntil(newMessage, 50, "clickable");
//		activity.click(newMessage);
//		activity.switchToNewWindow();
//		Thread.sleep(2000);
//		activity.waitUntil(spinner, 50, "invisibility");
//		activity.waitUntil(sendMessage, 50, "visibility");
//		activity.click(sendMessage);
//		activity.waitUntil(sendMessageVerify, 40, "visibility");
//		Thread.sleep(3000);
//		activity.waitUntil(topicDropdown, 30, "clickable");
//		activity.selectDropdown(topicDropdown, "A claim");
//		activity.waitUntil(sidetile, 40, "visibility");
//		activity.waitUntil(radio, 30, "clickable");
//		activity.click(radio);
//		activity.sendKeys(provider, "Quest Incorporation");
//		Thread.sleep(1000);
//		activity.click(dateOfService);
//		activity.PressEnter(); 
//		activity.uploadFiles(uploadAttachment, "sample.pdf");
//		Thread.sleep(2000);
//		WebElement emailText = activity.getElement(email);
//		if (emailText.getText().isEmpty()) {
//			String emailAdd = "testingParallel@mailinator.com";
//			activity.sendKeys(email, emailAdd);
//			activity.waitUntil(reEnteremail, 20, "visibility");
//			activity.sendKeys(reEnteremail, emailAdd);
//		} else {
//			System.out.println("Member E-mail is already available in Email Address field");
//		}
//		activity.sendKeys(msgBox, "Testing Message Box");
//		activity.waitUntil(sendbutton, 40, "visibility");
//		activity.click(sendbutton);
//		activity.waitUntil(spinner, 50, "invisibility");
//		activity.waitUntil(confirmation, 40, "visibilty");
		}catch (Exception e) {
			System.out.println(this.getClass().getEnclosingMethod().getName()+ " funtion failed "+e.toString());
		}
	}

	@Parameters("browserName")
	@AfterTest
	public void tearDown(String browserName) {
		thread.get().quit();
		System.out.println("Executed successfully on: " + browserName);
		
	}
}
