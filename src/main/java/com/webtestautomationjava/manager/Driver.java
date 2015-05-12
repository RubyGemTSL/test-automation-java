package com.webtestautomationjava.manager;

import org.openqa.selenium.WebDriver;


public class Driver extends Thread {

    public static final String BROWSER = "browser";

    public static WebDriver get() {

        String browserToUse="";

        if(System.getProperties().containsKey(BROWSER)){
            browserToUse = System.getProperty(BROWSER);
        }

        switch(browserToUse) {
            case "firefox":
                return DriverManager.createFirefoxDriver();
            case "htmlunit":
                return DriverManager.createHtmlUnitDriver();
            case "chrome":
                return DriverManager.createChromeDriver();
            case "iphone5s":
                return DriverManager.createIphone5Driver();
            case "ipadair":
                return DriverManager.createIPadAirDriver();
            case "nexus7":
                return DriverManager.createAndroidNexus7Driver();
            default:
                return DriverManager.createFirefoxDriver();
        }

    }
}
