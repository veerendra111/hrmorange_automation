package Core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected  WebDriver driver = null;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    //locator
    private String leftMenu = "//span[text()='%s']/parent::a";

    public void selectLeftMenu(String title){
        String locator = String.format(leftMenu, title);
        By loc = By.xpath(locator);
        clickElement(loc);
    }

    //highlight elements
    public void highLighterMethod(By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;');", element);
    }

    protected void highLighterMethod(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;');", element);
    }

    protected WebElement getElement(By locator){
        highLighterMethod(locator);
        return driver.findElement(locator);
    }

    protected void clickElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        highLighterMethod(locator);
        driver.findElement(locator).click();
    }

    protected  void setText(By locator, String content){
        highLighterMethod(locator);
        driver.findElement(locator).sendKeys(content);
    }
}
