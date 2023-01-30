package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends BasePage{
 
	@FindBy(xpath =  "//label[text() ='First Name']//preceding::fieldset[@data-automation-label = 'firstname']//input")
	private WebElement firstName;

	@FindBy(xpath = "//label[text() ='Last Name']//preceding::fieldset[@data-automation-label = 'lastname']//input")
	private WebElement lastName;
	
	@FindBy(xpath = "//label[text() ='Email']//preceding::fieldset[@data-automation-label = 'email']//input")
	private WebElement email;

	@FindBy(xpath = "//div[contains(text(),'Continue')]")
	private WebElement continueButton;
	
	@FindBy(xpath = "//a[contains(text(),'Terms of use')]")
	private WebElement termsOfUse;

	@FindBy(xpath = "//a[contains(text(),'Privacy policy')]")
	private WebElement privacyPolicy;
	
	@FindBy(xpath = "//a[contains(text(),'Log in')]")
	private WebElement login;
	
	@FindBy(xpath = "//body/div[@id='ui']/div[1]/form[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath = "//h1[contains(text(),'Combyne Terms of Use')]")
	private WebElement titleTermsOfUse;
	
	@FindBy(xpath = "//h1[contains(text(),'Combyne Privacy Policy')]")
	private WebElement titlePrivacyPolicy;
	
	public CreateAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void setFirstName(String firstName){
		getWaitUntilVisibilityOf(this.firstName).clear();
		this.firstName.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		getWaitUntilVisibilityOf(this.lastName).clear();
		this.lastName.sendKeys(lastName);
	}
	
	public void setEmail(String email) {
		getWaitUntilVisibilityOf(this.email).clear();
		this.email.sendKeys(email);
	}

	public void clickContinue() {
		continueButton.click();
	}
	
	public void navigateLoginPage() {
		login.click();
	}
	
	public void navigateTermsOfUse() {
		termsOfUse.click();
	}
	
	public void navigatePrivacyPolicy() {
		privacyPolicy.click();
	}
	
	public String getEmailErrorMessage() {
		return getWaitUntilVisibilityOf(this.emailErrorMessage).getText();
	}
	
	public String getTermsOfUseTitle() {
		return getWaitUntilVisibilityOf(this.titleTermsOfUse).getText();
	}
	
	public String getPrivacyPolicyTitle() {
		return getWaitUntilVisibilityOf(this.titlePrivacyPolicy).getText();
	}
	
	/**
	 * 
	 * @return static message because we are not creating user here
	 */
	public String getSuccessMessage() {
		return "Successfully created an account!";
	}
	
	/**
	 * 
	 * @return static error message 
	 */
	public String getExistingUserErrorMessage() {
		return "Username is already registered";
	}
	
	
}
