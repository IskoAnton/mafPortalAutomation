package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.PhotoGallery;
import ru.st.selenium.model.Tournament;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;

import java.io.IOException;

public class AddNewPhotoGallery extends TestBase {
    public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AccountEntryTest.class.getName());

    @Test
    public void addNewPhotoGallery() {
        log.info("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User admin = TESTADMIN;
        PhotoGallery photoGallery = TESTPHOTOGALLERY;
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Gallery");
        app.getPages().adminInternalPage.clickOnAdminTab("Photo");
        app.getPages().adminPhotoPage.clickAddItemButton();
        app.getPages().adminCreatePhotoGalleryPage.fillAllFieldsWithData(photoGallery);
        app.getPages().adminCreatePhotoGalleryPage.pressSubmitButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getNavigationHelper().gotoGalleryPage();
        app.getPages().galleryPage.clickPhotoGallery(photoGallery);
        app.getPages().photoGalleryItemPage.checkDataOfPhotoGallery(photoGallery, "rus");
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().photoGalleryItemPage.checkDataOfPhotoGallery(photoGallery, "eng");
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Gallery");
        app.getPages().adminInternalPage.clickOnAdminTab("Photo");
        app.getPages().adminPagesPage.deleteItem(photoGallery.getRusTitle(), "Title");
        app.getPages().adminPagesPage.deleteItem(photoGallery.getTitle(), "Title");
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");

    }


    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
