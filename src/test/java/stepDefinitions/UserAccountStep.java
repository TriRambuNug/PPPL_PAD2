package stepDefinitions;

import com.aventstack.extentreports.Status;
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
import pages.user_account.UserAccountPage;

public class UserAccountStep {
    WebDriver driver;
    LoginObject loginObjectPage;
    UserAccountPage userAccountPage;
    LoginPage loginpage;

    @Before
    public void setup() {
        driver = Hooks.getDriver();
        userAccountPage = new UserAccountPage(driver);
        loginObjectPage = new LoginObject(driver);
    }

    @Given("I am on the user accounts page")
    public void i_am_on_the_user_account_page() {
        driver.get("http://127.0.0.1:8001/login");
        WebElement inputPhone = driver.findElement(loginObjectPage.getInputPhone());
        WebElement inputPassword = driver.findElement(loginObjectPage.getInputPassword());
        inputPhone.sendKeys("088888883838");
        inputPassword.sendKeys("123123");
        WebElement buttonLogin = driver.findElement(loginObjectPage.getButtonLogin());
        buttonLogin.click();
        Hooks.userAccountTest.log(Status.INFO, "Open user account page");
    }

    @Then("I should see the user accounts table")
    public void i_should_see_the_user_accounts_table() {
        Assert.assertTrue(userAccountPage.isTableVisible());
        Hooks.userAccountTest.log(Status.PASS, "User Account Table is visible");
    }

    @When("I enter {string} into the search field")
    public void i_enter_into_the_search_field(String key) {
        userAccountPage.enterSearchKey(key);
        Hooks.userAccountTest.log(Status.INFO, "Search key entered");
    }

    @Then("I should see the account details for {string}")
    public void i_should_see_the_account_details_for(String key) {
        Assert.assertTrue(userAccountPage.isSearchResultVisible());
        Hooks.userAccountTest.log(Status.PASS, "Search result is visible");
    }

    @When("I click on the account details for {string}")
    public void iClickOnTheAccountDetailsFor(String arg0) {
        userAccountPage.clickDropdownButton();
        userAccountPage.clickDetailButton();
        Hooks.userAccountTest.log(Status.INFO, "Click on the account details");
    }

    @Then("I should see the account pin {string} from different page")
    public void iShouldSeeTheAccountPinFromDifferentPage(String pin) {
        Assert.assertTrue(userAccountPage.isPinVisible());
        Hooks.userAccountTest.log(Status.PASS, "Pin is visible");
    }

    @And("I click on the blocked status button")
    public void iClickOnTheBlockedStatusButton() {
        userAccountPage.clickBlockedOption();
        Hooks.userAccountTest.log(Status.INFO, "Click on the blocked status button");
    }

    @Then("I save the changes")
    public void iSaveTheChanges() {
        userAccountPage.clickSaveButton();
        Hooks.userAccountTest.log(Status.INFO, "Save the changes");
    }

    @And("I should see the account status {string} for {string}")
    public void iShouldSeeTheAccountStatusFor(String arg0, String arg1) {
        Assert.assertTrue(userAccountPage.isSuccessMessageVisible());
        Hooks.userAccountTest.log(Status.PASS, "Status is visible");
    }

}
