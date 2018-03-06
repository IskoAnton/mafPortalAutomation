package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.testng.Assert.assertTrue;

public class LoginPage extends InternalPage {
  public LoginPage(PageManager pages) {
    super(pages);
  }

  private final String  EMAIL_FIELD_ON_LOGIN_PAGE_LOCATOR= "//form[@name = 'RegistForm']//input[@name = 'email']";
  private final String  EMAIL_FIELD_ON_FORGOT_PAGE_LOCATOR= "//form[@name = 'ForgotForm']//input[@name = 'email']";
  private final String  PASSWORD_FIELD_LOCATOR= "//input[@name = 'password']";
  private final String  SUBMIT_BUTTON_LOCATOR= "//form[@name = 'RegistForm']//div[@class = 'loginBtn']";
  private final String  CANCEL_BUTTON_LOCATOR= "//div[@class = 'cancel']";
  private final String  REGISTRATION_BUTTON_LOCATOR= "//div[@class = 'register']";
  private final String  CLOSE_DIALOG_BUTTON_LOCATOR= "//div[@class = 'title']//div[@class = 'close_button']";
  private final String  MESSAGE_LOCATOR= "//div[@class = 'message_group']//span[@class = 'red']";
  private final String  FORGOT_PASSWORD_BUTTON_LOCATOR= "//div[@class = 'login']//div[@class = 'forgot']/a";
  private final String  SEND_PASSWORD_BUTTON_LOCATOR= "//form[@name = 'ForgotForm']//div[@class = 'loginBtn']";

  @FindBy(xpath = EMAIL_FIELD_ON_LOGIN_PAGE_LOCATOR)
  private WebElement emailFieldOnLoginPage;

  @FindBy(xpath = EMAIL_FIELD_ON_FORGOT_PAGE_LOCATOR)
  private WebElement emailFieldOnForgotPage;

  @FindBy(xpath = PASSWORD_FIELD_LOCATOR)
  private WebElement passwordField;

  @FindBy(xpath = SUBMIT_BUTTON_LOCATOR)
  private WebElement submitButton;

  @FindBy(xpath = CANCEL_BUTTON_LOCATOR)
  private WebElement cancelButton;

  @FindBy(xpath = REGISTRATION_BUTTON_LOCATOR)
  private WebElement registrationButton;

  @FindBy(xpath = CLOSE_DIALOG_BUTTON_LOCATOR)
  private WebElement closeDialogButton;

  @FindBy(xpath = MESSAGE_LOCATOR)
  private WebElement messageField;

  @FindBy(xpath = FORGOT_PASSWORD_BUTTON_LOCATOR)
  private WebElement forgotPasswordButton;

  @FindBy(xpath = SEND_PASSWORD_BUTTON_LOCATOR)
  private WebElement sendPasswordButton;


  public LoginPage setUsernameFieldOnLoginPage(String username) {
      emailFieldOnLoginPage.clear();
      emailFieldOnLoginPage.sendKeys(username);
      log("Username \"" + username + "\" typed to username field");
    return this;
  }

  public LoginPage setUsernameFieldOnForgotPage(String username) {
    emailFieldOnForgotPage.clear();
    emailFieldOnForgotPage.sendKeys(username);
    log("Username \"" + username + "\" typed to username field");
    return this;
  }

  public LoginPage setPasswordField(String text) {
    wait.until(ExpectedConditions.elementToBeClickable(passwordField));
    passwordField.click();
    passwordField.clear();
    passwordField.sendKeys(text);
    log("Password \"" + text + "\" typed to password field");
    return this;
  }

  public HomePage clickSubmitButton() {
    submitButton.click();
    log("Submit button clicked");
    return new HomePage(pages);
  }

  public LoginPage clickForgotPasswordButton(){
    forgotPasswordButton.click();
    log("forgot password button was clicked");
    return this;
  }

  public LoginPage clickSendPasswordButton() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    sendPasswordButton.click();
    log("Send password button was pressed");
    return this;
  }

  public LoginPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.xpath(PASSWORD_FIELD_LOCATOR)));
    log("Login dialog was loaded");
    return this;
  }

  public void clickCloseLoginPage() {
      closeDialogButton.click();
  }

  public String getMessageInLoginPage() {
    pages.loginPage.ensurePageLoaded();
    return messageField.getText().trim();
  }

  public void closeLoginDialog() {
    closeDialogButton.click();
    log("Login dialog was closed");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public LoginPage ensurePasswordSendMessage(String language) {
    pages.loginPage.ensurePageLoaded();
    if (language.equals("eng")) {
      assertTrue(messageField.getText().trim().equals("We have e-mailed your password reset link!"));
    } else assertTrue(messageField.getText().trim().equals("Ссылка для сброса пароля отправлена на указанный email!"));
    return this;
  }

  public LoginPage ensureCantFindUserMessage(String language) {
    System.out.println(messageField.getText().trim());
    if (language.equals("eng")) {
      assertTrue(messageField.getText().trim().equals("We can't find a user with that e-mail address."));
    } else assertTrue(messageField.getText().trim().equals("Пользователя с таким именем не существует."));
    return this;
  }

  public void clickRegistrationButton() {
    registrationButton.click();
  }

}


