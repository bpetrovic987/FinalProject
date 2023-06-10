package Pages;

import java.time.Duration;

import javax.swing.text.html.parser.Element;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Text;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    
    public void waitVisibility (By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void writeText(By elementBy, String text){
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    //public void writeNumber(By elementBy, int number){
        //waitVisibility(elementBy);
        //driver.findElement(elementBy).clear();
        //driver.findElement(elementBy).sendKeys(number);
    //}

    public void click(By elementBy){
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public String readText(By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void assertTextEquals (String expectedText, String actualText){
        Assert.assertEquals(expectedText, actualText);
    }

    public void assertIntegerEquals (int expectedInt, int actualInt){
        Assert.assertEquals(actualInt, actualInt);
    }

    public void assertDoubleEquals (double expectedDouble, double actualDouble){
        Assert.assertEquals(expectedDouble, actualDouble, 0.0001);
    }

    public int countItems(By elementBy){
        waitVisibility(elementBy);
        return driver.findElements(elementBy).size();
    }
}
