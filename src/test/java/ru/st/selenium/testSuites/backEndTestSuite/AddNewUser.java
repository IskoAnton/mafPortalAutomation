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
    User admin = TESTADMIN;
    User user1 = TESTUSER;
    User editUser = EDITUSER;


    @Test
    public void T001_addNewUser() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Users, Roles, Permissions");
        app.getPages().adminInternalPage.clickOnAdminTab("Users");
        app.getPages().adminUsersPage.clickAddItemButton();
        app.getPages().adminCreateUserPage.fillAllFieldsWithData(user1);
        app.getPages().adminCreateClubPage.pressSubmitButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getUserHelper().logout();
        app.getPages().internalPage.setLanguage("eng");
        app.getUserHelper().loginAs(user1);
        app.getPages().internalPage.clickAccountButton();
        app.getPages().accountPage.checkDataOnAccountPage(user1);
        app.getUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T002_editUser() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Users, Roles, Permissions");
        app.getPages().adminInternalPage.clickOnAdminTab("Users");
        app.getPages().adminUsersPage.clickEditItem(user1.getLogin());
        app.getPages().adminCreateUserPage.fillAllFieldsWithData(editUser);
        app.getPages().adminCreateUserPage.pressSubmitButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getUserHelper().logout();
        app.getPages().internalPage.setLanguage("eng");
        app.getUserHelper().loginAs(editUser);
        app.getPages().internalPage.clickAccountButton();
        app.getPages().accountPage.checkDataOnAccountPage(editUser);
        app.getUserHelper().logout();
        app.getNavigationHelper().gotoHomePage();
        app.getAdminUserHelper().logindAs(TESTADMIN);
        app.getAdminUserHelper().removeUserFromDB(user1);
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

   /* @Test
    public void T003_addBlankUser() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Users, Roles, Permissions");
        app.getPages().adminInternalPage.clickOnAdminTab("Users");
        app.getPages().adminUsersPage.clickAddItemButton();
        app.getPages().adminCreateUserPage.pressSubmitButton();
        app.getPages().adminCreateUserPage.checkRequiredFieldsMessages();
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }*/

    /*@Test
    public void T004_cancelAddingNewUser() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Users, Roles, Permissions");
        app.getPages().adminInternalPage.clickOnAdminTab("Users");
        app.getPages().adminUsersPage.clickAddItemButton();
        app.getPages().adminCreateUserPage.fillAllFieldsWithData(user1);
        app.getPages().adminCreateUserPage.pressCancelButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getUserHelper().logout();
        app.getPages().internalPage.setLanguage("eng");
        app.getUserHelper().loginAs(user1);
        app.getUserHelper().checkMessageInLoginPage("These credentials do not match our records.");
        app.getPages().loginPage.closeLoginDialog();
        app.getPages().internalPage.setLanguage("rus");
        app.getUserHelper().loginAs(user1);
        app.getUserHelper().checkMessageInLoginPage("Неверное имя пользователя или пароль.");
        app.getPages().loginPage.closeLoginDialog();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }*/

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
