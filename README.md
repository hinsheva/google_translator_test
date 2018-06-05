##### DESCRIPTION #####

This set of modules is a TestNG 6.14.3 based framework for Web testing of **translate.google.com** in Chrome and Firefox browsers using Selenium v. '3.11.0'

##### INSTALLATION #####
(See the full guide of how to Download and Install Selenium WebDriver: https://www.guru99.com/installing-selenium-webdriver.html)

###### To be able to run tests you need to: ######
* install java:
http://www.oracle.com/technetwork/java/javase/downloads/index.html
* install web driver:
https://raw.githubusercontent.com/sinshev/base-test/master/jira.utils/chromedriver
* install ChromeBrowser
https://www.google.com/chrome/
* install FirefoxBrowser
https://support.mozilla.org/en-US/kb/how-download-and-install-firefox-windows
* setUp in pom.xml file of the main root of the project, maven plugin and dependencies:
https://mvnrepository.com/repos/central
* setUp maven project in the ide
http://maven.apache.org/users/index.html

###### dependencies source ######
{

    mavenCentral()
}
    
###### dependencies list ######
{

    <dependencies>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.14.3</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-server</artifactId>
            <version>3.11.0</version>
        </dependency>
    </dependencies>

}

##### RUNNING #####

To run the test on windows nothing specific required, except the mentioned above steps.
If needed, please specify/switch to the desired browser(Chrome/Firefox) within TestInitializer java file that is located in config folder

###### 'config.properties' file: ######
* update 'driver.name' property with your previously installed actual driver name
* update 'driver.path' property with the actual path to your web driver on your PC

**Note:** option to specify/change test data(ex. text to be translated, expected translated text, language) 
is enabled within testData.properties file that is located in resources package

##### OVERVIEW #####

######Project structure: ######

├──**java** package

├──├──**com** package

├──├──├──**google** package

├──├──├──├──**config** package

├──├──├──├──├──**ChromeDriverManager** class

├──├──├──├──├──**DriverManager** abstract class

├──├──├──├──├──**DriverManagerFactory** class

├──├──├──├──├──**DriveType** enum

├──├──├──├──├──**FirefoxDriverManager** class

├──├──├──├──├──**PropertiesHolder** class

├──├──├──├──├──**TestInitializer** class

├──├──├──├──**page** package

├──├──├──├──**test** package

├──**resources** package

├──├──**config.properties** file

├──├──**testData.properties** file

└──├──**webApp.properties** file

* **google package** - Includes packages and classes required for google translator testing
* **config in google package** - Includes classes for webDrivers set-up through Driver Manager Factory realization, 
and provides ability to read the properties from separate files and store logs
* **page in google package** - Includes PageObject of google and it's translator
* **test in google package** - Includes test class for google translator functionality testing - correctness of translation
* **resources package** - Includes three files with separately stored: webDriver, testData and webApp properties(data)
* **config.properties file in resources package** - Includes webDriver info that is need to access to driver and browser
* **testData.properties file in resources package** - Includes all required test data to run the tests 
* **webApp.properties file in resources package** - Includes webApp info (now it's contain only url)

**Note:** all data stored separately to have an option to re-use it, quickly update/change in the only one place and 
extend if required




