package com.google.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

abstract class BasePage {
    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    void clickElement(By locator) {
        getElement(locator).click();
    }

    void inputData(By locator, String inputData) {
        getElement(locator).sendKeys(inputData);
    }

    String getElementText(By locator) {
        return getElement(locator).getText();
    }

    WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return webElement;
    }

    void clickModalElementByComponentXpath(String value) {
        //Component xpath allows to click any element via specifying the value within it
        clickElement(By.xpath("//*/text()[normalize-space(.)='" + value + "']/parent::*"));
    }

    //alternative way to click element by Value
    void clickModalTableCellValue(By locatorTable, String value){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(locatorTable));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for(WebElement row: rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                if (cell.getText().contains(value))
                    cell.click();
            }
        }
    }
}

