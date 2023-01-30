package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ForgotPasswordPage;

public class ForgotPasswordTest extends BaseTest{

	private ForgotPasswordPage forPasswordPage;
	
	@Override
	@BeforeMethod
	protected void setUp() {
		driverSetup();
		forPasswordPage = new ForgotPasswordPage(driver);
		driver.get(URL_FORGOT_PASSWORD);
	}

	@Override
	@AfterMethod
	protected void detach() {
		forPasswordPage = null;
		driverDetach();
	}
	
	@Test(description = "TC_CBN_FP_02: Verify Forgot password functionality without providing email")
	public void forgotPasswordWithoutCredentialsTest() {
		forPasswordPage.setEmail("");
		forPasswordPage.clickSubmit();
		Assert.assertEquals(forPasswordPage.getEmailErrorMessage(), "Whoops! That email is not associated with an account.");
	}
	
	@Test(description = "TC_CBN_FP_03: Verify Forgot password functionality providing invalid email")
	public void forgotPasswordWithInvalidCredentialsTest() {
		forPasswordPage.setEmail("testuser");
		forPasswordPage.clickSubmit();
		Assert.assertEquals(forPasswordPage.getEmailErrorMessage(), "Whoops! That email is not associated with an account.");
	}
	
	@Test(description = "TC_CBN_FP_04: Verify Forgot password functionality providing valid email")
	public void forgotPasswordWithValidCredentialsTest(){
		forPasswordPage.setEmail("testuser@gmail.com");
		forPasswordPage.clickSubmit();
		// Here we are assuming that user has valid email and combyne user
		Assert.assertEquals(forPasswordPage.getForgotPasswordResetLinkMessage(), "Reset password link sent successfully!");
	}
	
	@Test(description = "TC_CBN_FP_05: Verify Forgot password functionality providing valid email but not a combyne application member")
	public void forgotPasswordWithValidCredentialsButNotCombyneUserTest() {
		forPasswordPage.setEmail("testuser12@gmail.com");
		forPasswordPage.clickSubmit();
		Assert.assertEquals(forPasswordPage.getEmailErrorMessage(), "Whoops! That email is not associated with an account.");
	}
	
	@Test(description = "TC_CBN_FP_06: Verify Back to login navigation")
	public void loginPageLinkNavigationTest() {
		forPasswordPage.navigateLoginPage();
		Assert.assertEquals(driver.getCurrentUrl(), URL_LOGIN);
	}
}
