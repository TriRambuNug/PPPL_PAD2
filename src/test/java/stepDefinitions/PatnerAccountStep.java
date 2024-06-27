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
import pages.login.LoginPage;
import pages.patner_account.PatnerAccountPage;


public class PatnerAccountStep {
    WebDriver driver;
    LoginObject loginObjectPage;
    PatnerAccountPage patnerAccountPage;
    LoginPage loginpage;

    @Before
    public void setup() {
        driver = Hooks.getDriver();
        patnerAccountPage = new PatnerAccountPage(driver);
        loginObjectPage = new LoginObject(driver);
    }

    @Given("I am on the patner accounts page")
    public void i_am_on_the_user_account_page() {
        driver.get("http://127.0.0.1:8001/login");
        WebElement inputPhone = driver.findElement(loginObjectPage.getInputPhone());
        WebElement inputPassword = driver.findElement(loginObjectPage.getInputPassword());
        inputPhone.sendKeys("088888883838");
        inputPassword.sendKeys("123123");
        WebElement buttonLogin = driver.findElement(loginObjectPage.getButtonLogin());
        buttonLogin.click();
        patnerAccountPage.clickPatnerButton();
    }

    @Then("I should see the patner accounts table")
    public void i_should_see_the_user_accounts_table() {
        Assert.assertTrue(patnerAccountPage.isTableVisible());
    }

    @When("I enter {string} into the search field patner account")
    public void i_enter_into_the_search_field(String key) {
        patnerAccountPage.enterSearchKey(key);
    }

    @Then("I should see the account patner details for {string}")
    public void i_should_see_the_account_details_for(String key) {
        Assert.assertTrue(patnerAccountPage.isSearchResultVisible());
    }

    @When("I click on the account patner details for {string}")
    public void iClickOnTheAccountDetailsFor(String arg0) {
        patnerAccountPage.clickDropdownButton();
        patnerAccountPage.clickDetailButton();
    }

    @Then("I should see the account patner address {string} from different page")
    public void iShouldSeeTheAccountPinFromDifferentPage(String address) {
        Assert.assertTrue(patnerAccountPage.isAddressVisible());
    }

    @And("I click on the blocked status patner button")
    public void iClickOnTheBlockedStatusButton() {
        patnerAccountPage.clickBlockedOption();
    }

    @Then("I save the changes patner account")
    public void iSaveTheChanges() {
        patnerAccountPage.clickSaveButton();
    }

    @And("I should see the account patner status {string} for {string}")
    public void iShouldSeeTheAccountStatusFor(String arg0, String arg1) {
        Assert.assertTrue(patnerAccountPage.isSuccessMessageVisible());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
