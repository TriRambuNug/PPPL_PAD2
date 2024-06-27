package pages.user_account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserAccountObject {
    WebDriver driver;

    public UserAccountObject(WebDriver driver){
        this.driver = driver;
    }

    public By userTable(){
        return By.id("user-table");
    }

    public By serachUser(){
        return By.cssSelector("input[type='search']");
    }
    public By searchValue(){
        return By.tagName("strong");
    }

    public By buttonDropdown(){
        return By.className("dropdown-toggle");
    }
    public By buttonDetail(){
        return By.className("dropdown-item");
    }
    public By pinInput(){
        return By.id("pin");
    }
    public By saveButton(){
        return By.className("btn-primary");
    }
    public By successMessage(){
        return By.className("alert");
    }
    public By blockedOption(){
        return By.xpath("//*[@id='status']/option[1]");
    }
    public By buttonSelect(){
        return By.id("status");
    }
}
