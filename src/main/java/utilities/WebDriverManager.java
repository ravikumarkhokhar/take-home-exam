package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import enums.DriverType;

public class WebDriverManager {
	private WebDriver driver;
	private static DriverType driverType;
	
	
	public WebDriverManager() {
		driverType = ConfigFileReader.getInstance().getBrowser();
		driver = createDriver();
	}

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	public void setupDriverConfiguration() {
		driver.manage().window().maximize();
		if (ConfigFileReader.getInstance().IsImplicitWaitEnabled()) {
			driver.manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(ConfigFileReader.getInstance().getImplicitlyWait()));
		}
	}

	private WebDriver createDriver() {
		switch (driverType) {
		case CHROME:
			io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case FIREFOX:
			io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case EDGE:
			io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
		return driver;
	}

	
}
