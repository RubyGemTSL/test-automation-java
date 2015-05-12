package com.webtestautomationjava.webdriver;

import com.webtestautomationjava.manager.Driver;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DriverManagerTest {

    WebDriver driver;

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
        driver = Driver.get();
        driver.get("http://compendiumdev.co.uk/selenium/basic_web_page.html");
        assertThat(driver.getTitle(), is("Basic Web Page Title"));
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
