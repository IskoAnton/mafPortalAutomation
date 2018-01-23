package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;

import java.io.IOException;
import java.util.logging.Logger;

import static org.testng.AssertJUnit.assertEquals;

public class AdminAccountEntry extends TestBase {
    public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AccountEntryTest.class.getName());


    @Test
    public void adminAccountEntryWithExistingUser() {
        User testadmin = TESTADMIN;
        app.getAdminUserHelper().logindAs(testadmin);
        app.getAdminUserHelper().logout();
    }

    @Test
    public void adminAccountEntryWithNotExistingUser() {
        app.getNavigationHelper().gotoHomePage();
        User wrongAdmin = NOTEXISTINGUSER;
        String language = app.getUserHelper().getLanguage();
        app.getAdminUserHelper().logindAs(wrongAdmin);
        if (language.equals("rus")) assertEquals("Неверное имя пользователя или пароль.", app.getPages().adminLoginPage.getEmailFieldMessage());
        else assertEquals("These credentials do not match our records.", app.getPages().adminLoginPage.getEmailFieldMessage());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");

    }

    @Test
    public void adminAccountEntryWithBlankUser() {
        log.info("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getNavigationHelper().gotoHomePage();
        User blankAdmin = BLANKUSER;
        String language = app.getUserHelper().getLanguage();
        app.getAdminUserHelper().logindAs(blankAdmin);
        if (language.equals("rus")) {
            assertEquals("The email field is required.", app.getPages().adminLoginPage.getEmailFieldMessage());
            assertEquals("The password field is required.", app.getPages().adminLoginPage.getPasswordFieldMessage());
        } else {
            assertEquals("The email field is required.", app.getPages().adminLoginPage.getEmailFieldMessage());
            assertEquals("The password field is required.", app.getPages().adminLoginPage.getPasswordFieldMessage());
        }
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");

    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
