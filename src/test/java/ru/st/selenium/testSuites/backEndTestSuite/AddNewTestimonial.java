package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.Club;
import ru.st.selenium.model.Testimonial;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;

import java.io.IOException;
import java.util.logging.Logger;

public class AddNewTestimonial extends TestBase {
    public static final Logger log = Logger.getLogger(AccountEntryTest.class.getName());
    User admin = TESTADMIN;
    Testimonial testimonial = TESTTESTIMONIAL;
    Testimonial editTestimonial = EDITTESTIMONIAL;
    Testimonial blankTestimonial = BLANKTESTIMONIAL;

    @Test
    public void T001_addNewTestimonial() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Testimonials");
        app.getPages().adminTestimonialsPage.clickAddItemButton();
        app.getPages().adminCreateTestimonialPage.fillAllFieldsWithData(testimonial);
        app.getPages().adminCreateTestimonialPage.pressSubmitButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().homePage.checkDataOnTestimonial(testimonial);
        app.getPages().internalPage.setLanguage("rus");
        app.getPages().homePage.checkDataOnTestimonial(testimonial);
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T002_editTestimonial() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Testimonials");
        app.getPages().adminTestimonialsPage.clickEditItem(testimonial.getName());
        app.getPages().adminCreateTestimonialPage.fillAllFieldsWithData(editTestimonial);
        app.getPages().adminCreateTestimonialPage.pressSubmitButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().homePage.checkDataOnTestimonial(editTestimonial);
        app.getPages().internalPage.setLanguage("rus");
        app.getPages().homePage.checkDataOnTestimonial(editTestimonial);
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Testimonials");
        app.getPages().adminPagesPage.deleteItem(editTestimonial.getName(), "Name");
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T003_addBlankTestimonial() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Testimonials");
        app.getPages().adminTestimonialsPage.clickAddItemButton();
        app.getPages().adminCreateTestimonialPage.fillAllFieldsWithData(blankTestimonial);
        app.getPages().adminCreateTestimonialPage.pressSubmitButton();
        app.getPages().adminCreateTestimonialPage.checkRequiredFieldsMessages();
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T004_cancelAddingNewTestimonial() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Testimonials");
        app.getPages().adminTestimonialsPage.clickAddItemButton();
        app.getPages().adminCreateTestimonialPage.fillAllFieldsWithData(testimonial);
        app.getPages().adminCreateTestimonialPage.pressCancelButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().homePage.checkTestimonialDoesntExist(testimonial);
        app.getPages().internalPage.setLanguage("rus");
        app.getPages().homePage.checkTestimonialDoesntExist(testimonial);
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
