package io.gehalt;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Run Cucumber with JUnit 4.
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = "pretty", features = "src/test/resources")
public class AcceptanceTests {
}
