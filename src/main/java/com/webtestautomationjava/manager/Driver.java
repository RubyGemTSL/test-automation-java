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
                    System.out.println("Running on firefox");
                    return selectedDriver;
                case "htmlunit":
                    selectedDriver = DriverManager.createHtmlUnitDriver();
                    System.out.println("Running on htmlunit");
                    return selectedDriver;
                case "chrome":
                    selectedDriver = DriverManager.createChromeDriver();
                    System.out.println("Running on chrome");
                    return selectedDriver;
                case "iphone5s":
                    selectedDriver = DriverManager.createIphone5Driver();
                    System.out.println("Running on iphone5s");
                    return selectedDriver;
                case "ipadair":
                    selectedDriver = DriverManager.createIPadAirDriver();
                    System.out.println("Running on ipadair");
                    return selectedDriver;
                case "nexus7":
                    selectedDriver = DriverManager.createAndroidNexus7Driver();
                    System.out.println("Running on nexus7");
                    return selectedDriver;
                default:
                    selectedDriver = DriverManager.createFirefoxDriver();
                    System.out.println("Running on default");
                    return selectedDriver;
            }

        }
        return selectedDriver;
    }
}
