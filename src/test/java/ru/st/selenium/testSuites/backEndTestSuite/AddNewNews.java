package ru.st.selenium.testSuites.backEndTestSuite;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.MenuItem;
import ru.st.selenium.model.News;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;

import java.io.IOException;

public class AddNewNews extends TestBase{
    public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AccountEntryTest.class.getName());
    User admin = TESTADMIN;
    News news = TESTNEWS;
    News editNews = TESTEDITNEWS;
    News blankNews = BLANKNEWS;
    @Test
    public void T001_addNewNewsItem() {
        log.info("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("News");
        app.getPages().adminNewsPage.clickAddItemButton();
        app.getPages().adminCreateNewsPage.fillAllFieldsWithData(news);
        app.getPages().adminCreateMenuItemPage.pressSubmitButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getNavigationHelper().gotoNewsPage();
        app.getPages().newsPage.clickNews(news);
        app.getPages().newsItemPage.checkDataOnNewsItemPage(news);
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().newsItemPage.checkDataOnNewsItemPage(news);

        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");

    }

    @Test
    public void T002_editNews() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("News");
        app.getPages().adminNewsPage.clickEditItem(news.getTitle(), news.getRusTitle());
        app.getPages().adminCreateNewsPage.fillAllFieldsWithData(editNews);
        app.getPages().adminCreateNewsPage.pressSubmitButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getNavigationHelper().gotoNewsPage();
        app.getPages().newsPage.clickNews(editNews);
        app.getPages().newsItemPage.checkDataOnNewsItemPage(editNews);
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().newsItemPage.checkDataOnNewsItemPage(editNews);
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("News");
        app.getPages().adminPagesPage.deleteItem(editNews.getTitle(), editNews.getRusTitle());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T003_addBlankNews() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("News");
        app.getPages().adminNewsPage.clickAddItemButton();
        app.getPages().adminCreateNewsPage.fillAllFieldsWithData(blankNews);
        app.getPages().adminCreateNewsPage.pressSubmitButton();
        app.getPages().adminCreateNewsPage.checkRequiredFieldsMessages();
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T004_cancelAddingNewNews() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("News");
        app.getPages().adminNewsPage.clickAddItemButton();
        app.getPages().adminCreateNewsPage.fillAllFieldsWithData(news);
        app.getPages().adminCreateNewsPage.pressCancelButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("eng");
        app.getNavigationHelper().gotoNewsPage();
        app.getPages().newsPage.checkNewsDoesntExist(news);
        app.getPages().internalPage.setLanguage("rus");
        app.getNavigationHelper().gotoNewsPage();
        app.getPages().newsPage.checkNewsDoesntExist(news);
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
