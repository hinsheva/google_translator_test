package com.google.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    private By selectionLocator = By.xpath("//a[contains(@href, 'https://translate.google.com/')]");

    //Click on required element to navigate to the corresponding Page
    public ResultPage selectSearchResultElement() {
        clickElement(selectionLocator);
        driver.manage().deleteAllCookies();
        return new ResultPage(driver);
    }
}
