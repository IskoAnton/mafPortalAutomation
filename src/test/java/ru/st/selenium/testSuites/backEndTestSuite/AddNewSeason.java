package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.annotations.Test;
import ru.st.selenium.model.Season;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;

import static org.testng.Assert.assertFalse;

public class AddNewSeason extends TestBase{
    public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AddNewGameResults.class.getName());
    User admin = TESTADMIN;
    Season season = TESTSEASON;
    Season editSeason = EDITSEASON;

    @Test
    public void T001_addNewSeason() {
        log.info("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Ratings");
        app.getPages().adminInternalPage.clickOnAdminTab("Seasons");
        app.getPages().adminSeasonsPage.clickAddItemButton();
        app.getPages().adminCreateSeasonPage.fillAllFieldsWithData(season);
        app.getPages().adminCreateSeasonPage.pressSubmitButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getNavigationHelper().gotoClubsPage();
        app.getPages().clubsPage.clickToClub(season.getClub());
        app.getPages().clubItemPage.clickRatingTab();
        app.getPages().ratingPage.checkSeasonExists(season);
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T002_editSeason() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Ratings");
        app.getPages().adminInternalPage.clickOnAdminTab("Seasons");
        app.getPages().adminSeasonsPage.clickEditItem(season.getTitle());
        app.getPages().adminCreateSeasonPage.fillAllFieldsWithData(editSeason);
        app.getPages().adminCreateSeasonPage.pressSubmitButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getNavigationHelper().gotoClubsPage();
        app.getPages().clubsPage.clickToClub(editSeason.getClub());
        app.getPages().clubItemPage.clickRatingTab();
        app.getPages().ratingPage.checkSeasonExists(editSeason);
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Ratings");
        app.getPages().adminInternalPage.clickOnAdminTab("Seasons");
        app.getPages().adminPagesPage.deleteItem(editSeason.getTitle());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T003_addSeason() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Ratings");
        app.getPages().adminInternalPage.clickOnAdminTab("Seasons");
        app.getPages().adminSeasonsPage.clickAddItemButton();
        app.getPages().adminCreateSeasonPage.pressSubmitButton();
        app.getPages().adminCreateSeasonPage.checkRequiredFieldsMessages();
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T004_cancelAddingSeason() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Ratings");
        app.getPages().adminInternalPage.clickOnAdminTab("Seasons");
        app.getPages().adminSeasonsPage.clickAddItemButton();
        app.getPages().adminCreateSeasonPage.fillAllFieldsWithData(season);
        app.getPages().adminCreateSeasonPage.pressCancelButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getNavigationHelper().gotoClubsPage();
        app.getPages().clubsPage.clickToClub(season.getClub());
        app.getPages().clubItemPage.clickRatingTab();
        app.getPages().ratingPage.checkSeasonDoesntExists(season);
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }
}
