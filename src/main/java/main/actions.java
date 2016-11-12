package main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import support.assertion;

/**
 * @author Ross Higgins
 * 
 */
public class actions extends engine {
	
	protected assertion hardassert = new assertion();
//	private SoftAssert softAssert = new SoftAssert();
	
	protected void click(String identifyBy, String locator)
	{
		try {
			if (isElementPresent(identifyBy, locator)) {				
				if(browser.startsWith("IE")||browser.equalsIgnoreCase("chrome"))
				{
					WebElement element = driver.findElement(getLocator(identifyBy,locator));
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(1000);
				}else{
					By by = getLocator(identifyBy, locator);
					driver.findElement(by).click();
				}

			} else {
				hardassert.fail("Cannot find element: By."+identifyBy+"("+ locator+")");
			}
		} catch (Exception e) {
			hardassert.fail("Unable to click element: By."+identifyBy+"("+ locator+")");
		}
	}
	
	protected void sendKeys(String identifyBy, String locator,String valuetoType){
		if (isElementPresent(identifyBy, locator)) {
			driver.findElement(getLocator(identifyBy, locator)).clear();
			driver.findElement(getLocator(identifyBy, locator)).sendKeys(valuetoType);
		} else {
			hardassert.fail("SendKeys failed. Unable to find element: By."+identifyBy+"("+ locator+")");
		}
	}
	
	protected boolean isElementPresent(String identifyBy, String locator)
	{
		boolean isPresent = false;
		try {
			if(driver.findElement(getLocator(identifyBy,locator)).isDisplayed())
			{
				highlight(driver.findElement(getLocator(identifyBy,locator)));
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",driver.findElement(getLocator(identifyBy,locator)));
				isPresent = true;				
			}
			return isPresent;
		} catch (Exception e) {
			return isPresent;
		} 
	}
	
	protected By getLocator(String identifyBy, String locator)
	{
		if (identifyBy.equalsIgnoreCase("xpath")) {
			return By.xpath(locator);
		} else if (identifyBy.equalsIgnoreCase("id")) {
			return By.id(locator);
		} else if (identifyBy.equalsIgnoreCase("class")) {
			return By.className(locator);
		} else if (identifyBy.equalsIgnoreCase("name")) {
			return By.name(locator);
		} else if (identifyBy.equalsIgnoreCase("linktext")) {
			return By.linkText(locator);
		} else if (identifyBy.equals("partialLinktext")) {
			return By.partialLinkText(locator);
		} else if (identifyBy.equals("cssselector")) {
			return By.cssSelector(locator);
		} else {
			hardassert.fail("Invalid Locator By."+identifyBy);
			return null;
		}

	}
	
	protected void highlight(WebElement element) {

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].style.border='4px solid green'", element);

		}
	}
	
}
