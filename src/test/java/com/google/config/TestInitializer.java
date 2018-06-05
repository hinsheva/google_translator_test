package com.google.config;

import com.google.page.MainPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestInitializer {

    //This Class setUp web driver(Chrome/Firefox), navigate to webApp(google.com) and initialize the initial webApp page(Main)
    private static DriverManager driverManager;
    private MainPage mainPage;

    protected MainPage getMainPage() {
        return mainPage;
    }

    @BeforeClass
    public static void setUpDriverManager() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @BeforeMethod
    public void setUpHomePage() {
        mainPage = new MainPage(driverManager.getDriver());
    }

    @AfterClass
    public static void tearDown() {
       driverManager.getDriver().close();
    }
}