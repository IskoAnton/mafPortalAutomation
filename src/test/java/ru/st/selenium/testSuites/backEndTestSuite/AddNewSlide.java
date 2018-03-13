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

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AddNewSlide extends TestBase {
    public static final Logger log = Logger.getLogger(AccountEntryTest.class.getName());
    User admin = TESTADMIN;
    Slide slide = TESTSLIDE;
    Slide editSlide = EDITSLIDE;
    Slide blankSlide = BLANKSLIDE;

    @Test
    public void T001_addNewSlide() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");

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
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T002_editSlide() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Slides");
        app.getPages().adminSlidePage.clickEditItem(slide.getTitle(), slide.getRusTitle());
        app.getPages().adminCreateSlidePage.fillAllFieldsWithData(editSlide);
        app.getPages().adminCreateSlidePage.pressSubmitButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getPages().homePage.checkDataOnSlide(editSlide);
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().homePage.checkDataOnSlide(editSlide);
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Slides");
        app.getPages().adminSlidePage.deleteItem(slide.getTitle(), slide.getRusTitle());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }



    /*@Test
    public void T003_addBlankSlide() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Slides");
        app.getPages().adminSlidePage.clickAddItemButton();
        app.getPages().adminCreateSlidePage.fillAllFieldsWithData(blankSlide);
        app.getPages().adminCreateSlidePage.pressSubmitButton();
        app.getPages().adminCreateSlidePage.checkRequiredFieldsMessages();
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }*/

    @Test
    public void T004_cancelAddingNewSlide() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Slides");
        app.getPages().adminSlidePage.clickAddItemButton();
        app.getPages().adminCreateSlidePage.fillAllFieldsWithData(slide);
        app.getPages().adminCreateSlidePage.pressCancelButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getPages().homePage.checkSlideDoesntExist(slide);
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().homePage.checkSlideDoesntExist(slide);
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
