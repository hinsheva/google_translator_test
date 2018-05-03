package com.google.config;

import com.google.page.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;


public class TestInitializer {

    //This Class setUp web driver(Chrome/Firefox), navigate to webApp(google.com) and initialize the initial webApp page(Main)
    private static DriverManager driverManager;
    private MainPage mainPage;

    protected MainPage getMainPage() {
        return mainPage;
    }

    @BeforeAll
    public static void setUpDriverManager() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @BeforeEach
    public void setUpHomePage() {
        mainPage = new MainPage(driverManager.getDriver());
    }

    @AfterAll
    public static void tearDown() {
       driverManager.getDriver().close();
    }
}