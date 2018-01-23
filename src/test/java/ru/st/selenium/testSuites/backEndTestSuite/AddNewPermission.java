package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.Permission;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;

import java.io.IOException;
import java.util.logging.Logger;

import static org.testng.Assert.assertTrue;

public class AddNewPermission extends TestBase {
    public static final Logger log = Logger.getLogger(AccountEntryTest.class.getName());

    @Test
    public void addNewPermission() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User admin = TESTADMIN;
        Permission permission = TESTPERMISSION;
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Users, Roles, Permissions");
        app.getPages().adminInternalPage.clickOnAdminTab("Permissions");
        app.getPages().adminPermitionPage.clickAddItemButton();
        app.getPages().adminCreatePermitionPage.fillAllFieldsWithData(permission);
        app.getPages().adminCreateCountryPage.pressSubmitButton();
        app.getPages().adminInternalPage.clickOnAdminTab("Roles");
        app.getPages().adminRolePage.clickAddItemButton();
        assertTrue(app.getPages().adminCreateRolePage.isCheckboxInTheList(permission.getName()));
        app.getPages().adminInternalPage.clickOnAdminTab("Permissions");
        app.getPages().adminCountiesPage.deleteItem(permission.getName(), "Name");


        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
