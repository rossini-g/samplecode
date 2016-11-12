package main;

import org.openqa.selenium.WebDriver;

import support.configuration;

public class engine {
	public configuration cproperty = new configuration(
			"config.properties");
	public WebDriver driver;
	public String browser = cproperty.getProperty("browserType");
	public String URL =cproperty.getProperty("URL");
	int implicitWait = Integer.valueOf(cproperty.getProperty("ImplicitWait"));
	
	
}
