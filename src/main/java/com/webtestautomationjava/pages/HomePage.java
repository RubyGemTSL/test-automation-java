package com.webtestautomationjava.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {

    @FindBy(how = How.ID, using = "wpbody-content")
    public WebElement wpbodyContent;

    public HomePage(WebDriver webDriver) {
        driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void isLoaded() throws Error {
        if (!driver.getTitle().contentEquals("Dashboard ‹ " + getProperty.Config().getProperty("homePage.name") + " — WordPress")) {
            throw new Error("Title was not 'Dashboard ‹ " + getProperty.Config().getProperty("homePage.name") + " — WordPress' it was " + driver.getTitle());
        }
    }

}
