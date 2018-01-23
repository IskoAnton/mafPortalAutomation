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

    @Test
    public void addNewTournament() {
        log.info("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User admin = TESTADMIN;
        Tournament tournament = TESTTOURNAMENT;
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Tournaments");
        app.getPages().adminTournamentsPage.clickAddItemButton();
        app.getPages().adminCreateTournamentsPage.fillAllFieldsWithData(tournament);
        app.getPages().adminCreateMenuItemPage.pressSubmitButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getNavigationHelper().gotoTournamentsPage();
        app.getPages().tournamentsPage.clickOnTournament(tournament);
        app.getPages().tournamentItemPage.checkDataOnTournmentItemPage(tournament, "rus");
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().tournamentItemPage.checkDataOnTournmentItemPage(tournament, "eng");
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Tournaments");
        app.getPages().adminPagesPage.deleteItem(tournament.getRusTitle(), "Title");
        app.getPages().adminPagesPage.deleteItem(tournament.getTitle(), "Title");
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
