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
        driver.findElement(By.xpath(PAGE_NAME_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(PAGE_NAME_FIELD_LOCATOR)).sendKeys(user.getName());
        log("Name '" + user.getName() + "' was typed to name field");
        driver.findElement(By.xpath(LAST_NAME_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(LAST_NAME_FIELD_LOCATOR)).sendKeys(user.getLastName());
        log("Last name '" + user.getLastName() + "' was typed to last name field");
        driver.findElement(By.xpath(NICKNAME_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(NICKNAME_FIELD_LOCATOR)).sendKeys(user.getNickName());
        log("Nickname '" + user.getNickName() + "' was typed to nickname field");
        driver.findElement(By.xpath(EMAIL_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(EMAIL_FIELD_LOCATOR)).sendKeys(user.getLogin());
        log("Email '" + user.getLogin() + "' was typed to ename field");
        driver.findElement(By.xpath(PASSWORD_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(PASSWORD_FIELD_LOCATOR)).sendKeys(user.getPassword());
        log("Password '" + user.getPassword() + "' was typed to password field");
        driver.findElement(By.xpath(PASSWORD_CONFIRMATION_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(PASSWORD_CONFIRMATION_FIELD_LOCATOR)).sendKeys(user.getPasswordConfirmation());
        log("Password confirmaion'" + user.getPasswordConfirmation() + "' was typed to password confirmation field");
        if (!user.getClub().equals("") && !isElementPresent(By.xpath("//li[@class = 'select2-search-choice']/div"))) {
            driver.findElement(By.xpath(CLUBS_FIELD_LOCATOR)).sendKeys(user.getClub());
            driver.findElement(By.xpath(CLUBS_FIELD_LOCATOR)).sendKeys(Keys.ENTER);
            //driver.findElement(By.xpath("//h3")).click();
            log("Club '" + user.getClub() + "' was typed to clyb field");
        }

        //TODO Put random checkboxes
        driver.findElement(By.xpath("//a[contains(text(), 'Payment data')]")).click();
        log("Payment data button was pressed");

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

        driver.findElement(By.xpath(SHIPPING_NAME_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(SHIPPING_NAME_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getName());
        log("Shipping name '" + user.getShippingAddress().getName() + "' was typed to shipping name field");
        driver.findElement(By.xpath(SHIPPING_ADDRESS1_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(SHIPPING_ADDRESS1_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getAddressLine1());
        log("Shipping address1 '" + user.getShippingAddress().getAddressLine1() + "' was typed to address line 1 field");
        driver.findElement(By.xpath(SHIPPING_ADDRESS2_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(SHIPPING_ADDRESS2_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getAddressLine2());
        log("Shipping address1 '" + user.getShippingAddress().getAddressLine2() + "' was typed to address line 2 field");
        driver.findElement(By.xpath(SHIPPING_CITY_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(SHIPPING_CITY_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getCity());
        log("Shipping city '" + user.getShippingAddress().getCity() + "' was typed to shipping city field");
        driver.findElement(By.xpath(SHIPPING_REGION_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(SHIPPING_REGION_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getRegion());
        log("Shipping region '" + user.getShippingAddress().getRegion() + "' was typed to shipping region field");
        driver.findElement(By.xpath(SHIPPING_COUNTRY_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(SHIPPING_COUNTRY_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getCountry());
        log("Shipping country '" + user.getShippingAddress().getCountry() + "' was typed to shipping country field");
        driver.findElement(By.xpath(SHIPPING_ZIP_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(SHIPPING_ZIP_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getZip());
        log("Shipping zip '" + user.getShippingAddress().getZip() + "' was typed to shipping zip field");
        driver.findElement(By.xpath(SHIPPING_EMAIL_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(SHIPPING_EMAIL_FIELD_LOCATOR)).sendKeys(user.getShippingAddress().getEmail());
        log("Shipping email '" + user.getShippingAddress().getEmail() + "' was typed to email field");
        log("Shipping address was filled");

        if (user.getBillingAddress().getTitle().equals(Address.Title.MR)) {
            driver.findElement(By.xpath(BILLING_MR_LOCATOR)).click();
            log("Title MR was chosen in billing address");
        }
        if (user.getBillingAddress().getTitle().equals(Address.Title.MRS)) {
            driver.findElement(By.xpath(BILLING_MRS_LOCATOR)).click();
            log("Title MRS was chosen in billing address");
        }
        if(user.getBillingAddress().getTitle().equals(Address.Title.MS)) {
            driver.findElement(By.xpath(BILLING_MS_LOCATOR)).click();
            log("Title MS was chosen in billing address");
        }

        driver.findElement(By.xpath(BILLING_NAME_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(BILLING_NAME_FIELD_LOCATOR)).sendKeys(user.getBillingAddress().getName());
        log("Billing name '" + user.getBillingAddress().getName() + "' was typed to billing name field");
        driver.findElement(By.xpath(BILLING_ADDRESS1_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(BILLING_ADDRESS1_FIELD_LOCATOR)).sendKeys(user.getBillingAddress().getAddressLine1());
        log("Billing address1 '" + user.getBillingAddress().getAddressLine1() + "' was typed to address line 1 field");
        driver.findElement(By.xpath(BILLING_ADDRESS2_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(BILLING_ADDRESS2_FIELD_LOCATOR)).sendKeys(user.getBillingAddress().getAddressLine2());
        log("Billing address1 '" + user.getBillingAddress().getAddressLine2() + "' was typed to address line 2 field");
        driver.findElement(By.xpath(BILLING_CITY_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(BILLING_CITY_FIELD_LOCATOR)).sendKeys(user.getBillingAddress().getCity());
        log("Billing city '" + user.getBillingAddress().getCity() + "' was typed to billing city field");
        driver.findElement(By.xpath(BILLING_REGION_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(BILLING_REGION_FIELD_LOCATOR)).sendKeys(user.getBillingAddress().getRegion());
        log("Billing region '" + user.getBillingAddress().getRegion() + "' was typed to billing region field");
        driver.findElement(By.xpath(BILLING_COUNTRY_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(BILLING_COUNTRY_FIELD_LOCATOR)).sendKeys(user.getBillingAddress().getCountry());
        log("Billing country '" + user.getBillingAddress().getCountry() + "' was typed to billing country field");
        driver.findElement(By.xpath(BILLING_ZIP_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(BILLING_ZIP_FIELD_LOCATOR)).sendKeys(user.getBillingAddress().getZip());
        log("Billing zip '" + user.getBillingAddress().getZip() + "' was typed to billing zip field");
        driver.findElement(By.xpath(BILLING_EMAIL_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(BILLING_EMAIL_FIELD_LOCATOR)).sendKeys(user.getBillingAddress().getEmail());
        log("Billing email '" + user.getBillingAddress().getEmail() + "' was typed to billing email field");
        log("Billing address was filled");
    }

    public void checkRequiredFieldsMessages() {
        String language = getLanguage();
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The email field is required.']"));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The name field is required.']"));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The password field is required.']"));
        log("Message 1 is 'The title name is required.'");
        driver.findElement(By.xpath("//label[contains(text(), 'Email')]/../..//div[@class = 'help-block' and text() = 'The email field is required.']"));
        if (language.equals("rus")) {
            driver.findElement(By.xpath("//label[contains(text(), 'Имя')]/../..//div[@class = 'help-block' and text() = 'The name field is required.']"));
        } else driver.findElement(By.xpath("//label[contains(text(), 'Name')]/../..//div[@class = 'help-block' and text() = 'The name field is required.']"));
        driver.findElement(By.xpath("//label[contains(text(), 'Password')]/../..//div[@class = 'help-block' and text() = 'The password field is required.']"));

        log("Message 2 is 'The title field is required.'");
    }
}
