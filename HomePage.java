package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    public HomePage (WebDriver driver) {
        super(driver);
    }

    By expectedTextProductsBy = By.className("title");
    By numberOfItemsBy = By.className("inventory_item_name");
    By hamburgerMenuBy = By.id("react-burger-menu-btn");
    By logoutButtonBy = By.id("logout_sidebar_link");
    By addToCartBoltTShirtBy = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By addToCartFleeceJacketBy = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By shoppingCartBy = By.id("shopping_cart_container");

    public HomePage verifySuccessfulLogin(String expectedText){
        String actualText = readText(expectedTextProductsBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public HomePage numbersOfItems(int expectedNumberOfItems){
        int actualNumberOfItems = countItems(numberOfItemsBy);
        assertIntegerEquals(expectedNumberOfItems, actualNumberOfItems);
        return this;
    }

    public HomePage clickOnHamburgerMenu(){
        click(hamburgerMenuBy);
        return this;
    }

    public HomePage clickOnLogoutButton(){
        click(logoutButtonBy);
        return this;
    }

    public HomePage clickOnAddToCartItems(){
        click(addToCartBoltTShirtBy);
        click(addToCartFleeceJacketBy);
        return this;
    }

    public HomePage clickOnShoppingCart(){
        click(shoppingCartBy);
        return this;
    }

}
