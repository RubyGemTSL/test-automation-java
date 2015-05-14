//package com.webtestautomationjava.webdriver.junit;
//
//import com.webtestautomationjava.utils.ReadPropertiesFile;
//import com.webtestautomationjava.manager.junit.Driver;
//import com.webtestautomationjava.pages.HomePage;
//import com.webtestautomationjava.pages.LoginPage;
//import org.junit.After;
//import org.junit.Test;
//
//import static org.hamcrest.MatcherAssert.*;
//
//import org.openqa.selenium.WebDriver;
//
//public class DriverManagerTest {
//
//    WebDriver driver;
//    public static ReadPropertiesFile getProperty = new ReadPropertiesFile();
//
//    @Test
//    public void createAFirefoxDriver() {
//        System.setProperty(Driver.BROWSER, "firefox");
//        assertBrowserTestRuns();
//    }
//
//    @Test
//    public void createAnHtmlUnitDriver() {
//        System.setProperty(Driver.BROWSER, "htmlunit");
//        assertBrowserTestRuns();
//    }
//
//    @Test
//    public void createChromeDriver() {
//        System.setProperty(Driver.BROWSER, "chrome");
//        assertBrowserTestRuns();
//    }
//
//    @Test
//    public void createIPhoneDriver() {
//        System.setProperty(Driver.BROWSER, "iphone5s");
//        assertBrowserTestRuns();
//    }
//
//    @Test
//    public void createIPadAirDriver() {
//        System.setProperty(Driver.BROWSER, "ipadair");
//        assertBrowserTestRuns();
//    }
//
//    @Test
//    public void createAndroidNexus7Driver() {
//        System.setProperty(Driver.BROWSER, "nexus7");
//        assertBrowserTestRuns();
//    }
//
//    @Test
//    public void createADefaultDriver() {
//        assertBrowserTestRuns();
//    }
//
//    public void assertBrowserTestRuns() {
//
//        driver = Driver.get();
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.get();
//
//        loginPage.loginWith(getProperty.Config().getProperty("testUsername"), getProperty.Config().getProperty("testPassword"));
//
//        HomePage homePage = new HomePage(driver);
//        assertThat("Dashboard heading was not displayed", homePage.wpbodyContent.getText().contains("Dashboard"));
//    }
//
//    @After
//    public void quitDriver() {
//        driver.quit();
//    }
//}
