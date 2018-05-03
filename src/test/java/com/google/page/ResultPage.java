package com.google.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage extends BasePage {

    ResultPage(WebDriver driver) {
        super(driver);
    }

    private By inputTextAreaLocator = By.id("source");
    private By resultTextAreaLocator = By.id("result_box");
    private By languagesDropDownLocator = By.id("gt-tl-gms");
    private By translateButtonLocator = By.id("gt-lang-submit");

    //Translate the text by input query
    public ResultPage translateText(String text, String language) {
        clickElement(languagesDropDownLocator);
        clickModalElementByComponentXpath(language);
        inputData(inputTextAreaLocator, text);
        clickElement(translateButtonLocator);
        return new ResultPage(driver);
    }

    public String getTranslatedText(){
        return getElementText(resultTextAreaLocator);
    }
}