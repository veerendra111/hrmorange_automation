package Pages;

import Core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserManagementPage extends BasePage {

    //objects & variable declaration
    WebDriver driver = null;

    //constructors
    public UserManagementPage(WebDriver driver){
        super(driver);
    }

    //locators
    By btnAdd = By.xpath("//button[text()=' Add ']");

    //methods
    public void clickAddButton(){
        clickElement(btnAdd);
    }
}
