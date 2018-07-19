package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public class PayPalLoginPage extends AnyPage{

    public PayPalLoginPage(PageManager pages) {
        super(pages);
    }

    private final String  EMAIL_FIELD_LOCATOR= "//input[@id = 'email']";
    private final String  PASSWORD_FIELD_LOCATOR= "//input[@id = 'password']";
    private final String  LOGIN_BUTTON_LOCATOR= "//button[@id = 'btnLogin']";

    @FindBy(xpath = EMAIL_FIELD_LOCATOR)
    private WebElement emailField;

    @FindBy(xpath = PASSWORD_FIELD_LOCATOR)
    private WebElement passwordField;

    @FindBy(xpath = LOGIN_BUTTON_LOCATOR)
    private WebElement loginButton;

    public void typeEmailToEmailField(String email) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@name = 'injectedUl']")));
        WebElement frame = driver.findElement(By.xpath("//iframe[@name = 'injectedUl']"));
        driver.switchTo().frame(frame);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EMAIL_FIELD_LOCATOR)));
        driver.findElement(By.xpath(EMAIL_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(EMAIL_FIELD_LOCATOR)).sendKeys(email);
        log("Email " + email + " was typed on PayPal login page");
        driver.switchTo().defaultContent();
        FluentWait wait = new FluentWait(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS);
    }

    public void typePasswordToPasswordField(String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@name = 'injectedUl']")));
        WebElement frame = driver.findElement(By.xpath("//iframe[@name = 'injectedUl']"));
        driver.switchTo().frame(frame);
        passwordField.clear();
        passwordField.sendKeys(password);
        log("Password " + password + " was typed on PayPal login page");
        driver.switchTo().defaultContent();
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@name = 'injectedUl']")));
        WebElement frame = driver.findElement(By.xpath("//iframe[@name = 'injectedUl']"));
        driver.switchTo().frame(frame);
        loginButton.click();
        log("Login button was clicked on PayPal login page");
        driver.switchTo().defaultContent();
    }
}
