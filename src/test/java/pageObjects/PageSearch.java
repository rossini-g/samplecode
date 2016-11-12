package pageObjects;

import org.openqa.selenium.WebDriver;

import main.actions;

/**
 * @author Ross Higgins
 * 
 */
public class PageSearch extends actions
{
	public PageSearch(WebDriver setdriver)
    {
        driver = setdriver;
		driver.get(cproperty.getProperty("URL"));
        
    }
    
    public void typeToSearchbox(String keys)
    {
    	sendKeys("xpath", "//input[@title='Search'][@type='text']", keys);
    	hardassert.pass("Enter to textbox: "+keys);
    }
    
    public PageSearch clickSearch()
    {
    	click("xpath", "//button[@value='Search'][@type='submit']");
    	hardassert.pass("Click Search");
    	return new PageSearch(driver);
    }
}
