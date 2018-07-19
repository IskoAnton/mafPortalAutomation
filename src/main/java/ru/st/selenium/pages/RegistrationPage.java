package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static java.awt.SystemColor.text;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class RegistrationPage extends InternalPage {
    public RegistrationPage(PageManager pages) {
        super(pages);
    }

    private final String  FIRST_NAME_FIELD_LOCATOR= "//input[@name = 'name']";
    private final String  LAST_NAME_FIELD_LOCATOR= "//input[@name = 'last_name']";
    private final String  NICKNAME_FIELD_LOCATOR= "//input[@name = 'nickname']";
    private final String  EMAIL_FIELD_LOCATOR= "//input[@name = 'email']";
    private final String  PASSWORD_FIELD_LOCATOR= "//input[@name = 'password']";
    private final String  DATE_FIELD_LOCATOR= "//input[@ng-model = 'user.date']";
    private final String  PASSWORD_CONFIRMATION_FIELD_LOCATOR= "//input[@name = 'password_confirmation']";
    private final String  SEND_BUTTON_LOCATOR= "//div[@class = 'loginBtn']";
    private final String  MESSAGE_AFTER_REGISTRATION_LOCATOR= "//div[@class = 'message_group']/span";
    private final String  REGISTRATION_PAGE_TITLE_LOCATOR = "//h1[@class = 'title_name' and (contains(text(), 'Registration') or contains(text(), 'РЕГИСТРАЦИЯ'))]";
    private final String  MAIN_CLUB_SELECTOR_LOCATOR = "//select[@name = 'club']";

    @FindBy(xpath = EMAIL_FIELD_LOCATOR)
    private WebElement emailField;

    @FindBy(xpath = FIRST_NAME_FIELD_LOCATOR)
    private WebElement firstNameField;

    @FindBy(xpath = LAST_NAME_FIELD_LOCATOR)
    private WebElement lastNameField;

    @FindBy(xpath = NICKNAME_FIELD_LOCATOR)
    private WebElement nickNameField;

    @FindBy(xpath = PASSWORD_FIELD_LOCATOR)
    private WebElement passwordField;

    @FindBy(xpath = DATE_FIELD_LOCATOR)
    private WebElement dateField;

    @FindBy(xpath = PASSWORD_CONFIRMATION_FIELD_LOCATOR )
    private WebElement passwordConfirmationField;

    @FindBy(xpath = SEND_BUTTON_LOCATOR )
    private WebElement sendButton;

    @FindBy(xpath = MESSAGE_AFTER_REGISTRATION_LOCATOR)
    private WebElement messageBox;

    @FindBy(xpath = MAIN_CLUB_SELECTOR_LOCATOR)
    private WebElement mainClub;


    public RegistrationPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.xpath(REGISTRATION_PAGE_TITLE_LOCATOR)));
        log("Registration page was loaded successfully");
        return this;
    }

    public void setFirsName(String firsName) {
        firstNameField.clear();
        firstNameField.sendKeys(firsName);
    }

    public void setLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void setNickName(String nickName) {
        nickNameField.clear();
        nickNameField.sendKeys(nickName);
    }

    public void setEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void setDate(String date) {
        dateField.clear();
        dateField.sendKeys(date);
    }

    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void setPasswordConfirmation(String password) {
        passwordConfirmationField.clear();
        passwordConfirmationField.sendKeys(password);
    }

    public String getMessageAfterRegistration() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(presenceOfElementLocated(By.xpath(MESSAGE_AFTER_REGISTRATION_LOCATOR)));
        String text = "";
        text = messageBox.getText().trim();
        log("Message after registration is: \"" + text + "\"");
        return text;
    }

    public void selectMainClub(String club) {
        Select mainClubSelector = new Select(mainClub);
        mainClubSelector.selectByVisibleText(club);
    }

    public void clickSendButton() {
        sendButton.click();
    }
}
