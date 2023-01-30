package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ConfigFileReader;

abstract class BasePage {
	
	
	protected WebDriver driver;
	private WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigFileReader.getInstance().getExplicitWait()));
	}
	
	public WebElement getWaitUntilVisibilityOf(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement getWaitUntilVisibilityOf(By by) {
		return wait.until(ExpectedConditions.visibilityOf(findElement(by)));
	}
	
	public WebElement findElement(By by) {
		return this.driver.findElement(by);
	}
	
	public WebElement getWaitUntilClickableOf(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement getWaitUntilClickableOf(By by) {
		return wait.until(ExpectedConditions.elementToBeClickable(findElement(by)));
	}
	
	public boolean isElementPresent(WebElement element) {
		return getWaitUntilVisibilityOf(element).isDisplayed();
	}

	
}
