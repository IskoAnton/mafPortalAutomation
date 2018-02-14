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

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AddNewPhotoGallery extends TestBase {
    public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AccountEntryTest.class.getName());
    User admin = TESTADMIN;
    PhotoGallery photoGallery = TESTPHOTOGALLERY;
    PhotoGallery editPhotoGallery = EDITPHOTOGALLERY;
    PhotoGallery blankPhotoGallery = BLANKPHOTOGALLERY;

    @Test
    public void T001_addNewPhotoGallery() {
        log.info("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Gallery");
        app.getPages().adminInternalPage.clickOnAdminTab("Photo");
        app.getPages().adminPhotoPage.clickAddItemButton();
        app.getPages().adminCreatePhotoGalleryPage.fillAllFieldsWithData(photoGallery);
        assertTrue(app.getPages().adminCreatePhotoGalleryPage.isAddGalleryFirstMessagePresent());
        assertFalse(app.getPages().adminCreatePhotoGalleryPage.isFileContainerPresent());
        app.getPages().adminCreatePhotoGalleryPage.pressSubmitButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getNavigationHelper().gotoGalleryPage();
        app.getPages().galleryPage.clickPhotoGallery(photoGallery);
        app.getPages().photoGalleryItemPage.checkDataOfPhotoGallery(photoGallery);
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().photoGalleryItemPage.checkDataOfPhotoGallery(photoGallery);
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T002_editPhotoGallery() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Gallery");
        app.getPages().adminInternalPage.clickOnAdminTab("Photo");
        app.getPages().adminPhotoPage.clickEditItem(photoGallery.getTitle(), photoGallery.getRusTitle());
        app.getPages().adminCreatePhotoGalleryPage.fillAllFieldsWithData(editPhotoGallery);
        assertFalse(app.getPages().adminCreatePhotoGalleryPage.isAddGalleryFirstMessagePresent());
        assertTrue(app.getPages().adminCreatePhotoGalleryPage.isFileContainerPresent());
        app.getPages().adminCreatePhotoGalleryPage.pressSubmitButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getNavigationHelper().gotoGalleryPage();
        app.getPages().galleryPage.clickPhotoGallery(editPhotoGallery);
        app.getPages().photoGalleryItemPage.checkDataOfPhotoGallery(editPhotoGallery);
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().photoGalleryItemPage.checkDataOfPhotoGallery(editPhotoGallery);
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Gallery");
        app.getPages().adminInternalPage.clickOnAdminTab("Photo");
        app.getPages().adminPagesPage.deleteItem(editPhotoGallery.getTitle(), editPhotoGallery.getRusTitle());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }



    @Test
    public void T003_addBlankPhotoGallery() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Gallery");
        app.getPages().adminInternalPage.clickOnAdminTab("Photo");
        app.getPages().adminPhotoPage.clickAddItemButton();
        app.getPages().adminCreatePhotoGalleryPage.fillAllFieldsWithData(blankPhotoGallery);
        app.getPages().adminCreatePhotoGalleryPage.pressSubmitButton();
        app.getPages().adminCreatePhotoGalleryPage.checkRequiredFieldsMessages();
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T004_cancelAddingNewPhotoGallery() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Gallery");
        app.getPages().adminInternalPage.clickOnAdminTab("Photo");
        app.getPages().adminPhotoPage.clickAddItemButton();
        app.getPages().adminCreatePhotoGalleryPage.fillAllFieldsWithData(photoGallery);
        assertTrue(app.getPages().adminCreatePhotoGalleryPage.isAddGalleryFirstMessagePresent());
        assertFalse(app.getPages().adminCreatePhotoGalleryPage.isFileContainerPresent());
        app.getPages().adminCreatePhotoGalleryPage.pressCancelButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getNavigationHelper().gotoGalleryPage();
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().galleryPage.checkPhotoGalleryDoesntExist(photoGallery);
        app.getPages().internalPage.setLanguage("rus");
        app.getPages().galleryPage.checkPhotoGalleryDoesntExist(photoGallery);
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }


    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
