package Pages;

import Core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    //locators
    private By txtUsername = By.name("username");
    private By txtPassword = By.name("password");
    private By btnLogin = By.tagName("button");

    public LoginPage(WebDriver driver){
        super(driver);
    }



    public DashboardPage performUserLogin(String username, String password){
        setText(txtUsername, username);
        setText(txtPassword, password);
        clickElement(btnLogin);
        return  new DashboardPage(driver);
    }
}
