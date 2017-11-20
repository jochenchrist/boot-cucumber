Feature: Tasks

 Background:
   Given I am logged an with username "bugs" and password "bunny"

  Scenario: Display all tasks
    Given I have three open tasks assigned
    When I open the root page
    Then all my tasks are listed

  Scenario: Add new task
    Given I open the root page
    When I add a new task with name "Write acceptance tests"
    Then the task is added to my tasks list

  Scenario: Validate input
    Given I open the root page
    When I add a new task with name ""
    Then the task is not added to the list
    And a warning is displayed

