package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.st.selenium.model.Address;
import ru.st.selenium.model.User;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class CartPage extends InternalPage {

    public CartPage(PageManager pages) {
            super(pages);
        }

    private final String  ITEMS_IN_CART_LOCATOR= "//div[@class = 'Rating_table']//tr[@class = 'animate_repeat ng-scope']";
    private final String  CART_PAGE_TITLE_LOCATOR= "//h1[@class = 'title_name' and (contains(text(), 'Cart') or contains(text(), 'Корзина'))]";
    private final String SHIPPING_MR_LOCATOR = "//input[@value = 'MR.']";
    private final String SHIPPING_MRS_LOCATOR = "//input[@value = 'MRS.']";
    private final String SHIPPING_MS_LOCATOR = "//input[@value = 'MS.']";
    private final String SHIPPING_NAME_FIELD_LOCATOR = "//input[@name = 'name']";
    private final String SHIPPING_ADDRESS1_FIELD_LOCATOR = "//input[@name = 'address1']";
    private final String SHIPPING_ADDRESS2_FIELD_LOCATOR = "//input[@name = 'address2']";
    private final String SHIPPING_CITY_FIELD_LOCATOR = "//input[@name = 'city']";
    private final String SHIPPING_REGION_FIELD_LOCATOR = "//input[@name = 'region']";
    private final String SHIPPING_ZIP_FIELD_LOCATOR = "//input[@name = 'zip']";
    private final String SHIPPING_EMAIL_FIELD_LOCATOR = "//input[@name = 'email']";
    private final String PAY_ORDER_BUTTON_LOCATOR = "//button[@id = 'click_submit']";


    @FindBy(xpath = ITEMS_IN_CART_LOCATOR)
    private List<WebElement> itemsInCart;



    public CartPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.xpath(CART_PAGE_TITLE_LOCATOR)));
        log("Cart page was loaded successfully");
        return this;
    }

    public boolean isItemInCart(String itemName) {
        try {
            driver.findElement(By.xpath("//th[@class = 'ng-binding' and contains(text(), '" + itemName + "')]"));
            log("Item " + itemName + " exist in the cart");
            return true;
        } catch (Exception e) {
            log("Item " + itemName + " doesn't exist in the cart");
            return false;
        }
    }

    public void removeItemFromCart(String itemName) {
        try {
            WebElement item = driver.findElement(By.xpath("//th[@class = 'ng-binding' and contains(text(), '" + itemName + "')]"));
            item.findElement(By.xpath("..//th[6]/a")).click();
            log("Item " + itemName + " was removed from the cart");
        } catch (Exception e) {
            log("Item " + itemName + " doesn't exist in the cart");

        }
    }

    public void fillShippingAddress(User user) {
        if (user.getShippingAddress().getTitle().equals(Address.Title.MR)) {
            driver.findElement(By.xpath(SHIPPING_MR_LOCATOR)).click();
            log("Title MR was chosen in shipping address");
        }
        if (user.getShippingAddress().getTitle().equals(Address.Title.MRS)) {
            driver.findElement(By.xpath(SHIPPING_MRS_LOCATOR)).click();
            log("Title MRS was chosen in shipping address");
        }
        if(user.getShippingAddress().getTitle().equals(Address.Title.MS)) {
            driver.findElement(By.xpath(SHIPPING_MS_LOCATOR)).click();
            log("Title MS was chosen in shipping address");
        }

        driver.findElement(By.xpath(SHIPPING_NAME_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getName());
        log("Shipping name '" + user.getShippingAddress().getName() + "' was typed to shipping name field");
        driver.findElement(By.xpath(SHIPPING_ADDRESS1_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getAddressLine1());
        log("Shipping address1 '" + user.getShippingAddress().getAddressLine1() + "' was typed to address line 1 field");
        driver.findElement(By.xpath(SHIPPING_ADDRESS2_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getAddressLine2());
        log("Shipping address1 '" + user.getShippingAddress().getAddressLine2() + "' was typed to address line 2 field");
        driver.findElement(By.xpath(SHIPPING_CITY_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getCity());
        log("Shipping city '" + user.getShippingAddress().getCity() + "' was typed to shipping city field");
        driver.findElement(By.xpath(SHIPPING_REGION_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getRegion());
        log("Shipping region '" + user.getShippingAddress().getRegion() + "' was typed to shipping region field");
        Select countrySelect = new Select(driver.findElement(By.xpath("//select[@name = 'country']")));
        countrySelect.selectByVisibleText(user.getShippingAddress().getCountry());
        log("Shipping country '" + user.getShippingAddress().getCountry() + "' was typed to shipping country field");
        driver.findElement(By.xpath(SHIPPING_ZIP_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getZip());
        log("Shipping zip '" + user.getShippingAddress().getZip() + "' was typed to shipping zip field");
        driver.findElement(By.xpath(SHIPPING_EMAIL_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getEmail());
        log("Shipping email '" + user.getShippingAddress().getEmail() + "' was typed to email field");
        log("Shipping address was filled");
    }

    public void clickPayTheOrder() {
        driver.findElement(By.xpath(PAY_ORDER_BUTTON_LOCATOR)).click();
        log("Pay order button was clicked");
    }

    public String getFullAmountOfItemsInTable() {
        String amount =  driver.findElement(By.xpath("//th[@id = 'price_value']")).getText();
        return amount;
    }

    public String getAmountOnPayTheOrderButton() {
        String textOnButton = driver.findElement(By.xpath(PAY_ORDER_BUTTON_LOCATOR)).getText();
        String[] arr = textOnButton.split(" ");
        String amount = arr[arr.length-1];
        return amount;
    }


}
