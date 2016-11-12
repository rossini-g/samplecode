package pageObjects;

import org.openqa.selenium.WebDriver;

import main.actions;

/**
 * @author Ross Higgins
 * 
 */
public class PageHome extends actions
{
	private static final String eTextSearchbox = "//input[@title='Search'][@type='text']";
	private static final String eButtonSubmit = "//button[@value='Search'][@type='submit']";

	public PageHome(WebDriver setdriver)
    {
        driver = setdriver;
		driver.get(URL);
        
    }
    
    public void typeToSearchbox(String keys)
    {
    	sendKeys("xpath", eTextSearchbox, keys);
    	hardassert.pass("Enter to textbox: "+keys);
    }
    
    public PageSearch clickSearch()
    {
    	click("xpath", eButtonSubmit);
    	hardassert.pass("Click Google Search");
    	return new PageSearch(driver);
    }
}
