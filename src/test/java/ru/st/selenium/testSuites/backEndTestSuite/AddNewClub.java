package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.st.selenium.model.Club;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;

import java.io.IOException;
import java.util.logging.Logger;

public class AddNewClub extends TestBase {
    public static final Logger log = Logger.getLogger(AccountEntryTest.class.getName());
    User admin = TESTADMIN;
    Club club = TESTCLUB;
    Club editClub = TESTEDITCLUB;
    Club blankClub = BLANKCLUB;


    @Test
    public void T001_addNewClub() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminClubsPage.clickAddItemButton();
        app.getPages().adminCreateClubPage.fillAllFieldsWithData(club);
        app.getPages().adminCreateClubPage.pressSubmitButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getNavigationHelper().gotoClubsPage();
        app.getPages().clubsPage.checkClubCountry(club);
        app.getPages().clubsPage.clickToClub(club);
        app.getPages().clubItemPage.checkDataOnClubItemPage(club);
        app.getNavigationHelper().gotoClubsPage();
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().clubsPage.checkClubCountry(club);
        app.getPages().clubsPage.clickToClub(club);
        app.getPages().clubItemPage.checkDataOnClubItemPage(club);
        app.getUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T002_editClub() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminClubsPage.clickEditItem(club.getTitle());
        app.getPages().adminCreateClubPage.fillAllFieldsWithData(editClub);
        app.getPages().adminCreateClubPage.pressSubmitButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getNavigationHelper().gotoClubsPage();
        app.getPages().clubsPage.checkClubCountry(editClub);
        app.getPages().clubsPage.clickToClub(editClub);
        app.getPages().clubItemPage.checkDataOnClubItemPage(editClub);
        app.getPages().internalPage.setLanguage("eng");
        app.getNavigationHelper().gotoClubsPage();
        app.getPages().clubsPage.checkClubCountry(editClub);
        app.getPages().clubsPage.clickToClub(editClub);
        app.getPages().clubItemPage.checkDataOnClubItemPage(editClub);
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T003_removeClub() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminPagesPage.deleteItem(club.getTitle());
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T004_addBlankClub() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminClubsPage.clickAddItemButton();
        app.getPages().adminCreateClubPage.fillAllFieldsWithData(blankClub);
        app.getPages().adminCreateClubPage.pressSubmitButton();
        app.getPages().adminCreateClubPage.checkRequiredFieldsMessages();
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T005_cancelAddingNewClub() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminClubsPage.clickAddItemButton();
        app.getPages().adminCreateClubPage.fillAllFieldsWithData(club);
        app.getPages().adminCreateClubPage.pressCancelButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getNavigationHelper().gotoClubsPage();
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().clubsPage.checkClubDoesntExist(club);
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
