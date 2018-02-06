package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;

import java.io.File;
import java.io.IOException;

public class UploadingPhoto extends TestBase {
    public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AccountEntryTest.class.getName());

    @Test
    public void adminAccountEntryWithExistingUser() {
        log.info("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User testadmin = TESTADMIN;
        String imageDirectory = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "uploads" + File.separator + "test.png";
        app.getAdminUserHelper().logindAs(testadmin);
        app.getPages().adminInternalPage.clickOnAdminTab("Gallery");
        app.getPages().adminInternalPage.clickOnAdminTab("Photo");
        app.getPages().adminPhotoPage.clickAddItemButton();
        app.getPages().adminCreatePhotoGalleryPage.addFile(imageDirectory);
        app.getPages().adminCreatePhotoGalleryPage.ensureFileAdded();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");

    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
