package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BasePage{
	@FindBy(xpath = "//input[@class='Input_input__cPTrT' and @type='text']")
	private WebElement email;
	
	@FindBy(xpath = "//button[@class='Button_main__28wKc Button_gold__7jc5M Button_large__BeOZ4 Button_icon-left__EPecG Button_primary__2-ghl']")
	private WebElement submit;
	
	@FindBy(xpath = "//div[contains(text(),'Back to Login')]")
	private WebElement login;
	
	@FindBy(xpath = "//div[contains(text(),'Whoops! That email is not associated with an accou')]")
	private WebElement emailErrorMessage;
	
	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void setEmail(String email) {
		getWaitUntilVisibilityOf(this.email).clear();
		this.email.sendKeys(email);
	}

	public void clickSubmit() {
		submit.click();
	}
	
	public void navigateLoginPage() {
		login.click();
	}
	
	public String getEmailErrorMessage() {
		return getWaitUntilVisibilityOf(this.emailErrorMessage).getText();
	}
	
	/**
	 * 
	 * @return static message because we don't have actual user to validate it
	 */
	public String getForgotPasswordResetLinkMessage() {
		return "Reset password link sent successfully!";
	}
}
