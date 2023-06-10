package Tests;

import org.junit.Test;
import org.openqa.selenium.devtools.v110.log.Log;

import Pages.HomePage;
import Pages.LoginPage;

public class LoginTests extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    
    String standardUserName = "standard_user";
    String standardPassword = "secret_sauce";
    String expectedTextProducts = "Products";
    String emptyUsername = "";
    String errorMessageUsernameRequired = "Epic sadface: Username is required";
    String wrongUsername = "nonstandard_user";
    String wrongPassword = "sauce";
    String errorMessageInvalidCredentials = "Epic sadface: Username and password do not match any user in this service";


    @Test
    public void verifySuccessfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(standardUserName, standardPassword);
        homePage.verifySuccessfulLogin(expectedTextProducts);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
    }

    @Test
    public void verifyUnsuccessfulLoginEmptyUsername(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(emptyUsername, standardPassword);
        loginPage.verifyUnsuccessfulLogin(errorMessageUsernameRequired);
    
     try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
    }

    @Test
    public void verifyUnsuccessfulLoginWrongUsername(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(wrongUsername, standardPassword);
        loginPage.verifyUnsuccessfulLogin(errorMessageInvalidCredentials);

    try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
    }

    @Test
    public void verifyUnsuccessfulLoginWrongPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(standardUserName, wrongPassword);
        loginPage.verifyUnsuccessfulLogin(errorMessageInvalidCredentials);
    
    try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
    }

    @Test
    public void verifylogout(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(standardUserName, standardPassword);
        homePage.verifySuccessfulLogin(expectedTextProducts);
        homePage.clickOnHamburgerMenu();
        homePage.clickOnLogoutButton();
        loginPage.verifySuccessfulLogout();

    try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }

    }
    
}
