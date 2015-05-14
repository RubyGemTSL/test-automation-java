package com.webtestautomationjava.utils;

import java.io.InputStream;
import java.util.Properties;

public class Message {
    private static final Properties locators;

    static {
        locators = new Properties();
        InputStream is = Message.class.getResourceAsStream("/environment.properties");
        try {
            locators.load(is);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getMessage(String locatorName) {
        return locators.getProperty(locatorName);
    }
}