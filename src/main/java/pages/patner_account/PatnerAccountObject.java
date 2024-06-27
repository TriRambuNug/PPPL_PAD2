package pages.patner_account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatnerAccountObject{
    WebDriver driver;

    public PatnerAccountObject(WebDriver driver){
        this.driver = driver;
    }

    public By patnerTable(){
        return By.id("patner-table");
    }

    public By serachpatner(){
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
    public By alamatInput(){
        return By.id("address");
    }
    public By saveButton(){
        return By.id("button-partner");
    }

    public By buttonSimpan(){
        return By.id("button-partner");
    }
    public By successMessage(){
        return By.className("alert");
    }
    public By blockedOption(){
        return By.xpath("//*[@id='status-partner']/option[1]");
    }
    public By buttonSelect(){
        return By.id("status-partner");
    }

    public By buttonPatner() {
        return By.id("patner-account");
    }
}
