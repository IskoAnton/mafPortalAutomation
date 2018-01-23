package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.st.selenium.model.Address;
import ru.st.selenium.model.User;

import java.util.ArrayList;
import java.util.List;

public class AdminCreateUserPage extends AdminCreateItemPage {
    public AdminCreateUserPage(PageManager pages) {
        super(pages);
    }

    private final String LAST_NAME_FIELD_LOCATOR = "//input[@name = 'last_name']";
    private final String NICKNAME_FIELD_LOCATOR = "//input[@name = 'nickname']";
    private final String EMAIL_FIELD_LOCATOR = "//input[@name = 'email']";
    private final String PASSWORD_FIELD_LOCATOR = "//input[@name = 'password']";
    private final String PASSWORD_CONFIRMATION_FIELD_LOCATOR = "//input[@name = 'password_confirmation']";
    private final String CLUBS_FIELD_LOCATOR = "//input[@id = 's2id_autogen2']";
    private final String SHIPPING_MR_LOCATOR = "//label[@for = 'shipping_title_3']";
    private final String SHIPPING_MRS_LOCATOR = "//label[@for = 'shipping_title_1']";
    private final String SHIPPING_MS_LOCATOR = "//label[@for = 'shipping_title_2']";
    private final String SHIPPING_NAME_FIELD_LOCATOR = "//input[@name = 'shipping_name']";
    private final String SHIPPING_ADDRESS1_FIELD_LOCATOR = "//input[@name = 'shipping_address1']";
    private final String SHIPPING_ADDRESS2_FIELD_LOCATOR = "//input[@name = 'shipping_address2']";
    private final String SHIPPING_CITY_FIELD_LOCATOR = "//input[@name = 'shipping_city']";
    private final String SHIPPING_REGION_FIELD_LOCATOR = "//input[@name = 'shipping_region']";
    private final String SHIPPING_ZIP_FIELD_LOCATOR = "//input[@name = 'shipping_zip']";
    private final String SHIPPING_COUNTRY_FIELD_LOCATOR = "//input[@name = 'shipping_country']";
    private final String SHIPPING_EMAIL_FIELD_LOCATOR = "//input[@name = 'shipping_email']";
    private final String BILLING_MR_LOCATOR = "//label[@for = 'billing_title_3']";
    private final String BILLING_MRS_LOCATOR = "//label[@for = 'billing_title_1']";
    private final String BILLING_MS_LOCATOR = "//label[@for = 'shipping_title_2']";
    private final String BILLING_NAME_FIELD_LOCATOR = "//input[@name = 'billing_name']";
    private final String BILLING_ADDRESS1_FIELD_LOCATOR = "//input[@name = 'billing_address1']";
    private final String BILLING_ADDRESS2_FIELD_LOCATOR = "//input[@name = 'billing_address2']";
    private final String BILLING_CITY_FIELD_LOCATOR = "//input[@name = 'billing_city']";
    private final String BILLING_REGION_FIELD_LOCATOR = "//input[@name = 'billing_region']";
    private final String BILLING_ZIP_FIELD_LOCATOR = "//input[@name = 'billing_zip']";
    private final String BILLING_COUNTRY_FIELD_LOCATOR = "//input[@name = 'billing_country']";
    private final String BILLING_EMAIL_FIELD_LOCATOR = "//input[@name = 'billing_email']";

    public void fillAllFieldsWithData(User user) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PAGE_NAME_FIELD_LOCATOR)));
        driver.findElement(By.xpath(PAGE_NAME_FIELD_LOCATOR)).sendKeys(user.getName());
        driver.findElement(By.xpath(LAST_NAME_FIELD_LOCATOR)).sendKeys(user.getLastName());
        driver.findElement(By.xpath(NICKNAME_FIELD_LOCATOR)).sendKeys(user.getNickName());
        driver.findElement(By.xpath(EMAIL_FIELD_LOCATOR)).sendKeys(user.getLogin());
        driver.findElement(By.xpath(PASSWORD_FIELD_LOCATOR)).sendKeys(user.getPassword());
        driver.findElement(By.xpath(PASSWORD_CONFIRMATION_FIELD_LOCATOR)).sendKeys(user.getPasswordConfirmation());
        driver.findElement(By.xpath(CLUBS_FIELD_LOCATOR)).sendKeys(user.getClub());
        driver.findElement(By.xpath(CLUBS_FIELD_LOCATOR)).sendKeys(Keys.ENTER);
        //TODO Put random checkboxes
        driver.findElement(By.xpath("//a[contains(text(), 'Payment data')]")).click();

        if (user.getShippingAddress().getTitle().equals(Address.Title.MR)) {
            driver.findElement(By.xpath(SHIPPING_MR_LOCATOR)).click();
        }
        if (user.getShippingAddress().getTitle().equals(Address.Title.MRS)) {
            driver.findElement(By.xpath(SHIPPING_MRS_LOCATOR)).click();
        }
        if(user.getShippingAddress().getTitle().equals(Address.Title.MS)) {
            driver.findElement(By.xpath(SHIPPING_MS_LOCATOR)).click();
        }

        driver.findElement(By.xpath(SHIPPING_NAME_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getName());
        driver.findElement(By.xpath(SHIPPING_ADDRESS1_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getAddressLine1());
        driver.findElement(By.xpath(SHIPPING_ADDRESS2_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getAddressLine2());
        driver.findElement(By.xpath(SHIPPING_CITY_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getCity());
        driver.findElement(By.xpath(SHIPPING_REGION_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getRegion());
        driver.findElement(By.xpath(SHIPPING_COUNTRY_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getCountry());
        driver.findElement(By.xpath(SHIPPING_ZIP_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getZip());
        driver.findElement(By.xpath(SHIPPING_EMAIL_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getEmail());

        if (user.getBillingAddress().getTitle().equals(Address.Title.MR)) {
            driver.findElement(By.xpath(BILLING_MR_LOCATOR)).click();
        }
        if (user.getBillingAddress().getTitle().equals(Address.Title.MRS)) {
            driver.findElement(By.xpath(BILLING_MRS_LOCATOR)).click();
        }
        if(user.getBillingAddress().getTitle().equals(Address.Title.MS)) {
            driver.findElement(By.xpath(BILLING_MS_LOCATOR)).click();
        }

        driver.findElement(By.xpath(BILLING_NAME_FIELD_LOCATOR)).sendKeys(user.getBillingAddress().getName());
        driver.findElement(By.xpath(BILLING_ADDRESS1_FIELD_LOCATOR)).sendKeys(user.getBillingAddress().getAddressLine1());
        driver.findElement(By.xpath(BILLING_ADDRESS2_FIELD_LOCATOR)).sendKeys(user.getBillingAddress().getAddressLine2());
        driver.findElement(By.xpath(BILLING_CITY_FIELD_LOCATOR)).sendKeys(user.getBillingAddress().getCity());
        driver.findElement(By.xpath(BILLING_REGION_FIELD_LOCATOR)).sendKeys(user.getBillingAddress().getRegion());
        driver.findElement(By.xpath(BILLING_COUNTRY_FIELD_LOCATOR)).sendKeys(user.getBillingAddress().getCountry());
        driver.findElement(By.xpath(BILLING_ZIP_FIELD_LOCATOR)).sendKeys(user.getBillingAddress().getZip());
        driver.findElement(By.xpath(BILLING_EMAIL_FIELD_LOCATOR)).sendKeys(user.getBillingAddress().getEmail());

    }
}
