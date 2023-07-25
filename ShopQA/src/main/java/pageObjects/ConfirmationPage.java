package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ConfirmationPage {
    private WebDriver driver;
    private By prdList = By.cssSelector(".order_item");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getProductNames() {
        List<String> productNames = new ArrayList<>();
        List<WebElement> products = driver.findElements(prdList);
        for (WebElement product : products) {
            productNames.add(product.findElement(By.cssSelector(".product-name")).getText());
        }
        return productNames;
    }
}
