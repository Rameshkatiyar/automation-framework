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

## Start automation for new product
* Design the test cases
    * Divide the test cases into modules and products.
    * Marked the common test cases for different platforms like APP, API or WEB.
* Create a new directory with product name. Example: **myProduct**
* Create subdirectories: action, common, config, pages, test
* Inside **common** directory, create a top automation class, **MyProductTestAutomation**
    * Extend the abstract TestAutomation class and implement setInitialConfig() method.
    * In this method resolve all ActionResolver.
* Inside **action** directory, create interface regarding module or page action.
    * Extend the interface **TestAction**.
    * Define the methods for common actions with different platforms.
* Inside **action** directory, implement the action interface for different platform.
    * Example: AppModule1TestAction
    * Extend the AppAutomationHelper.
    * Implement the methods.
* Inside **pages** directory, define the pages with elements path and url.
* Inside **test** directory,
    * Create a test class and extend the MyProductTestAutomation top class for all tests.
    * Add tests with **@Test** annotation of TestNG.
    * Add the **@Platform** annotation for mentioning the eligible platform of tests.


# Theory to know
## WebDriver Manager
WebDriverManager allows to automate the management of the binary drivers (e.g. chromedriver, geckodriver, etc.) required by Selenium WebDriver.

Link: https://github.com/bonigarcia/webdrivermanager

## POM - Page Object Model
- Page Object Model is a design pattern which has become popular in test automation for enhancing test maintenance and reducing code duplication. 
- A page object is an object-oriented class that serves as an interface to a page of your AUT.
- According to Page Object Model, we should keep our tests and element locators separately, this will keep code clean and easy to understand and maintain.