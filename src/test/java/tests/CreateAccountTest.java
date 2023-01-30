package tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CreateAccountPage;

public class CreateAccountTest extends BaseTest{

	private CreateAccountPage createAccountPage;
	
	@Override
	@BeforeMethod
	protected void setUp() {
		driverSetup();
		createAccountPage = new CreateAccountPage(driver);
		driver.get(URL_CREATE_ACCOUNT);
	}

	@Override
	@AfterMethod
	protected void detach() {
		createAccountPage = null;
		driverDetach();
	}
	
	@Test(description = "TC_CBN_CAA_03: Verify Create an account functionality valid inputs firstname, lastname, and email")
	public void createAnAccountWithValidCredentialsTest() {
		createAccountPage.setFirstName("Test");
		createAccountPage.setLastName("User");
		createAccountPage.setEmail("Testuser@gmail.com");
		// here we are not creating an account
		// createAccountPage.clickContinue();
		Assert.assertEquals(createAccountPage.getSuccessMessage(), "Successfully created an account!");
	}
	
	
	@Test(description = "TC_CBN_CAA_04: Verify Create an account functionality with existing user")
	public void createAnAccountWithValidCredentialsButUserAlreadyCreatedTest() {
		createAccountPage.setFirstName("Test");
		createAccountPage.setLastName("User");
		createAccountPage.setEmail("Testuser12@gmail.com");
		// here we are not creating an account
		// createAccountPage.clickContinue();
		Assert.assertEquals(createAccountPage.getExistingUserErrorMessage(), "Username is already registered");
	}

	@Test(description = "TC_CBN_CAA_05: Verify Create an account functionality with invalid email")
	public void createAnAccountWithInvalidEmailTest() {
		createAccountPage.setFirstName("Test");
		createAccountPage.setLastName("User");
		createAccountPage.setEmail("Testuser");
		createAccountPage.clickContinue();
		// here I'm failing the test cases to see failed test cases in a report
		Assert.assertEquals(createAccountPage.getEmailErrorMessage(), "The provided email is invalid !!");
	}

	
	@Test(description = "TC_CBN_CAA_06: Verify Terms of use navigation")
	public void termsOfUseLinkNavigationTest() {
		createAccountPage.navigateTermsOfUse();
		List<String> tabList = new ArrayList<String>(driver.getWindowHandles());
		// switch to terms of use tab
		driver.switchTo().window(tabList.get(1));
		Assert.assertEquals(createAccountPage.getTermsOfUseTitle(), "Combyne Terms of Use");
	}
	
	
	@Test(description = "TC_CBN_CAA_07: Verify Privacy policy navigation")
	public void privacyPolicyLinkNavigationTest() {
		createAccountPage.navigatePrivacyPolicy();
		List<String> tabList = new ArrayList<String>(driver.getWindowHandles());
		// switch to privacy policy tab
		driver.switchTo().window(tabList.get(1));
		Assert.assertEquals(createAccountPage.getPrivacyPolicyTitle(), "Combyne Privacy Policy");
	}
	
	@Test(description = "TC_CBN_CAA_08: Verify Login page navigation")
	public void loginPageLinkNavigationTest() {
		createAccountPage.navigateLoginPage();
		Assert.assertEquals(driver.getCurrentUrl(), URL_LOGIN);
	}

}
