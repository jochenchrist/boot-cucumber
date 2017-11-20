package de.jochenchrist.acceptance;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.jochenchrist.acceptance.domain.Task;
import de.jochenchrist.acceptance.domain.TaskRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class TaskStepDefinitions extends SpringSupport {

    @Autowired
    WebDriver webdriver;

    @Autowired
    TaskRepository repository;

    private String enteredTaskName;

    @Given("^I have three open tasks assigned$")
    public void iHaveThreeOpenTasksAssigned() throws Throwable {
        repository.save(asList(new Task("Task1", "bugs"), new Task("Task 2", "bugs"), new Task("Task 3", "bugs")));
    }

    @When("^I open the root page$")
    public void iOpenTheRootPage() throws Throwable {
        webdriver.get("/");
    }

    @Then("^all my tasks are listed$")
    public void allMyTasksAreListed() throws Throwable {
        System.out.println(webdriver.getPageSource());
        assertThat(webdriver.findElements(By.className("task"))).hasSize(3);
    }

    @Then("^the task is added to my tasks list$")
    public void theTaskIsAddedToMyTasksList() throws Throwable {
        webdriver.get("/");
        assertThat(webdriver.findElements(By.className("task")).stream().filter(element -> element.getText().contains(enteredTaskName)).count())
                .isEqualTo(1);
    }

    @When("^I add a new task with name \"([^\"]*)\"$")
    public void iAddANewTaskWithName(String name) throws Throwable {
        enteredTaskName = name;
        webdriver.findElement(By.id("new-task")).sendKeys(enteredTaskName);
        webdriver.findElement(By.cssSelector("input[type=submit]")).click();
    }

    @Then("^the task is not added to the list$")
    public void theTaskIsNotAddedToTheList() throws Throwable {
        assertThat(repository.findAll().stream().filter(task -> task.getName().isEmpty()).count())
                .isZero();
    }

    @And("^a warning is displayed$")
    public void aWarningIsDisplayed() throws Throwable {
        webdriver.findElement(By.className("alert"));
    }
}
