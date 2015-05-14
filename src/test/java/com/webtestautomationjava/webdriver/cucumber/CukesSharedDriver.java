package com.webtestautomationjava.webdriver.cucumber;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Based on shared webdriver implementation in cucumber-jvm examples
 * A new instance of SharedDriver is created for each Scenario and passed to  Stepdef classes via Dependency Injection
 */

public class CukesSharedDriver extends EventFiringWebDriver {
    private static WebDriver REAL_DRIVER;
    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            REAL_DRIVER.quit();
        }
    };

    static {

        String BROWSER = "browser";
        String browserToUse = "";

        if (System.getProperties().containsKey(BROWSER)) {
            browserToUse = System.getProperty(BROWSER);
        }

        switch (browserToUse) {
            case "firefox":
                REAL_DRIVER = CukesDriverManager.createFirefoxDriver();
            case "htmlunit":
                REAL_DRIVER = CukesDriverManager.createHtmlUnitDriver();
            case "chrome":
                REAL_DRIVER = CukesDriverManager.createChromeDriver();
            case "iphone5s":
                REAL_DRIVER = CukesDriverManager.createIphone5Driver();
            case "ipadair":
                REAL_DRIVER = CukesDriverManager.createIPadAirDriver();
            case "nexus7":
                REAL_DRIVER = CukesDriverManager.createAndroidNexus7Driver();
            default:
                REAL_DRIVER = CukesDriverManager.createFirefoxDriver();

        }

       REAL_DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public CukesSharedDriver() {
        super(REAL_DRIVER);
    }

    @Override
    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException("You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        super.close();
    }

    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void deleteAllCookies() {
        manage().deleteAllCookies();
    }

    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {
        scenario.write("Current Page URL is " + getCurrentUrl());
        try {
            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
    }

}
