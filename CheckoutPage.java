package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    public CheckoutPage (WebDriver driver) {
        super(driver);
    }

    By firstNameBy = By.id("first-name");
    By lastNameBy = By.id("last-name");
    By postalCodeBy = By.id("postal-code");
    By continueButtonBy = By.id("continue");
    By finishButtonBy = By.id("finish");
    By actualTextCheckoutOverviewBy = By.xpath("//*[@id=\'header_container\']/div[2]/span");
    By totalPriceOfItemsBy = By.className("summary_subtotal_label");
    By priceOfTax = By.className("summary_tax_label");
    By messageCompleteOrderBy = By.className("complete-header");

    public CheckoutPage enterInformations(String firstName, String lastName, String postalCode) {
        writeText(firstNameBy, firstName);
        writeText(lastNameBy, lastName);
        writeText(postalCodeBy, postalCode);
        return this;
    }

    public CheckoutPage clickOnContinueButton(){
        click(continueButtonBy);
        return this;
    }

     public CheckoutPage verifyCheckoutOverviewIsDisplayed(String expectedText){
        String actualText = readText(actualTextCheckoutOverviewBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }


    public CheckoutPage verifyPriceIsCorrect(double expectedTotalPrice){
        double p3 = Double.parseDouble(readText(totalPriceOfItemsBy).substring(13));
        double p4 = Double.parseDouble(readText(priceOfTax).substring(6));
        double actualtotalPrice = p3 + p4;
        assertDoubleEquals(expectedTotalPrice, actualtotalPrice);
        return this;
    }

    public CheckoutPage clickOnFinishButton(){
        click(finishButtonBy);
        return this;
    }

    public CheckoutPage verifyCompleteOrder(String expectedText){
        String actualText = readText(messageCompleteOrderBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }
    
}
