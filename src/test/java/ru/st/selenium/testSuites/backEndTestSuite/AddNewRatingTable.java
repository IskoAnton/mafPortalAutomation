package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.RatingTable;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;

import java.io.IOException;

public class AddNewRatingTable extends TestBase {
    public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AddNewRatingTable.class.getName());
    User admin = TESTADMIN;
    RatingTable ratingTable = TESTRATINGTABLE;
    RatingTable editRatingTable = EDITRATINGTABLE;

    @Test
    public void T001_addNewRatingTable() {
        log.info("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Ratings");
        app.getPages().adminInternalPage.clickOnAdminTab("Rating tables");
        app.getPages().adminRatingTablesPage.clickAddItemButton();
        app.getPages().adminCreateRatingTablesPage.fillAllFieldsWithData(ratingTable);
        app.getPages().adminCreateRatingTablesPage.pressSubmitButton();
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminClubsPage.clickAddItemButton();
        app.getPages().adminCreateClubPage.checkRatingTableExists(ratingTable);
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T002_editRatingTable() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Ratings");
        app.getPages().adminInternalPage.clickOnAdminTab("Rating tables");
        app.getPages().adminRatingTablesPage.clickEditItem(ratingTable.getTitle());
        app.getPages().adminCreateRatingTablesPage.fillAllFieldsWithData(editRatingTable);
        app.getPages().adminCreateRatingTablesPage.pressSubmitButton();
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminClubsPage.clickAddItemButton();
        app.getPages().adminCreateClubPage.checkRatingTableExists(editRatingTable);
        app.getPages().adminCreateClubPage.checkRatingTableDoesntExists(ratingTable);
        app.getPages().adminInternalPage.clickOnAdminTab("Ratings");
        app.getPages().adminInternalPage.clickOnAdminTab("Rating tables");
        app.getPages().adminPagesPage.deleteItem(editRatingTable.getTitle());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T003_addRatingTable() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Ratings");
        app.getPages().adminInternalPage.clickOnAdminTab("Rating tables");
        app.getPages().adminRatingTablesPage.clickAddItemButton();
        app.getPages().adminCreateRatingTablesPage.pressSubmitButton();
        app.getPages().adminCreateRatingTablesPage.checkRequiredFieldsMessages();
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T004_cancelAddingRatingTable() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Ratings");
        app.getPages().adminInternalPage.clickOnAdminTab("Rating tables");
        app.getPages().adminRatingTablesPage.clickAddItemButton();
        app.getPages().adminCreateRatingTablesPage.fillAllFieldsWithData(ratingTable);
        app.getPages().adminCreateRatingTablesPage.pressCancelButton();
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminClubsPage.clickAddItemButton();
        app.getPages().adminCreateClubPage.checkRatingTableDoesntExists(ratingTable);
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
