package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.Role;
import ru.st.selenium.model.Slide;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;

import java.io.IOException;
import java.util.logging.Logger;

import static org.testng.Assert.assertTrue;

public class AddNewSlide extends TestBase {
    public static final Logger log = Logger.getLogger(AccountEntryTest.class.getName());

    @Test
    public void addNewSlide() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User admin = TESTADMIN;
        Slide slide = TESTSLIDE;
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Slides");
        app.getPages().adminSlidePage.clickAddItemButton();
        app.getPages().adminCreateSlidePage.fillAllFieldsWithData(slide);
        app.getPages().adminCreateSlidePage.pressSubmitButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getPages().homePage.checkDataOnSlide(slide);
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().homePage.checkDataOnSlide(slide);
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Slides");
        app.getPages().adminSlidePage.deleteItem(slide.getRusTitle(), "Title");
        app.getPages().adminSlidePage.deleteItem(slide.getTitle(), "Title");
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
