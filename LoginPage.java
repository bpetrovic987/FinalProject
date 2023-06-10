package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage (WebDriver driver) {
        super(driver);
    }

    String baseUrl = "https://www.saucedemo.com/";
    By usernameBy = By.id("user-name");
    By passwordBy = By.id("password");
    By loginButtonBy = By.id("login-button");
    By errorMessageBy = By.xpath("//*[@id=\'login_button_container\']/div/form/div[3]");



    public LoginPage goToBaseUrl(){
        driver.get(baseUrl);
        return this;
    }

    public LoginPage login (String username, String password){
        writeText(usernameBy, username);
        writeText(passwordBy, password);
        click(loginButtonBy);
        return this;
    }

    public LoginPage verifyUnsuccessfulLogin (String expectedText){
        String actualText = readText(errorMessageBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public LoginPage verifySuccessfulLogout (){
        waitVisibility(usernameBy);
        waitVisibility(passwordBy);
        waitVisibility(loginButtonBy);
        return this;
    }

    
}
