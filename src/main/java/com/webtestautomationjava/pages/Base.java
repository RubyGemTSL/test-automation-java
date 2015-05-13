package com.webtestautomationjava.pages;

import com.webtestautomationjava.ReadPropertiesFile;
import com.webtestautomationjava.manager.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base extends LoadableComponent<Base> {

    WebDriver driver = Driver.get();
    WebDriverWait wait = new WebDriverWait(driver,10);
    public static ReadPropertiesFile getProperty = new ReadPropertiesFile();
    
    String baseUrl = getProperty.Config().getProperty("baseUrl");

    @Override
    protected void load() { }

    @Override
    protected void isLoaded() throws Error { }

}
