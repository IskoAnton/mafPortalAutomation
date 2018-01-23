package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import javax.xml.soap.SAAJResult;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.testng.Assert.assertTrue;

public class AdminLoginPage extends AnyPage {
    public AdminLoginPage(PageManager pages) {
        super(pages);
    }

    private final String  EMAIL_FIELD_LOCATOR= "//input[@name = 'email']";
    private final String  PASSWORD_FIELD_LOCATOR= "//input[@name = 'password']";
    private final String  LOGIN_BUTTON_LOCATOR= "//button[@type = 'submit']";
    private final String  FORGOT_PASSWORD_BUTTON_LOCATOR= "//a[contains(text(), 'Forgot Your Password?') or contains(text(), 'Забыли пароль?')]";

    public AdminLoginPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.xpath(EMAIL_FIELD_LOCATOR)));
        log("AdminLoginPage page was loaded successfully");
        return this;
    }

    @FindBy(xpath = EMAIL_FIELD_LOCATOR)
    private WebElement emailField;

    @FindBy(xpath = PASSWORD_FIELD_LOCATOR)
    private WebElement passwordField;

    @FindBy(xpath = LOGIN_BUTTON_LOCATOR)
    private WebElement loginButton;

    @FindBy(xpath = FORGOT_PASSWORD_BUTTON_LOCATOR)
    private WebElement forgotPasswordButton;

    public void typeEmailField(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        log("\"" + email + "\" was typed to email field");
    }

    public void typePasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        log("\"" + password + "\" was typed to password field");
    }

    public void clickLoginButton() {
        loginButton.click();
        log("Login button was clicked");
    }

    public String getEmailFieldMessage() {
        String message = driver.findElement(By.xpath("//form[@class = 'form-horizontal']/div[1]//span[@class = 'help-block']/strong")).getText();
        log("The messagein email field is " + message);
        return message;
    }

    public String getPasswordFieldMessage() {
        String message = driver.findElement(By.xpath("//form[@class = 'form-horizontal']/div[2]//span[@class = 'help-block']/strong")).getText();
        log("The message in password field is " + message);
        return message;
    }
}

