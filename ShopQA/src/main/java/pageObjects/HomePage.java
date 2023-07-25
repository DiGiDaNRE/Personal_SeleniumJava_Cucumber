package pageObjects;

import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void perform_Search(String search) {
        driver.navigate().to("https://shop.demoqa.com/?s=" + search + "&post_type=product");
    }

    public void navigateTo_HomePage() {
        driver.get("https://shop.demoqa.com/");
    }
}