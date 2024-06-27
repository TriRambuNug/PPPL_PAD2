package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginObject {
    WebDriver driver;

    public LoginObject(WebDriver driver){
        this.driver = driver;
    }

    public By getInputPhone(){
        return By.name("phone");
    }

    public By getInputPassword(){
        return By.name("password");
    }

    public By getButtonLogin(){
        return By.xpath("//button[contains(text(), 'Masuk')]");
    }

    public By getErrorMessage(){
        return By.className("text-danger");
    }

}
