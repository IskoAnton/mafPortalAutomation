package ru.st.selenium.testSuites.frontEndTestSuite;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ru.st.selenium.model.User;
import java.io.IOException;
import static org.testng.AssertJUnit.assertTrue;

public class AccountEntryTest extends ru.st.selenium.pages.TestBase {
    public static final Logger log = Logger.getLogger(AccountEntryTest.class.getName());


    @Test
    public void accountEntryWithExistingUser() throws Exception {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User user = TESTUSER;
        app.getUserHelper().loginAs(user);
        assertTrue(app.getUserHelper().isLoggedInAs(user));
        app.getUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");

    }

    @Test
    public void accountEntryWithNotExistingUser() throws Exception {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User user = NOTEXISTINGUSER;
        String language = app.getUserHelper().getLanguage();
        app.getUserHelper().loginAs(user);
        if (language.equals("eng")) {
            app.getUserHelper().checkMessageInLoginPage("These credentials do not match our records.");
        } else app.getUserHelper().checkMessageInLoginPage("Неверное имя пользователя или пароль.");
        app.getPages().loginPage.closeLoginDialog();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }


    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
