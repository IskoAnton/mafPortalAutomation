package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.User;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;

public class AccountPage extends InternalPage {
    public AccountPage(PageManager pages) {
        super(pages);
    }

    private final String  EXIT_ACCOUNT_LOCATOR= "//a[contains(text(), 'Exit') or contains(text(), 'Выход')]";
    private final String  PERSONAL_INFORMATION_LOCATOR= "//a[contains(text(), 'Персональные данные') or contains(text(), 'Account Information')]";
    private final String  MY_CLUBS_LOCATOR= "//nav[@class='menu']//a[contains(text(), 'Мои клубы') or contains(text(), 'My clubs')]";
    private final String  BALANCE_LOCATOR= "//nav[@class='menu']//a[contains(text(), 'Баланс') or contains(text(), 'Balance')]";
    private final String  SUBMIT_BUTTON_LOCATOR= "//button[@type = 'submit']";

    private final String FIRST_NAME_LOCATOR= "//input[@name = 'name']";
    private final String BILLING_FIRST_NAME_LOCATOR= "//section[@class = 'ContactPage ng-scope']//input[@name = 'name']";
    private final String LAST_NAME_FIELD_LOCATOR = "//input[@name = 'last_name']";
    private final String NICKNAME_FIELD_LOCATOR = "//input[@name = 'nickname']";
    private final String PASSWORD_FIELD_LOCATOR = "//input[@name = 'password']";
    private final String PASSWORD_CONFIRMATION_FIELD_LOCATOR = "//input[@name = 'password_confirmation']";
    private final String CLUB_LOCATOR = "//div[@class = 'clubs']//li";
    private final String MR_LOCATOR = "//input[@value = 'MR.']";
    private final String MRS_LOCATOR = "//input[@value = 'MRS.']";
    private final String MS_LOCATOR = "//input[@value = 'MS.']";
    private final String ADDRESS1_FIELD_LOCATOR = "//input[@name = 'address1']";
    private final String ADDRESS2_FIELD_LOCATOR = "//input[@name = 'address2']";
    private final String CITY_FIELD_LOCATOR = "//input[@name = 'city']";
    private final String REGION_FIELD_LOCATOR = "//input[@name = 'region']";
    private final String ZIP_FIELD_LOCATOR = "//input[@name = 'zip']";
    private final String COUNTRY_FIELD_LOCATOR = "//select[@name = 'country']";
    private final String EMAIL_FIELD_LOCATOR = "//input[@name = 'email']";


    @FindBy(xpath = EXIT_ACCOUNT_LOCATOR)
    private WebElement exitAccount;

    @FindBy(xpath = EMAIL_FIELD_LOCATOR)
    private WebElement emailField;

    @FindBy(xpath = PASSWORD_FIELD_LOCATOR)
    private WebElement passwordField;

    @FindBy(xpath = PASSWORD_CONFIRMATION_FIELD_LOCATOR)
    private WebElement passwordConfirmationField;

    @FindBy(xpath = SUBMIT_BUTTON_LOCATOR)
    private WebElement submitButton;



    public AccountPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.id("logout-form")));
        log("Account page was loaded successfully");
        return this;
    }

    public String getEmailOfUser() {
        return emailField.getAttribute("ng-init").split("\'")[1];
    }

    public void typePassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        log("Password " + password + " was typed to password field");
    }

    public void typePasswordConfirmation(String password) {
        passwordConfirmationField.clear();
        passwordConfirmationField.sendKeys(password);
        log("Password " + password + " was typed to password confirmation field");
    }

    public void clickSubmitButton() {
        submitButton.click();
        log("Submit button was pressed");
    }

    public void checkDataOnAccountPage(User user) {
        assertTrue(driver.findElement(By.xpath(FIRST_NAME_LOCATOR)).getAttribute("ng-init").equals("user.name='"+user.getName() + "'"));
        assertTrue(driver.findElement(By.xpath(LAST_NAME_FIELD_LOCATOR)).getAttribute("ng-init").equals("user.last_name='"+user.getLastName() + "'"));
        assertTrue(driver.findElement(By.xpath(NICKNAME_FIELD_LOCATOR)).getAttribute("ng-init").equals("user.nickname='"+user.getNickName() + "'"));
        assertTrue(driver.findElement(By.xpath(EMAIL_FIELD_LOCATOR)).getAttribute("ng-init").equals("user.email='"+user.getLogin() + "'"));
        driver.findElement(By.xpath(MY_CLUBS_LOCATOR)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLUB_LOCATOR)));
        assertTrue(driver.findElement(By.xpath(CLUB_LOCATOR)).getText().equals("- " + user.getClub()));
        driver.findElement(By.xpath(BALANCE_LOCATOR)).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BILLING_FIRST_NAME_LOCATOR)));
        assertTrue(driver.findElement(By.xpath(BILLING_FIRST_NAME_LOCATOR)).getAttribute("ng-init").equals("billing.name='"+user.getBillingAddress().getName() + "'"));
        assertTrue(driver.findElement(By.xpath(ADDRESS1_FIELD_LOCATOR)).getAttribute("ng-init").equals("billing.address1='"+user.getBillingAddress().getAddressLine1() + "'"));
        assertTrue(driver.findElement(By.xpath(ADDRESS2_FIELD_LOCATOR)).getAttribute("ng-init").equals("billing.address2='"+user.getBillingAddress().getAddressLine2() + "'"));
        assertTrue(driver.findElement(By.xpath(CITY_FIELD_LOCATOR)).getAttribute("ng-init").equals("billing.city='"+user.getBillingAddress().getCity() + "'"));
        assertTrue(driver.findElement(By.xpath(REGION_FIELD_LOCATOR)).getAttribute("ng-init").equals("billing.region='"+user.getBillingAddress().getRegion() + "'"));
        assertTrue(driver.findElement(By.xpath(ZIP_FIELD_LOCATOR)).getAttribute("ng-init").equals("billing.zip='"+user.getBillingAddress().getZip() + "'"));
        assertTrue(driver.findElement(By.xpath(COUNTRY_FIELD_LOCATOR)).getAttribute("ng-init").equals("billing.country='"+user.getBillingAddress().getCountry() + "'"));
        assertTrue(driver.findElement(By.xpath(EMAIL_FIELD_LOCATOR)).getAttribute("ng-init").equals("billing.email='"+user.getBillingAddress().getEmail() + "'"));

    }

    public void clickMyClubsButton() {
        driver.findElement(By.xpath("//nav[@class = 'menu']//li[2]/a")).click();
    }
}
