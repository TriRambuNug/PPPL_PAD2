package pages.patner_account;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.user_account.UserAccountObject;

import java.time.Duration;

public class PatnerAccountPage {
    WebDriver driver;
    PatnerAccountObject patnerAccountObject;

    WebDriverWait wait;

    public PatnerAccountPage(WebDriver driver){
        this.driver = driver;
        patnerAccountObject = new PatnerAccountObject(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public boolean isTableVisible(){
        return driver.findElement(patnerAccountObject.patnerTable()).isDisplayed();
    }

    public void enterSearchKey(String key){
        driver.findElement(patnerAccountObject.serachpatner()).sendKeys(key);
    }

    public boolean isSearchResultVisible(){
        return driver.findElement(patnerAccountObject.searchValue()).isDisplayed();
    }

    public void clickDropdownButton(){
        driver.findElement(patnerAccountObject.buttonDropdown()).click();
    }

    public void clickDetailButton(){
        driver.findElement(patnerAccountObject.buttonDetail()).click();
    }

    public boolean isAddressVisible(){
        return driver.findElement(patnerAccountObject.alamatInput()).isDisplayed();
    }
    public void clickSaveButton() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(patnerAccountObject.saveButton()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickBlockedOption(){
        driver.findElement(patnerAccountObject.buttonSelect()).click();
        driver.findElement(patnerAccountObject.blockedOption()).click();
    }
    public boolean isSuccessMessageVisible(){
        return driver.findElement(patnerAccountObject.successMessage()).isDisplayed();
    }

    public void clickPatnerButton(){
        driver.findElement(patnerAccountObject.buttonPatner()).click();
    }
}
