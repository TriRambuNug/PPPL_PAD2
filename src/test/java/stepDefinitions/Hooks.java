package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Hooks {
    private static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest loginTest;
    public static ExtentTest userAccountTest;
    public static ExtentTest patnerAccountTest;

    @BeforeAll
    public static void setUp() {
        extent = ExtentReportManager.getInstance();
        if (driver == null) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }

        userAccountTest = extent.createTest("User Account Test");
        patnerAccountTest = extent.createTest("Patner Account Test");
        loginTest = extent.createTest("Login test");

        patnerAccountTest.log(Status.INFO, "Start Create PatnerAccount Test");
        userAccountTest.log(Status.INFO, "Start Delete UserAccount Test");
        loginTest.log(Status.INFO, "Start Login Admin Test");

    }
    public static WebDriver getDriver() {
        if (driver == null) new Hooks().setUp();
        return driver;
    }
    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

        userAccountTest.log(Status.INFO, "Close Create UserAccount");
        patnerAccountTest.log(Status.INFO, "Close Delete PatnerAccount");
        loginTest.log(Status.INFO, "Close Login Admin");

        extent.flush();
    }

}
