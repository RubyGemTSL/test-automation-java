package com.webtestautomationjava.manager;

import org.openqa.selenium.WebDriver;


public class Driver extends Thread {

    private static WebDriver selectedDriver = null;

    public static final String BROWSER = "browser";

    public static WebDriver get() {

        String browserToUse = "";

        if (System.getProperties().containsKey(BROWSER)) {
            browserToUse = System.getProperty(BROWSER);
        }
        if (selectedDriver == null) {
            switch (browserToUse) {
                case "firefox":
                    selectedDriver = DriverManager.createFirefoxDriver();
                case "htmlunit":
                    selectedDriver = DriverManager.createHtmlUnitDriver();
                case "chrome":
                    selectedDriver = DriverManager.createChromeDriver();
                case "iphone5s":
                    selectedDriver = DriverManager.createIphone5Driver();
                case "ipadair":
                    selectedDriver = DriverManager.createIPadAirDriver();
                case "nexus7":
                    selectedDriver = DriverManager.createAndroidNexus7Driver();
                default:
                    selectedDriver = DriverManager.createFirefoxDriver();
            }

        }

        return selectedDriver;
    }
}
