package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest{

	private LoginPage loginPage;
	
	@Override
	@BeforeMethod
	protected void setUp() {
		driverSetup();
		loginPage = new LoginPage(driver);
		driver.get(URL_LOGIN);
	}

	@Override
	@AfterMethod
	protected void detach() {
		loginPage = null;
		driverDetach();
	}
	
	@Test(description = "TC_CBN_LOGIN_02: Verify login system without providing username and password")
	public void loginWithEmptyCredentialsTest() {
		loginPage.setUserName("");
		loginPage.setPassword("");
		loginPage.clickLogin();
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "field required");
		Assert.assertEquals(loginPage.getPasswordErrorMessage(), "field required");
	}

	@Test(description = "TC_CBN_LOGIN_05: Verify login system providing invaid username and invalid password")
	public void loginWithInvalidCredentialsTest() {
		loginPage.setUserName("testuser");
		loginPage.setPassword("1234");
		loginPage.clickLogin();
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "value is not a valid email address");
		Assert.assertEquals(loginPage.getPasswordErrorMessage(), "ensure this value has at least 8 characters");
	}
	

	@Test(description = "TC_CBN_LOGIN_06: Verify login system providing valid username and valid password")
	public void loginWithValidCredentialsTest() {
		loginPage.setUserName("testuser@gmail.com");
		loginPage.setPassword("test1234");
		loginPage.clickLogin();
		// Here we are assuming that user successfully logged into our system
		// because I don't have original credentials to check user is in home page or not.
		Assert.assertEquals(loginPage.getLoginSuccessMessage(), "Login Successfully!");
	}
	
	@Test(description = "TC_CBN_LOGIN_07: Verify login system providing vaid username and valid password but not Combyne User")
	public void loginWithValidCredentialsButNotCombyneUserTest() {
		loginPage.setUserName("testuser12@gmail.com");
		loginPage.setPassword("test1234");
		loginPage.clickLogin();
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Username not found");
	}
	
	@Test(description = "TC_CBN_LOGIN_11: Verify Forgot password navigation")
	public void forgotPasswordLinkNavigationTest() {
		loginPage.navigateForgotPassword();
		Assert.assertEquals(driver.getCurrentUrl(), URL_FORGOT_PASSWORD);
	}
	
	@Test(description = "TC_CBN_LOGIN_12: Verify Create an account navigation")
	public void createAnAccountLinkNavigationTest() {
		loginPage.navigateCreateAnAccount();
		Assert.assertEquals(driver.getCurrentUrl(), URL_CREATE_ACCOUNT);
	}
	
	
}
