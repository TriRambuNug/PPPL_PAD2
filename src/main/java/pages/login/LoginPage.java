package pages.login;

import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    LoginObject loginObject;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        loginObject = new LoginObject(driver);
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public void putPhone(String phone){
        driver.findElement(loginObject.getInputPhone()).sendKeys(phone);
    }

    public void putPassword(String password){
        driver.findElement(loginObject.getInputPassword()).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginObject.getButtonLogin()).click();
    }

    public void getErrorMessage(){
        driver.findElement(loginObject.getErrorMessage()).getText();
    }
}
