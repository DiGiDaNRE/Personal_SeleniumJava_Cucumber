package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Interact;


public class ProductListingPage extends Interact {
    private WebDriver driver;
    private By addToCartButton = By.cssSelector("button.single_add_to_cart_button");
    private By productList = By.cssSelector(".noo-product-inner");
    private By colorOption = By.xpath("//*[@id='pa_color']/option[2]");
    private By sizeOption = By.xpath("//*[@id='pa_size']/option[2]");

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOn_AddToCart() {
    	waitElement(colorOption);
        driver.findElement(colorOption).click();
        waitElement(sizeOption);
        driver.findElement(sizeOption).click();
        waitElement(addToCartButton);
        driver.findElement(addToCartButton).click();
    }

    public void select_Product(int productNumber) {
    	waitElement(productList);
        driver.findElements(productList).get(productNumber).click();
    }

    public String getProductName(int productNumber) {
        return driver.findElements(productList).get(productNumber).findElement(By.cssSelector("h3")).getText();
    }
}