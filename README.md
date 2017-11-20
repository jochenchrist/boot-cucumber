# Spring Boot with Cucumber and HtmlUnit

This is a demo project to setup spring boot for acceptance testing
with [Cucumber](https://cucumber.io) and the GUI-Less browser [HtmlUnit](http://htmlunit.sourceforge.net/) as WebDriver.

The demo application runs web (Spring MVC and Thymeleaf), Service (Spring) and a Database (Spring Data with Embedded MongoDB).

## Spring Boot Test Support
In the class `SpringSupport`, the Spring Context is loaded.

Note: The annotation `@ContextConfiguration` is required for cucumber to register spring.

## Features
Create feature files in `src/test/resources`.

## Step Definitions
Implement the step definitions in `src/test/java`.
Any StepDefinition class must extend the `SpringSupport` class.

## Run
```
./gradlew test
```
or use IntelliJ IDEA with Cucumber Plugin.



