package com.webtestautomationjava.manager;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static Boolean getIsJavascriptEnabled() {
        String jsEnabled = System.getProperties().getProperty("javascriptEnabled");
        if (jsEnabled != "false") {
            return true;
        } else {
            System.out.println(" . . . Tests will be executed in non javascript mode . . .");
            return false;
        }
    }

    public static WebDriver createFirefoxDriver() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setEnableNativeEvents(true);
        profile.setPreference("javascript.enabled", getIsJavascriptEnabled());
        WebDriver driver = new FirefoxDriver(profile);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver createHtmlUnitDriver() {
        return new HtmlUnitDriver();
    }

    public static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setJavascriptEnabled(getIsJavascriptEnabled());
        ChromeOptions options = new ChromeOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriver driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver createIphone5Driver() {
        try {
            return createAppiumDriver("iPhone 5s", "iOS", "8.1", "Safari");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static WebDriver createIPadAirDriver() {
        try {
            return createAppiumDriver("iPad Air", "iOS", "8.1", "Safari");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static WebDriver createAndroidNexus7Driver() {
        try {
            return createAppiumDriver("Nexus7", "Android", "4.4.2", "Browser");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static WebDriver createAppiumDriver(String deviceName, String platformName, String platformVersion, String browserName) throws MalformedURLException {
        WebDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

}
