package tests;

import org.openqa.selenium.WebDriver;

import utilities.ConfigFileReader;
import utilities.WebDriverManager;

abstract class BaseTest {

	protected WebDriverManager webDriverManager;
	protected WebDriver driver;
	protected final String URL_LOGIN = ConfigFileReader.getInstance().getLoginPageURL();
	protected final String URL_CREATE_ACCOUNT = ConfigFileReader.getInstance().getCreateAccountPageURL();
	protected final String URL_FORGOT_PASSWORD = ConfigFileReader.getInstance().getForgotPasswordPageURL();
	
	protected abstract void setUp();
	protected abstract void detach();
	
	protected void driverSetup() {
		webDriverManager = new WebDriverManager();
		webDriverManager.setupDriverConfiguration();
		driver = webDriverManager.getDriver();
	}
	
	protected void driverDetach() {
		driver.close();
		driver.quit();
	}
}
