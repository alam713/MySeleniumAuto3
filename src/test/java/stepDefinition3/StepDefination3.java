package stepDefinition3;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import basePage3.BasePage3;
//import dev.failsafe.internal.util.Assert;
import factory3.PageFactory3;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ScreenShotUtility3;

public class StepDefination3 {
	public WebDriver driver;
	private PageFactory3 loginPage;  // Reference to the LoginPage
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		driver = BasePage3.getDriver("chrome");
	     driver.get("https://practicetestautomation.com/practice-test-login/");
	     loginPage = new PageFactory3(driver);   
	   
	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
		loginPage.enterUsername("student");
        loginPage.enterPassword("Password123");
	   
	}

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("user is navigated to the dashboard page")
    public void user_is_navigated_to_the_dashboard_page() {
        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = loginPage.getCurrentUrl();
        try {
        	Assert.assertEquals(actualUrl, expectedUrl, "User is not on the expected login page URL.");
        } catch (AssertionError e) {
        	ScreenShotUtility3.takeScreenshot(driver, "screenshots/failure-screenshot.png");
            throw e;  // Rethrow to allow Cucumber to handle the failure
        } finally {
            driver.quit();
        }
    }
}