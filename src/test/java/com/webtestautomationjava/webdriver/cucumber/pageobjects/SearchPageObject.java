package com.webtestautomationjava.webdriver.cucumber.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPageObject {
    private static WebDriver webDriver;

    public SearchPageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private By searchTermField = By.id("lst-ib");
    private By submitSearch = By.name("btnG");
    private By searchResults = By.id("search");

    public void enterSearchTerm(String searchTerm) {
        webDriver.findElement(searchTermField).clear();
        webDriver.findElement(searchTermField).sendKeys(searchTerm);
    }

    public void submitSearch() {
        webDriver.findElement(submitSearch).click();
    }

    public void acceptSearchResult(int id) {
        List<WebElement> searchResultList = webDriver.findElement(searchResults).findElements(By.tagName("li"));

        searchResultList.get(id).findElements(By.tagName("a")).get(0).click();
    }
}
