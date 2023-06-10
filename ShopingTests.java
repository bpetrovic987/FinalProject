package Tests;

import org.junit.Test;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;

public class ShopingTests extends BaseTest {
    public LoginPage loginPage;
    public HomePage homePage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;

    String standardUserName = "standard_user";
    String standardPassword = "secret_sauce";
    int expectedNumberOfItems = 6;
    String expectedTextProducts = "Products";
    String expectedTextFleeceJacket = "Sauce Labs Fleece Jacket";
    String expectedTextBoltTShirt = "Sauce Labs Bolt T-Shirt";
    String firstName = "Biljana";
    String lastName = "Krstic";
    String postalCode = "11300";
    String checkoutOverview = "Checkout: Overview";
    double expectedTotalPrice = 71.26;
    String messageCompleteOrder = "Thank you for your order!";
    

    @Test
    public void verifyNumberOfItems(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.goToBaseUrl();
    loginPage.login(standardUserName, standardPassword);
    homePage.numbersOfItems(expectedNumberOfItems);

    try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }

    }

    @Test
    public void verifySuccessfulOrder(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        loginPage.goToBaseUrl();
        loginPage.login(standardUserName, standardPassword);
        homePage.verifySuccessfulLogin(expectedTextProducts);
        homePage.clickOnAddToCartItems();
        homePage.clickOnShoppingCart();
        cartPage.verifyBoltTShirtAddedToCart(expectedTextBoltTShirt);
        cartPage.verifyFleeceJacketAddedToCart(expectedTextFleeceJacket);
        cartPage.clickOnCheckoutButton();
        checkoutPage.enterInformations(firstName, lastName, postalCode);
        checkoutPage.clickOnContinueButton();
        checkoutPage.verifyCheckoutOverviewIsDisplayed(checkoutOverview);
        checkoutPage.verifyPriceIsCorrect(expectedTotalPrice);
        checkoutPage.clickOnFinishButton();
        checkoutPage.verifyCompleteOrder(messageCompleteOrder);

     try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
    }
    
}
