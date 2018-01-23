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

    @Test
    public void addNewNewsItem() {
        log.info("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User admin = TESTADMIN;
        News news = TESTNEWS;
        String language = app.getUserHelper().getLanguage();
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("News");
        app.getPages().adminNewsPage.clickAddItemButton();
        app.getPages().adminCreateNewsPage.fillAllFieldsWithData(news);
        app.getPages().adminCreateMenuItemPage.pressSubmitButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getNavigationHelper().gotoNewsPage();
        app.getPages().newsPage.clickNews(news);
        app.getPages().newsItemPage.checkDataOnNewsItemPage(news, "rus");
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().newsItemPage.checkDataOnNewsItemPage(news, "eng");
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("News");
        app.getPages().adminPagesPage.deleteItem(news.getRusTitle(), "Title");
        app.getPages().adminPagesPage.deleteItem(news.getTitle(), "Title");
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");

    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
