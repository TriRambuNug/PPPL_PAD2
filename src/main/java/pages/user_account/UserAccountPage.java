package pages.user_account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserAccountPage {
    WebDriver driver;
    UserAccountObject userAccountObject;

    WebDriverWait wait;

    public UserAccountPage(WebDriver driver){
        this.driver = driver;
        userAccountObject = new UserAccountObject(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public boolean isTableVisible(){
        return driver.findElement(userAccountObject.userTable()).isDisplayed();
    }

    public void enterSearchKey(String key){
        driver.findElement(userAccountObject.serachUser()).sendKeys(key);
    }

    public boolean isSearchResultVisible(){
        return driver.findElement(userAccountObject.searchValue()).isDisplayed();
    }

    public void clickDropdownButton(){
        driver.findElement(userAccountObject.buttonDropdown()).click();
    }

    public void clickDetailButton(){
        driver.findElement(userAccountObject.buttonDetail()).click();
    }

    public boolean isPinVisible(){
        return driver.findElement(userAccountObject.pinInput()).isDisplayed();
    }
    public void clickSaveButton(){
        driver.findElement(userAccountObject.saveButton()).click();
    }
    public void clickBlockedOption(){
        driver.findElement(userAccountObject.buttonSelect()).click();
        driver.findElement(userAccountObject.blockedOption()).click();
    }
    public boolean isSuccessMessageVisible(){
        return driver.findElement(userAccountObject.successMessage()).isDisplayed();
    }
}
