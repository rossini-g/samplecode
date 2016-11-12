package testScripts;

import org.testng.annotations.*;
import main.setup;
import pageObjects.PageHome;
import pageObjects.PageSearch;

/**
 * @author Ross Higgins
 *
 */
public class TCID_1 extends setup
{
    @Test(groups = { "T1" })
    public void method1test() {
        System.out.println("Test Google Search");
        
        PageHome homePage = new PageHome(driver);
        //Step 1: type to Search box
        homePage.typeToSearchbox("selenium frameworks");
        //Step 2: click search
        PageSearch searchPage = homePage.clickSearch();
        //Step 3: type to searchbox
        searchPage.typeToSearchbox("selenium java test");
        //Step 4: click search
        searchPage.clickSearch();
    }
 
    @Test(groups = { "T2" })
    public void method2test() {
        System.out.println("Test method two");
    }
 
}
