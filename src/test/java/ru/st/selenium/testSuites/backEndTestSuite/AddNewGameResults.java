package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.applogic2.ApplicationManager2;
import ru.st.selenium.model.GameResults;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;

import java.io.IOException;

import static org.testng.Assert.assertFalse;

public class AddNewGameResults extends TestBase {
    public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AddNewGameResults.class.getName());
    User admin = TESTADMIN;
    GameResults gameResults = TESTGAMERESULTS;
    GameResults editGameResults = EDITGAMERESULTS;

   @Test
    public void T001_addNewGameResults() {
        log.info("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Ratings");
        app.getPages().adminInternalPage.clickOnAdminTab("Game results");
        app.getPages().adminGameResultsPage.clickAddItemButton();
        app.getPages().adminCreateGameResultsPage.fillAllFieldsWithData(gameResults);
        app.getPages().adminCreateGameResultsPage.pressSubmitButton();
        app.getPages().adminGameResultsPage.clickEditItem(gameResults.getTitle());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T002_editGameResults() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Ratings");
        app.getPages().adminInternalPage.clickOnAdminTab("Game results");
        app.getPages().adminGameResultsPage.clickEditItem(gameResults.getTitle());
        app.getPages().adminCreateGameResultsPage.fillAllFieldsWithData(editGameResults);
        app.getPages().adminCreateGameResultsPage.pressSubmitButton();
        app.getPages().adminGameResultsPage.clickEditItem(editGameResults.getTitle());
        Thread.sleep(3000);
        //app.getPages().adminInternalPage.clickOnAdminTab("Ratings");
        app.getPages().adminInternalPage.clickOnAdminTab("Game results");
        app.getPages().adminGameResultsPage.deleteItem(editGameResults.getTitle());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T003_addGameResults() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Ratings");
        app.getPages().adminInternalPage.clickOnAdminTab("Game results");
        app.getPages().adminGameResultsPage.clickAddItemButton();
        app.getPages().adminCreateGameResultsPage.pressSubmitButton();
        app.getPages().adminCreateGameResultsPage.checkRequiredFieldsMessages();
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T004_cancelAddingGameResults() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Ratings");
        app.getPages().adminInternalPage.clickOnAdminTab("Game results");
        app.getPages().adminGameResultsPage.clickAddItemButton();
        app.getPages().adminCreateGameResultsPage.fillAllFieldsWithData(gameResults);
        app.getPages().adminCreateGameResultsPage.pressCancelButton();
        boolean isGameResultPresent = true;
        try {
            app.getPages().adminGameResultsPage.clickEditItem(gameResults.getTitle());
        } catch (Exception e) {
            isGameResultPresent = false;
        }
        assertFalse(isGameResultPresent);


        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
