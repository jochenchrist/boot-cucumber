package de.jochenchrist.acceptance;

import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginStepDefinitions extends SpringSupport {

    @Autowired
    WebDriver webDriver;

    @Given("^I am logged an with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iAmLoggedAnWithUsernameAndPassword(String username, String password) throws Throwable {
        webDriver.get("/");
        if (!webDriver.getTitle().startsWith("Login")) {
            return;
        }
        webDriver.findElement(By.name("username")).sendKeys(username);
        webDriver.findElement(By.name("password")).sendKeys(password);
        webDriver.findElement(By.name("submit")).submit();
        webDriver.get("/");
        assertThat(webDriver.getTitle()).doesNotStartWith("Login");
    }
}
