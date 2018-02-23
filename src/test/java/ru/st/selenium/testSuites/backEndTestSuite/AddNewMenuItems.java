package ru.st.selenium.testSuites.backEndTestSuite;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.MenuItem;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class AddNewMenuItems extends TestBase{
    public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AccountEntryTest.class.getName());
    User admin = TESTADMIN;
    MenuItem menuItem = TESTMENUITEM;
    MenuItem editMenuItem = EDITMENUITEM;

    @Test
    public void T001_addNewMenuItem() {
        User admin = TESTADMIN;
        MenuItem menuItem = TESTMENUITEM;
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Menu");
        app.getPages().adminMenuPage.clickAddItemButton();
        app.getPages().adminCreateMenuItemPage.fillAllFieldsWithData(menuItem);
        app.getPages().adminCreateMenuItemPage.pressSubmitButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getPages().internalPage.checkMenuItemOnPage(menuItem);
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Menu");
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T002_editMenuItem() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Menu");
        app.getPages().adminMenuPage.clickEditItem(menuItem.getLabel(), menuItem.getRusLabel());
        app.getPages().adminCreateMenuItemPage.fillAllFieldsWithData(editMenuItem);
        app.getPages().adminCreateMenuItemPage.pressSubmitButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getPages().internalPage.checkMenuItemOnPage(editMenuItem);
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Menu");
        app.getPages().adminPagesPage.deleteItem(editMenuItem.getLabel(), editMenuItem.getRusLabel());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T003_addBlankMenuItem() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Menu");
        app.getPages().adminMenuPage.clickAddItemButton();
        app.getPages().adminCreateMenuItemPage.pressSubmitButton();
        app.getPages().adminCreateMenuItemPage.checkRequiredFieldsMessages();
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T004_cancelAddingNewMenuItem() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Menu");
        app.getPages().adminMenuPage.clickAddItemButton();
        app.getPages().adminCreateMenuItemPage.fillAllFieldsWithData(menuItem);
        app.getPages().adminCreateMenuItemPage.pressCancelButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getPages().internalPage.checkMenuItemDoesntExist(menuItem);
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
