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
                    return selectedDriver;
                case "htmlunit":
                    selectedDriver = DriverManager.createHtmlUnitDriver();
                    return selectedDriver;
                case "chrome":
                    selectedDriver = DriverManager.createChromeDriver();
                    return selectedDriver;
                case "iphone5s":
                    selectedDriver = DriverManager.createIphone5Driver();
                    return selectedDriver;
                case "ipadair":
                    selectedDriver = DriverManager.createIPadAirDriver();
                    return selectedDriver;
                case "nexus7":
                    selectedDriver = DriverManager.createAndroidNexus7Driver();
                    return selectedDriver;
                default:
                    selectedDriver = DriverManager.createFirefoxDriver();
                    return selectedDriver;
            }

        }
        System.out.println("Test to be executed using " + browserToUse.toUpperCase());
        return selectedDriver;
    }
}
