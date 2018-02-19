package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.News;
import ru.st.selenium.model.Tournament;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;

import java.io.IOException;

public class AddNewTournamentItem extends TestBase {
    public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AccountEntryTest.class.getName());
    User admin = TESTADMIN;
    Tournament tournament = TESTTOURNAMENT;
    Tournament editTournament = EDITTOURNAMENT;
    Tournament blankTournament = BLANKTOURNAMENT;

    @Test
    public void T001_addNewTournament() {
        log.info("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Tournaments");
        app.getPages().adminTournamentsPage.clickAddItemButton();
        app.getPages().adminCreateTournamentsPage.fillAllFieldsWithData(tournament);
        app.getPages().adminCreateMenuItemPage.pressSubmitButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getNavigationHelper().gotoTournamentsPage();
        app.getPages().tournamentsPage.clickOnTournament(tournament);
        app.getPages().tournamentItemPage.checkDataOnTournmentItemPage(tournament);
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().tournamentItemPage.checkDataOnTournmentItemPage(tournament);
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T002_editTournament() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Tournaments");
        app.getPages().adminTestimonialsPage.clickEditItem(tournament.getTitle(), tournament.getRusTitle());
        app.getPages().adminCreateTournamentsPage.fillAllFieldsWithData(editTournament);
        app.getPages().adminCreateTournamentsPage.pressSubmitButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getNavigationHelper().gotoTournamentsPage();
        app.getPages().tournamentsPage.clickOnTournament(editTournament);
        app.getPages().tournamentItemPage.checkDataOnTournmentItemPage(editTournament);
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().tournamentItemPage.checkDataOnTournmentItemPage(editTournament);
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Tournaments");
        app.getPages().adminPagesPage.deleteItem(editTournament.getTitle(), editTournament.getRusTitle());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T003_addBlankTournament() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Tournaments");
        app.getPages().adminTournamentsPage.clickAddItemButton();
        app.getPages().adminCreateTournamentsPage.fillAllFieldsWithData(blankTournament);
        app.getPages().adminCreateTournamentsPage.pressSubmitButton();
        app.getPages().adminCreateTournamentsPage.checkRequiredFieldsMessages();
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T004_cancelAddingNewTournament() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Tournaments");
        app.getPages().adminTournamentsPage.clickAddItemButton();
        app.getPages().adminCreateTournamentsPage.fillAllFieldsWithData(tournament);
        app.getPages().adminCreateTournamentsPage.pressCancelButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getNavigationHelper().gotoTournamentsPage();
        app.getPages().tournamentItemPage.checkTournamentDoesntExist(tournament);
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().tournamentItemPage.checkTournamentDoesntExist(tournament);
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
