package com.google.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

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
    void clickModalTableCellValue(By locatorTable, String value) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(locatorTable));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                if (cell.getText().contains(value))
                    cell.click();
            }
        }
    }

    void openLinkInNewTab(By locator) throws InterruptedException {
        WebElement link = getElement(locator);
        Actions newTab = new Actions(driver);
        newTab.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
        String base = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();
        tabs.remove(base);
        assert tabs.size() == 1;
        driver.close();
        driver.switchTo().window((String) tabs.toArray()[0]);
    }

    //alternative way to open link in a new tab
    void openAndSwitchToNewBrowser(By locator) throws InterruptedException {
        String parentGUID = driver.getWindowHandle();
        clickElement(locator);
        String parentUrl = driver.getCurrentUrl();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        Set<String> allGUID = driver.getWindowHandles();
        for (String guid : allGUID) {
            if (!guid.equals(parentGUID)) {
                driver.close();
                driver.switchTo().window(guid);
                driver.navigate().to(parentUrl);
                break;
            }
        }
    }
}

