package main;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class setup extends engine
{
	
	public WebDriver loadbrowser()
    {
        System.out.println( "Loading browser: "+browser);
        
        if(browser.equalsIgnoreCase("Chrome"))
		{
        	System.setProperty("webdriver.chrome.driver", cproperty.getProperty("Browser_Chrome"));
        	
        	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        	ChromeOptions options = new ChromeOptions();
        	options.addArguments("--disable-extensions");
//        	capabilities.setCapability("chrome.switches",
//        	        Arrays.asList("--homepage=http://google.com/"));
        	capabilities.setCapability( ChromeOptions.CAPABILITY, options);
        	driver = new ChromeDriver(capabilities);
			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			cap.setJavascriptEnabled(true);			
			//File file = new File(".//lib//IEDriverServer.exe");
			System.setProperty("driver.ie.driver", cproperty.getProperty("Browser_IE"));
			driver = new InternetExplorerDriver(cap);
			driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		}
		
		return driver;
    }
	
	
	@BeforeSuite(alwaysRun=true)
	public void beforeSuite() throws Throwable{
		
		System.out.println( "Executing: Before Suite" );
	}
	
	 @BeforeTest
	 public void beforeTest() throws Exception {
		 System.out.println( "Executing: Before Test" );
		 driver = loadbrowser();
		 driver.manage().window().maximize();
	 }
	 
	 @AfterTest
	 public void afterTest() throws Exception {
		 System.out.println( "Executing: Before Test" );
		 driver.quit();
	 }
}
