package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.News;
import ru.st.selenium.model.PageItem;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;

import java.io.IOException;

import static org.testng.Assert.assertFalse;

public class AddPageItemTest extends TestBase {
    User admin = TESTADMIN;
    PageItem newPage = TESTPAGEITEM;
    PageItem editPage = EDITPAGEITEM;
    @Test
    public void T001_addNewPageItem() throws InterruptedException {
        log.info("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Pages");
        app.getPages().adminPagesPage.clickAddItemButton();
        app.getPages().adminCreateNewPage.fillAllFieldsWithData(newPage);
        app.getPages().adminCreateNewPage.pressSubmitButton();
        app.getPages().adminPagesPage.clickOpenPage(newPage.getPageName());
        app.getNavigationHelper().switchToNewWindow();
        app.getPages().internalPage.setLanguage("rus");
        app.getPages().createdPage.checkDataOnNewPage(newPage);
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().createdPage.checkDataOnNewPage(newPage);
        app.getNavigationHelper().switchToDefaultWindow();
        app.getPages().adminInternalPage.clickOnAdminTab("Pages");
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T002_editPageItem() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Pages");
        app.getPages().adminPagesPage.clickEditItem(newPage.getPageName());
        app.getPages().adminCreateNewPage.fillAllFieldsWithData(editPage);
        app.getPages().adminCreateNewPage.pressSubmitButton();
        app.getPages().adminPagesPage.clickOpenPage(editPage.getPageName());
        app.getNavigationHelper().switchToNewWindow();
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().createdPage.checkDataOnNewPage(editPage);
        app.getPages().internalPage.setLanguage("rus");
        app.getPages().createdPage.checkDataOnNewPage(editPage);
        app.getNavigationHelper().switchToDefaultWindow();
        app.getPages().adminInternalPage.clickOnAdminTab("Pages");
        app.getPages().adminPagesPage.deleteItem(editPage.getPageName());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T003_addBlankPageItem() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Pages");
        app.getPages().adminPagesPage.clickAddItemButton();
        Thread.sleep(10000);
        app.getPages().adminCreateNewPage.pressSubmitButton();
        app.getPages().adminCreateNewPage.checkRequiredFieldsMessages();
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T004_cancelAddingNewPageItem() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Pages");
        app.getPages().adminPagesPage.clickAddItemButton();
        app.getPages().adminCreateNewPage.fillAllFieldsWithData(newPage);
        app.getPages().adminCreateNewPage.pressCancelButton();
        assertFalse(app.getPages().adminPagesPage.isPageExistInTheTable(newPage));
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
