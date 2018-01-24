package ru.st.selenium.testSuites.frontEndTestSuite;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ru.st.selenium.model.User;
import java.io.IOException;
import static org.testng.AssertJUnit.assertTrue;

public class AllPagesAreLoadingTest extends ru.st.selenium.pages.TestBase {
    public static final Logger log = Logger.getLogger(ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest.class.getName());

    @Test
    public void allPagesAreLoadingTest() throws Exception {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
//        app.getPages().internalPage.ensurePageLoaded();
        //app.getPages().internalPage.setLanguage("ru");
        app.getPages().internalPage.clickClubsButton();
        app.getPages().clubsPage.ensurePageLoaded();

        app.getPages().internalPage.clickTheGameButton();
        app.getPages().theGamePage.ensurePageLoaded();

        app.getPages().internalPage.clickNewsButton();
        app.getPages().newsPage.ensurePageLoaded();

        app.getPages().internalPage.clickTournamentsButton();
        app.getPages().tournamentsPage.ensurePageLoaded();

        app.getPages().internalPage.clickHistoryButton();
        app.getPages().historyPage.ensurePageLoaded();

        app.getPages().internalPage.clickGalleryButton();
        app.getPages().galleryPage.ensurePageLoaded();

        app.getPages().internalPage.clickShopButton();
        app.getPages().shopPage.ensurePageLoaded();

        app.getPages().internalPage.clickLoginButton();
        app.getPages().loginPage.ensurePageLoaded();
        app.getPages().loginPage.closeLoginDialog();

        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }


    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
