package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.News;
import ru.st.selenium.model.PageItem;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;

import java.io.IOException;

public class AddPageItemTest extends TestBase {
    @Test
    public void addNewPageItem() throws InterruptedException {
        log.info("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User admin = TESTADMIN;
        PageItem newPage = TESTPAGEITEM;
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
        app.getPages().adminPagesPage.deleteItem(newPage.getPageName());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
