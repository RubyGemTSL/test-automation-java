package com.webtestautomationjava.webdriver;

import com.webtestautomationjava.ReadPropertiesFile;
import com.webtestautomationjava.manager.Driver;
import com.webtestautomationjava.pages.HomePage;
import com.webtestautomationjava.pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.is;
import org.openqa.selenium.WebDriver;

public class DriverManagerTest {

    WebDriver driver;
    private LoginPage loginPage;
    public static ReadPropertiesFile getProperty = new ReadPropertiesFile();

    @Before
    public void setupTest(){
        driver = Driver.get();
        loginPage = new LoginPage(driver);
        loginPage.get();
    }

    @Test
    public void createAFirefoxDriver() {
        System.setProperty(Driver.BROWSER, "firefox");
        assertBrowserTestRuns();
    }

    @Test
    public void createAnHtmlUnitDriver() {
        System.setProperty(Driver.BROWSER, "htmlunit");
        assertBrowserTestRuns();
    }

    @Test
    public void createChromeDriver() {
        System.setProperty(Driver.BROWSER, "chrome");
        assertBrowserTestRuns();
    }

    @Test
    public void createIPhoneDriver() {
        System.setProperty(Driver.BROWSER,"iphone5s");
        assertBrowserTestRuns();
    }

    @Test
    public void createIPadAirDriver() {
        System.setProperty(Driver.BROWSER,"ipadair");
        assertBrowserTestRuns();
    }

    @Test
    public void createAndroidNexus7Driver() {
        System.setProperty(Driver.BROWSER,"nexus7");
        assertBrowserTestRuns();
    }

    @Test
    public void createADefaultDriver() {
        assertBrowserTestRuns();
    }

    public void assertBrowserTestRuns() {
        
        loginPage.login(getProperty.Config().getProperty("testUsername"), getProperty.Config().getProperty("testPassword"));
        
        HomePage homePage = new HomePage(driver);
        assertThat("Dashboard heading was not displayed", homePage.wpbodyContent.getText().contains("Dashboard"));
  }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
