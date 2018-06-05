package com.google.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

public class FirefoxDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        //SetUp WebDriver Properties
        String driverName = PropertiesHolder.WEBDRIVER_PROPERTIES.getProperty("firefoxDriver.name");
        String driverPath = PropertiesHolder.WEBDRIVER_PROPERTIES.getProperty("firefoxDriver.path");
        String websiteUrl = PropertiesHolder.WEBAPPDATA_PROPERTIES.getProperty("web.url");

        //SetUP Driver and English language to avoid internationalization conflicts
        System.setProperty(driverName, driverPath);
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("intl.accept_languages","en-us, en, fr, fr-fr");
        FirefoxOptions option = new FirefoxOptions();
        option.setProfile(profile);
        driver = new FirefoxDriver(option);
        //Open WebApp
        driver.navigate().to(websiteUrl);
        // Maximize Browser Window
        WebDriver.Options manage = driver.manage();
        manage.window().maximize();
        manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
