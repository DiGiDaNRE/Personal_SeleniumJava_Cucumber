package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Interact;

import java.util.List;

public class CheckOutPage extends Interact {
    private WebDriver driver;
    
    private By txtbx_FirstName = By.cssSelector("#billing_first_name");
    private By txtbx_LastName = By.cssSelector("#billing_last_name");
    private By txtbx_Email = By.cssSelector("#billing_email");
    private By txtbx_Phone = By.cssSelector("#billing_phone");
    private By drpdwn_CountryDropDownArrow = By.cssSelector("#billing_country_field");
    private By drpdwn_CountyDropDownArrow = By.cssSelector("#billing_state_field .select2-arrow");
    private By countryList = By.cssSelector("#select2-drop ul li");
    private By txtbx_City = By.cssSelector("#billing_city");
    private By txtbx_Address = By.cssSelector("#billing_address_1");
    private By txtbx_PostCode = By.cssSelector("#billing_postcode");
    private By chkbx_ShipToDifferetAddress = By.cssSelector("#ship-to-different-address-checkbox");
    private By paymentMethodList = By.cssSelector("ul.wc_payment_methods li");
    private By chkbx_AcceptTermsAndCondition = By.cssSelector("#terms.input-checkbox");
    private By btn_PlaceOrder = By.cssSelector("#place_order");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enter_Name(String name) {
        driver.findElement(txtbx_FirstName).sendKeys(name);
    }

    public void enter_LastName(String lastName) {
        driver.findElement(txtbx_LastName).sendKeys(lastName);
    }

    public void enter_Email(String email) {
        driver.findElement(txtbx_Email).sendKeys(email);
    }

    public void enter_Phone(String phone) {
        driver.findElement(txtbx_Phone).sendKeys(phone);
    }

    public void enter_City(String city) {
        driver.findElement(txtbx_City).sendKeys(city);
    }

    public void enter_Address(String address) {
        driver.findElement(txtbx_Address).sendKeys(address);
    }

    public void enter_PostCode(String postCode) {
        driver.findElement(txtbx_PostCode).sendKeys(postCode);
    }

    public void check_ShipToDifferentAddress(boolean value) {
        if (!value) {
            driver.findElement(chkbx_ShipToDifferetAddress).click();
        }
    }

    public void select_Country(String countryName) {
    	waitElement(drpdwn_CountryDropDownArrow);
        driver.findElement(drpdwn_CountryDropDownArrow).click();

        List<WebElement> countries = driver.findElements(countryList);
        for (WebElement country : countries) {
            if (country.getText().equals(countryName)) {
                country.click();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public void select_County(String countyName) {
        driver.findElement(drpdwn_CountyDropDownArrow).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> counties = driver.findElements(countryList);
        for (WebElement county : counties) {
            if (county.getText().equals(countyName)) {
                county.click();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public void select_PaymentMethod(String paymentMethod) {
        List<WebElement> paymentMethods = driver.findElements(paymentMethodList);
        if (paymentMethod.equals("CheckPayment")) {
            paymentMethods.get(0).click();
        } else if (paymentMethod.equals("Cash")) {
            paymentMethods.get(1).click();
        } else {
            throw new IllegalArgumentException("Payment Method not recognised : " + paymentMethod);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void check_TermsAndCondition(boolean value) {
        if (value) {
            driver.findElement(chkbx_AcceptTermsAndCondition).click();
        }
    }

    public void clickOn_PlaceOrder() {
        driver.findElement(btn_PlaceOrder).submit();
    }

    public void fill_PersonalDetails() {
        enter_Name("Automation");
        enter_LastName("Test");
        enter_Phone("0000000000");
        enter_Email("Automation@gmail.com");
        select_Country("India");
        enter_City("Delhi");
        enter_Address("Shalimar Bagh");
        enter_PostCode("110088");
        select_County("Delhi");
    }
}
