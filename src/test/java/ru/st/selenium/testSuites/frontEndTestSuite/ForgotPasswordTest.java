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
    public void forgotPasswordOfExistingUser() throws Exception {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User user = TESTUSER;
        String language = app.getUserHelper().getLanguage();
        app.getUserHelper().restorePasswordOfExistingUser(language, user.getLogin());
        app.getUserHelper().pressResetPasswordLinkInEmail();
        user.setPassword("123456789");
        app.getUserHelper().setNewPasswordAfterRestore(user.getLogin(), user.getPassword(), user.getPassword());
        app.getUserHelper().logout();
        app.getUserHelper().loginAs(user);
        app.getUserHelper().isLoggedInAs(user);
        user.setPassword("12345678");
        app.getUserHelper().changeUserPassword(user.getPassword());
        app.getUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void forgotPasswordOfNotExistingUser() throws Exception {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User user = NOTEXISTINGUSER;
        String language = app.getUserHelper().getLanguage();
        app.getUserHelper().restorePasswordOfNotExistingUser(language, user.getLogin());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}

