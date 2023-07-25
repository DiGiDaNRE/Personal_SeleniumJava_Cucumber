package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private By cartButton = By.cssSelector(".cart-button");
    private By continueToCheckoutButton = By.cssSelector(".checkout-button.alt");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOn_Cart() {
    	
        driver.findElement(cartButton).click();
    }

    public void clickOn_ContinueToCheckout() {
        driver.findElement(continueToCheckoutButton).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}