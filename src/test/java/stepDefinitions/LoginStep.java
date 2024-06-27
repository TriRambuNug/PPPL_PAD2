package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import pages.login.LoginObject;

public class LoginStep {
    WebDriver driver;
    LoginObject loginObjectPage;

    @Before
    public void setup() {
        driver = Hooks.getDriver();
        loginObjectPage = new LoginObject(driver);
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("http://127.0.0.1:8001/login"); // Change URL to your login page
    }

    @When("I fill in the login form with valid credentials")
    public void i_fill_in_the_login_form_with_valid_credentials() {
        WebElement inputPhone = driver.findElement(loginObjectPage.getInputPhone());
        WebElement inputPassword = driver.findElement(loginObjectPage.getInputPassword());
        inputPhone.sendKeys("088888883838");
        inputPassword.sendKeys("123123");
    }

    @And("I submit the login form")
    public void i_submit_the_login_form() {
        WebElement buttonLogin = driver.findElement(loginObjectPage.getButtonLogin());
        buttonLogin.click();
    }

    @Then("I should be on the dashboard page")
    public void i_should_be_on_the_dashboard_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Current URL does not contain 'dashboard'", currentUrl.contains("dashboard")); // Assuming the URL contains 'dashboard'
    }


}
