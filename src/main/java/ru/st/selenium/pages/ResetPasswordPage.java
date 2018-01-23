package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ResetPasswordPage extends InternalPage {
    public ResetPasswordPage(PageManager pages) {
        super(pages);
    }

    private final String  EMAIL_FIELD_LOCATOR= "//input[@name = 'email']";
    private final String  PASSWORD_FIELD_LOCATOR= "//input[@name = 'password']";
    private final String  PASSWORD_CONFIRMATION_FIELD_LOCATOR= "//input[@name = 'password_confirmation']";
    private final String  SUBMIT_BUTTON_LOCATOR= "//button[@type = 'submit']";
    private final String  RESET_PASSWORD_PAGE_TITLE_LOCATOR = "//h1[@class = 'title_name' and contains(text(), 'Forgot password?')]";


    @FindBy(xpath = EMAIL_FIELD_LOCATOR)
    private WebElement emailField;

    @FindBy(xpath = PASSWORD_FIELD_LOCATOR)
    private WebElement passwordField;

    @FindBy(xpath = PASSWORD_CONFIRMATION_FIELD_LOCATOR)
    private WebElement passwordConfirmationField;

    @FindBy(xpath = SUBMIT_BUTTON_LOCATOR)
    private WebElement submitButton;

    public ResetPasswordPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.xpath(RESET_PASSWORD_PAGE_TITLE_LOCATOR)));
        log("Reset password page was loaded successfully");
        return this;
    }

    public void typeEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        log("Email " + email + " was typed to email field");
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

    public void pressSubmitButton() {
        submitButton.click();
        log("Submit button was pressed on Reset Password Page");

    }
}
