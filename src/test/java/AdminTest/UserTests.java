package AdminTest;

import Core.BaseTest;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.UserManagementPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserTests extends BaseTest {

    @BeforeMethod
    public void BMethod(){

    }

    @Test(groups = {"regression","admin","users", "HRM785747"}, priority=2  )
    public void validateUserCreation(){

        //loginto applicaiton
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.performUserLogin("Admin", "admin123");

        //navigate to user management
        dashboardPage.selectLeftMenu("Admin");

        //click add
        UserManagementPage userManagementPage = new UserManagementPage(driver);
        userManagementPage.clickAddButton();
        userManagementPage.selectLeftMenu("Admin");

        //submit form
        //verify popup and record in the list
    }

    @Test(testName = "Update User", priority = 1, dependsOnMethods = "validateUserCreation", enabled = false,invocationCount = 5)
    public void validateUserDataUpdate(){
        launchApplication();
    }

}
