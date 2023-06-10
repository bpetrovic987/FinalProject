package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage (WebDriver driver){
        super(driver);
    }

    By boltTShirtBy = By.id("item_1_title_link");
    By fleeceJacketBy = By.id("item_5_title_link");
    By checkoutButtonBy = By.id("checkout");

    public CartPage verifyBoltTShirtAddedToCart(String expectedText){
        String actualText = readText(boltTShirtBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

     public CartPage verifyFleeceJacketAddedToCart(String expectedText){
        String actualText = readText(fleeceJacketBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public CartPage clickOnCheckoutButton(){
        click(checkoutButtonBy);
        return this;
    }

    
}
