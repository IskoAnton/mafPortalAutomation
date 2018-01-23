package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;

import java.io.IOException;
import java.util.logging.Logger;

public class AddNewUser extends TestBase{
    public static final Logger log = Logger.getLogger(AccountEntryTest.class.getName());

    @Test
    public void addNewUser() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User admin = TESTADMIN;
        User user = TESTUSER;
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Users, Roles, Permissions");
        app.getPages().adminInternalPage.clickOnAdminTab("Users");
        app.getPages().adminUsersPage.clickAddItemButton();
        app.getPages().adminCreateUserPage.fillAllFieldsWithData(user);
        app.getPages().adminCreateClubPage.pressSubmitButton();
        /*app.getPages().adminMenuPage.clickLogo();
        app.getUserHelper().logout();
        app.getPages().internalPage.setLanguage("eng");
        app.getUserHelper().loginAs(user);
        app.getPages().internalPage.clickAccountButton();
        app.getPages().accountPage.checkDataOnAccountPage(user);
        app.getUserHelper().logout();
        app.getNavigationHelper().gotoHomePage();
        app.getAdminUserHelper().logindAs(TESTADMIN);
        app.getAdminUserHelper().removeUserFromDB(user);*/
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
