package ru.st.selenium.testSuites.frontEndTestSuite;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ru.st.selenium.model.User;

import java.io.IOException;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class ForgotPasswordTest extends ru.st.selenium.pages.TestBase {

    public static final Logger log = Logger.getLogger(ForgotPasswordTest.class.getName());

    @Test
    public void T001_forgotPasswordOfExistingUser() throws Exception {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User user = TESTUSER;
        User forgotUser = FORGOTUSER;
        app.getPages().internalPage.setLanguage("rus");
        String language = app.getUserHelper().getLanguage();
        app.getUserHelper().restorePasswordOfExistingUser(language, user.getLogin());
        app.getUserHelper().pressResetPasswordLinkInEmail();
        app.getUserHelper().setNewPasswordAfterRestore(user.getLogin(), forgotUser.getPassword(), forgotUser.getPassword());
        app.getUserHelper().logout();
        app.getUserHelper().loginAs(forgotUser);
        app.getUserHelper().isLoggedInAs(forgotUser);
        app.getUserHelper().changeUserPassword(user.getPassword());
        app.getUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T002_forgotPasswordOfNotExistingUser() throws Exception {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User user = NOTEXISTINGUSER;
        app.getPages().internalPage.setLanguage("rus");
        String language = app.getUserHelper().getLanguage();
        app.getUserHelper().restorePasswordOfNotExistingUser(language, user.getLogin());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}

