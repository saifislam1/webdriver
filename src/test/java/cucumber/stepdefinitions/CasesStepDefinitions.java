package cucumber.stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CasesStepDefinitions {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up WebDriver with the appropriate path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");

        // Set up ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");

        // Initialize WebDriver with options
        driver = new ChromeDriver(options);
    }

    @Given("I am on the Salesforce login page")
    public void i_am_on_the_Salesforce_login_page() {
        // Navigate to Salesforce login page
        driver.get("https://www.test.salesforce.com");
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        // Navigate to the specified URL
        driver.get(url);
    }

    @Then("I wait for {int} seconds and refresh the page")
    public void i_wait_for_seconds_and_refresh_the_page(int seconds) {
        // Wait for the specified number of seconds using WebDriverWait
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(
                webDriver -> webDriver.findElement(By.cssSelector("yourElementSelectorHere")) != null
        );

        // Refresh the page
        driver.navigate().refresh();
    }

    @After
    public void tearDown() {
        // Code to close the driver and clean up resources
        if (driver != null) {
            driver.quit();
        }
    }
}
