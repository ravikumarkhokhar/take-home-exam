package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	@FindBy(xpath = "//input[@class='Input_input__cPTrT' and @type='text']")
	private WebElement email;

	@FindBy(xpath = "//input[@class='Input_input__cPTrT' and @type='password']")
	private WebElement password;

	@FindBy(xpath = "//div[contains(text(),'Log in')]")
	private WebElement login;
	
	@FindBy(xpath = "//div[contains(text(),'Forgot your password?')]")
	private WebElement forgotPassword;
	
	@FindBy(xpath = "//a[contains(text(),'Create an Account')]")
	private WebElement createAccount;
	
	@FindBy(xpath = "//a[contains(text(),'Contact Us')]")
	private WebElement contactUs;
	
	@FindBy(xpath = "//body/div[@id='ui']/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath = "//body/div[@id='ui']/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]")
	private WebElement passwordErrorMessage;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void setUserName(String userName){
		getWaitUntilVisibilityOf(this.email).clear();
		this.email.sendKeys(userName);
	}

	public void setPassword(String password) {
		getWaitUntilVisibilityOf(this.password).clear();
		this.password.sendKeys(password);
	}

	public void clickLogin() {
		this.login.click();
	}
	
	public void navigateForgotPassword() {
		this.forgotPassword.click();
	}
	
	public void navigateCreateAnAccount() {
		this.createAccount.click();
	}
	
	public void contactUs() {
		this.contactUs.click();
	}
	
	public String getEmailErrorMessage() {
		return getWaitUntilVisibilityOf(this.emailErrorMessage).getText();
	}
	
	public String getPasswordErrorMessage() {
		return getWaitUntilVisibilityOf(this.passwordErrorMessage).getText();
	}
	
	/**
	 * 
	 * @return static message because we don't have actual user to validate it
	 */
	public String getLoginSuccessMessage() {
		return "Login Successfully!";
	}
}
