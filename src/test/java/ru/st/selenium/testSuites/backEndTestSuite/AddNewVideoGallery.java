package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.PhotoGallery;
import ru.st.selenium.model.User;
import ru.st.selenium.model.VideoGallery;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;

import java.io.IOException;

public class AddNewVideoGallery extends TestBase {
    public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AccountEntryTest.class.getName());

    @Test
    public void addNewVideoGallery() {
        log.info("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User admin = TESTADMIN;
        VideoGallery videoGallery = TESTVIDEOGALLERY;
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Gallery");
        app.getPages().adminInternalPage.clickOnAdminTab("Video");
        app.getPages().adminVideoGalleryPage.clickAddItemButton();
        app.getPages().adminCreateVideoGalleryPage.fillAllFieldsWithData(videoGallery);
        app.getPages().adminCreatePhotoGalleryPage.pressSubmitButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getNavigationHelper().gotoGalleryPage();
        app.getPages().galleryPage.clickVideoTab();
        app.getPages().galleryPage.clickVideoGallery(videoGallery);
        app.getNavigationHelper().gotoHomePage();
        app.getPages().internalPage.setLanguage("eng");
        app.getNavigationHelper().gotoGalleryPage();
        app.getPages().galleryPage.clickVideoTab();
        app.getPages().galleryPage.clickVideoGallery(videoGallery);
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Gallery");
        app.getPages().adminInternalPage.clickOnAdminTab("Video");
        app.getPages().adminVideoGalleryPage.deleteItem(videoGallery.getTitle(), videoGallery.getRusTitle());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
