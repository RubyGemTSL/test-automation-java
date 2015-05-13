package com.webtestautomationjava.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {

    @FindBy(how = How.ID, using = "user_login")
    public WebElement userNameField;

    @FindBy(how = How.ID, using = "user_pass")
    public WebElement passwordField;

    @FindBy(how = How.ID, using = "rememberme")
    public WebElement rememberMeRadio;

    @FindBy(how = How.ID, using = "wp-submit")
    public WebElement loginButton;

    public LoginPage(WebDriver webDriver) {
        driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get(baseUrl + "/login");
    }

    @Override
    protected void isLoaded() throws Error {
        if (!driver.getTitle().contentEquals("WordPress.com › Log In")) {
            throw new Error("Title was not 'WordPress.com › Log In' it was " + driver.getTitle());
        }
    }

    public void login(String userName, String password) {
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void clickLogin() {
        loginButton.click();
    }


}
