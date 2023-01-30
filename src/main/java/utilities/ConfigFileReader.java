package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = "properties//config.properties";
	public static ConfigFileReader configFileReader;

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public static ConfigFileReader getInstance() {
		if (configFileReader == null) {
			configFileReader = new ConfigFileReader();
		}
		return configFileReader;
	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals("chrome"))
			return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browserName.equalsIgnoreCase("edge"))
			return DriverType.EDGE;
		else
			throw new RuntimeException("Browser Name Key value in config.properties is not matched : " + browserName);
	}

	public boolean IsImplicitWaitEnabled() {
		String waitEnable = properties.getProperty("implicitWaitEnable");
		return Boolean.parseBoolean(waitEnable);
	}

	public long getImplicitlyWait() {
		String wait = properties.getProperty("implicitlyWait");
		long longWait = 0l;
		if (wait != null) {
			try {
				longWait = Long.parseLong(wait);
			} catch (NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + wait + " in to Long");
			}
		}
		return longWait;
	}
	
	public long getExplicitWait() {
		String wait = properties.getProperty("explicitWait");
		long longWait = 0l;
		if (wait != null) {
			try {
				longWait = Long.parseLong(wait);
			} catch (NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + wait + " in to Long");
			}
		}
		return longWait;
	}
	
	public String getLoginPageURL() {
		return properties.getProperty("loginURL");
	}
	
	public String getForgotPasswordPageURL() {
		return properties.getProperty("forgotPasswordURL");
	}
	
	public String getCreateAccountPageURL() {
		return properties.getProperty("createAccountURL");
	}
}
