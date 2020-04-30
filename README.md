# automation-framework
## Web + App + API + Backend

## TechStack:
**Main:**
- Java
- TestNg
- Maven
- Selenium
- Appium
- Rest Assured
- SpringBoot

**Support Library:**
- Lombok
- Guava
- Hamcrest
- WebDriverManager
- Univocity Parsers

## Types of framework:
- The Hybrid Test Automation Framework
- The Test Library Architecture Framework
- The Data-Driven Testing Framework
- Test Modularity Framework
- Business Process Testing (BPT)

Link: https://www.guru99.com/test-automation-framework.html

## Design Patterns:
- Page Object Model
- Resolver pattern
 

## Directory Structure
* properties
    * config.properties
    * testUrl.properties
* testdata
    * generic_testdata.csv
* src/main
    * annotation
        * PlatformAnnotation
    * enums
        * Platform
        * Environment
    * services
        * AbstractCsvReader
        * TestDataService
    * utils
        * JsonUtil
        * ImageDiffUtil
    * config
        * TestUrlConfig
        * TestPropertiesConfig
    * dataLoader 
        * GenerictCsvLoader
        * GenericCsvModel

* src/test
    * commonHelper
        * apiHelper
            * RestAssuredService
            * ApiAutomationHelper
        * appHelper
            * AppiumService
            * AppAutomationHelper
            * BaseAppPage
            * appUtils (dir)
                * AppWaitService
                * AppScreenshotService
        * webHelper
            * SeleniumService
            * WebAutomationHelper
            * BaseWebPage
            * webUtils (dir)
                * WebWaitService
                * WebScreenshotService
        * commonAPI
            * TesAutomation (A)
            * TestAction (I)
            * TestActionResolver
            
    * Product1
        * common
            * Product1TestAutomation
        * action
            * LoginAction (I)
            * ApiLoginAction
            * AppLoginAction
            * WebLoginAction
        * pages
            * LoginPage
            * RegistrationPage
            * LoginApiUrl
        * test
            * LoginTest
            * RegistrationTest
        * config
            login.xml
            registration.xml
            regression.xml
    * Product2
        * common
        * action
        * config
        * pages
        * test


## External Properties
- environment=LOCAL
- platform=API


# Theory to know
## WebDriver Manager
WebDriverManager allows to automate the management of the binary drivers (e.g. chromedriver, geckodriver, etc.) required by Selenium WebDriver.

Link: https://github.com/bonigarcia/webdrivermanager

## POM - Page Object Model
- Page Object Model is a design pattern which has become popular in test automation for enhancing test maintenance and reducing code duplication. 
- A page object is an object-oriented class that serves as an interface to a page of your AUT.
- According to Page Object Model, we should keep our tests and element locators separately, this will keep code clean and easy to understand and maintain.