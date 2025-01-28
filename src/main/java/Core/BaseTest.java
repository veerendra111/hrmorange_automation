package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver = null;

    @BeforeMethod
    public void beforeTestMethos(){
        launchApplication();
    }

    @AfterMethod
    public void afterTestMethos(){
        if(driver == null){
            driver.quit();
        }
    }

    public void launchApplication(){
        //launch application
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
}
