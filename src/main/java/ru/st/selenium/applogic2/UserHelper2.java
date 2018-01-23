package ru.st.selenium.applogic2;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import ru.st.selenium.applogic.UserHelper;
import ru.st.selenium.model.User;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class UserHelper2 extends DriverBasedHelper implements UserHelper {
  public final Logger log = Logger.getLogger(this.getClass().getSimpleName());

  public UserHelper2(ApplicationManager2 manager) {
    super(manager.getWebDriver());
  }

  @Override
  public void loginAs(User user) throws InterruptedException {
    pages.internalPage.clickLoginButton();
    pages.loginPage
      .setUsernameFieldOnLoginPage(user.getLogin())
      .setPasswordField(user.getPassword())
      .clickSubmitButton();
    pages.internalPage.ensurePageLoaded();
    log("Login is successfull");
    Thread.sleep(2000);
  }

  @Override
  public void logout() {
    pages.internalPage.clickLogoutButton();
    pages.internalPage.ensurePageLoaded();
    log("Logout successful");
  }

  @Override
  public boolean isLoggedIn() {
    pages.internalPage.clickLoginButton();
    pages.accountPage.ensurePageLoaded();
    return pages.internalPage.waitPageLoaded();
  }

  @Override
  public boolean isLoggedInAs(User user) {
    pages.internalPage.clickAccountButton();
    pages.accountPage.ensurePageLoaded();
    String email = pages.accountPage.getEmailOfUser();
    if (email.equalsIgnoreCase(user.getLogin())) {
      log("Logged in as " + user.getLogin());
      return true;
    }
    else {
      log("Logged in as NOT a" + user.getLogin());
      return false;
    }

  }

  @Override
  public boolean isNotLoggedIn() {
    pages.internalPage.clickLoginButton();
    pages.loginPage
            .ensurePageLoaded()
            .clickCloseLoginPage();
    return pages.internalPage.waitPageLoaded();

  }
  public void checkMessageInLoginPage(String message) {
    String text = pages.loginPage.getMessageInLoginPage();
    System.out.println(text);
    assertEquals(text, message);
  }

  public void restorePasswordOfExistingUser(String language, String email) {
    pages.internalPage.clickLoginButton();
    pages.loginPage.clickForgotPasswordButton()
            .setUsernameFieldOnForgotPage(email)
            .clickSendPasswordButton()
            .ensurePasswordSendMessage(language)
            .closeLoginDialog();
  }

    public void restorePasswordOfNotExistingUser(String language, String email) throws InterruptedException {
    pages.internalPage.clickLoginButton();
    pages.loginPage.clickForgotPasswordButton()
            .setUsernameFieldOnForgotPage(email)
            .clickSendPasswordButton()
            .ensureCantFindUserMessage(language)
            .closeLoginDialog();

  }

  public void registerNewUser(String firstName, String lastName, String nickName, String email, String date, String password, String passwordConfirmation) {
    pages.internalPage.clickLoginButton();
    pages.loginPage.clickRegistrationButton();
    pages.registrationPage.ensurePageLoaded();
    pages.registrationPage.setFirsName(firstName);
    pages.registrationPage.setLastName(lastName);
    pages.registrationPage.setNickName(nickName);
    pages.registrationPage.setEmail(email);
    pages.registrationPage.setDate(date);
    pages.registrationPage.setPassword(password);
    pages.registrationPage.setPasswordConfirmation(passwordConfirmation);
    pages.registrationPage.clickSendButton();
    String message = pages.registrationPage.getMessageAfterRegistration();
    try {
      assertEquals(message,"You have successfully registered. A link to confirm your registration has been sent to your email address.");
    } catch (Exception e) {
      assertEquals(message, "You have successfully registered. A link to confirm your registration has been sent to your email address.");
    }
  }

  public void pressRegistrationLinkInEmail() throws Exception {
    MailHelper2 mailHelper2 = new MailHelper2();
    String link = mailHelper2.getEmailLink("Email Verification");
    driver.get(link);
  }

  public boolean isNewMassagesInMailBox() {
    try {
      MailHelper2 mailHelper2 = new MailHelper2();
      mailHelper2.getEmailLink("Email Verification");
      return true;
    } catch (Exception e) {
      try {
        MailHelper2 mailHelper2 = new MailHelper2();
        mailHelper2.getEmailLink("Reset Password");
        return true;
      } catch (Exception e1) {
        log("No new Messages in mailbox");
        return false;
      }
    }

  }

  public void pressResetPasswordLinkInEmail() throws Exception {
    MailHelper2 mailHelper2 = new MailHelper2();
    //assertTrue(isNewMassagesInMailBox());
    String link = mailHelper2.getEmailLink("Reset Password");
    driver.get(link);

  }

  public void setNewPasswordAfterRestore(String email, String password, String passwordConfirmation) {
    pages.resetPasswordPage.typeEmail(email);
    pages.resetPasswordPage.typePassword(password);
    pages.resetPasswordPage.typePasswordConfirmation(passwordConfirmation);
    pages.resetPasswordPage.pressSubmitButton();
  }

  public void changeUserPassword(String newPassword) {
    pages.internalPage.clickLoginButton();
    pages.accountPage.typePassword(newPassword);
    pages.accountPage.typePasswordConfirmation(newPassword);
    pages.accountPage.clickSubmitButton();
    log("New password \"" + newPassword + "\" was set");
  }

  public String getLanguage() {
    String text = driver.findElement(By.xpath("//div[@class = 'copyrightWr']//p[@class = 'desktop']")).getText().trim();
    if (text.contains("торговая марка")) return "rus";
    else return "eng";
  }




}
