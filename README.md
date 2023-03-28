# Selenium-SwagLabs Automation
> Example project developed to perform automated tests on the website [SwagLabs](https://www.saucedemo.com/)


## Installation
### Clone

- Clone this repository to your local machine using the command below:
```
	$ git clone https://github.com/bitsplz/Selenium-SwagLabs.git
```

### Execution

> Execute the command to run all tests in the project
```
	$ mvn clean test
```
OR
> Execute the [xml runner](src/test/java/SwagLabRunner.xml) to run all tests in the project

## Technologies:
- Selenium WebDriver
- Java
- Maven

## Patterns
- Page Object Model

## Reports
* To view allure report, execute the following command:
```
    $ allure serve allure-results
```
* To view testNg report of test, access the file: */test-output/emailable-report.html*
