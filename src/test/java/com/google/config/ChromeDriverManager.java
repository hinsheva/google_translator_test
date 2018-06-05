package com.google.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ChromeDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        //SetUp WebDriver Properties
        String driverName = PropertiesHolder.WEBDRIVER_PROPERTIES.getProperty("chromeDriver.name");
        String driverPath = PropertiesHolder.WEBDRIVER_PROPERTIES.getProperty("chromeDriver.path");
        String websiteUrl = PropertiesHolder.WEBAPPDATA_PROPERTIES.getProperty("web.url");

        //SetUP Driver and English language to avoid internationalization conflicts
        System.setProperty(driverName, driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-ca");
        driver = new ChromeDriver(options);
        //Open WebApp
        driver.navigate().to(websiteUrl);
        // Maximize Browser Window
        WebDriver.Options manage = driver.manage();
        manage.window().maximize();
        manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
