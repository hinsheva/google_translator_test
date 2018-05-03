package com.google.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By searchFieldLocator = By.name("q");
    private By searchInGoogleButtonLocator = By.xpath("//input[@type='button']");

    //Get search results for the query(text)
    public SearchResultsPage searchByText(String text) {
        clickElement(searchFieldLocator);
        inputData(searchFieldLocator, text);
        clickElement(searchInGoogleButtonLocator);
        return new SearchResultsPage(driver);
    }
}