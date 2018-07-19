package ru.st.selenium.testSuites.frontEndTestSuite;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;

import java.io.IOException;
import java.util.Date;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class NewUserRegistration extends TestBase{
    public static final Logger log = Logger.getLogger(AccountEntryTest.class.getName());


    @Test
    public void registrationOfNewUserTest() throws Exception {
        log.info("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User newUser = TESTUSER;
        app.getPages().internalPage.setLanguage("rus");
        app.getUserHelper().registerNewUser("TesterFirstName", "TesterLastName", "TesterNickName",newUser.getLogin(), "2017-11-21", newUser.getPassword(), newUser.getPassword(), newUser.getClub());
        app.getUserHelper().pressRegistrationLinkInEmail();
        app.getNavigationHelper().gotoHomePage();
        app.getUserHelper().loginAs(newUser);
        assertTrue(app.getUserHelper().isLoggedInAs(newUser));
        assertEquals(newUser.getClub(), app.getUserHelper().getMainClubOnAccountPage());
        app.getUserHelper().logout();
        log.info("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");

    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
