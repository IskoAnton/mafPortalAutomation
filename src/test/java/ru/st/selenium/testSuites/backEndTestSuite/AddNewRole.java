package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.Club;
import ru.st.selenium.model.Role;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;

import java.io.IOException;
import java.util.logging.Logger;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AddNewRole extends TestBase{
    public static final Logger log = Logger.getLogger(AccountEntryTest.class.getName());
    User admin = TESTADMIN;
    Role role = TESTROLE;
    Role editRole = EDITROLE;
    Role blankRole = BLANKROLE;

    @Test
    public void T001_addNewRole() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Users, Roles, Permissions");
        app.getPages().adminInternalPage.clickOnAdminTab("Roles");
        app.getPages().adminRolePage.clickAddItemButton();
        app.getPages().adminCreateRolePage.fillAllFieldsWithData(role);
        app.getPages().adminCreateRolePage.pressSubmitButton();
        app.getPages().adminInternalPage.clickOnAdminTab("Users");
        app.getPages().adminUsersPage.clickAddItemButton();
        assertTrue(app.getPages().adminCreateUserPage.isCheckboxInTheList(role.getName()));
        //TODO Make checking what user can edit with particular role
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T002_editRole() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Users, Roles, Permissions");
        app.getPages().adminInternalPage.clickOnAdminTab("Roles");
        app.getPages().adminRolePage.clickEditItem(role.getName());
        app.getPages().adminCreateRolePage.fillAllFieldsWithData(editRole);
        app.getPages().adminCreateRolePage.pressSubmitButton();
        app.getPages().adminInternalPage.clickOnAdminTab("Users");
        app.getPages().adminUsersPage.clickAddItemButton();
        assertTrue(app.getPages().adminCreateUserPage.isCheckboxInTheList(editRole.getName()));
        app.getPages().adminInternalPage.clickOnAdminTab("Roles");
        app.getPages().adminPagesPage.deleteItem(editRole.getName());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }



    @Test
    public void T003_addBlankRole() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Users, Roles, Permissions");
        app.getPages().adminInternalPage.clickOnAdminTab("Roles");
        app.getPages().adminRolePage.clickAddItemButton();
        app.getPages().adminCreateRolePage.fillAllFieldsWithData(blankRole);
        app.getPages().adminCreateRolePage.pressSubmitButton();
        app.getPages().adminCreateRolePage.checkRequiredFieldsMessages();
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T004_cancelAddingNewRole() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Users, Roles, Permissions");
        app.getPages().adminInternalPage.clickOnAdminTab("Roles");
        app.getPages().adminRolePage.clickAddItemButton();
        app.getPages().adminCreateRolePage.fillAllFieldsWithData(role);
        app.getPages().adminCreateRolePage.pressCancelButton();
        app.getPages().adminInternalPage.clickOnAdminTab("Users");
        app.getPages().adminUsersPage.clickAddItemButton();
        assertFalse(app.getPages().adminCreateUserPage.isCheckboxInTheList(role.getName()));
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
