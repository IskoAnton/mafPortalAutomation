package ru.st.selenium.testSuites.backEndTestSuite;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.Event;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;

import java.io.IOException;
import java.util.ArrayList;

public class AddNewEvent extends TestBase{
    public static final Logger log = Logger.getLogger(AccountEntryTest.class.getName());
    User admin = TESTADMIN;
    Event event = TESTEVENT;
    Event editEvent = TESTEDITEVENT;
    Event blankEvent = BLANKEVENT;

    @Test
    public void T001_addNewEvent() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminInternalPage.clickOnAdminTab("Events");
        app.getPages().adminEventPage.clickAddItemButton();
        app.getPages().adminCreateEventPage.fillAllFieldsWithData(event);
        app.getPages().adminCreateEventPage.pressSubmitButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getPages().internalPage.setLanguage("eng");
        ArrayList<String> clubs = app.getPages().adminCreateEventPage.getChosenCheckboxes();
        for (int i = 0; i < clubs.size(); i++) {
            app.getNavigationHelper().gotoClubsPage();
            app.getPages().clubsPage.clickToClub(clubs.get(i));
            app.getPages().clubItemPage.clickEventsTab();
            app.getPages().eventItemPage.checkDataOfEvent(event);
       }
        app.getPages().internalPage.setLanguage("rus");
        for (int i = 0; i < clubs.size(); i++) {
            app.getNavigationHelper().gotoClubsPage();
            app.getPages().clubsPage.clickToClub(clubs.get(i));
            app.getPages().clubItemPage.clickEventsTab();
            app.getPages().eventItemPage.checkDataOfEvent(event);

        }
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T002_editEvent() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminInternalPage.clickOnAdminTab("Events");
        app.getPages().adminEventPage.clickEditItem(event.getTitle(), event.getRusTitle());
        app.getPages().adminCreateEventPage.fillAllFieldsWithData(editEvent);
        app.getPages().adminCreateEventPage.pressSubmitButton();
        app.getPages().adminMenuPage.clickLogo();
        ArrayList<String> clubs = app.getPages().adminCreateEventPage.getChosenCheckboxes();
        app.getPages().internalPage.setLanguage("eng");
        for (int i = 0; i < clubs.size(); i++) {
            app.getNavigationHelper().gotoClubsPage();
            app.getPages().clubsPage.clickToClub(clubs.get(i));
            app.getPages().clubItemPage.clickEventsTab();
            app.getPages().eventItemPage.checkDataOfEvent(editEvent);
        }
        app.getPages().internalPage.setLanguage("rus");
        for (int i = 0; i < clubs.size(); i++) {
            app.getNavigationHelper().gotoClubsPage();
            app.getPages().clubsPage.clickToClub(clubs.get(i));
            app.getPages().clubItemPage.clickEventsTab();
            app.getPages().eventItemPage.checkDataOfEvent(editEvent);
        }
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminInternalPage.clickOnAdminTab("Events");
        app.getPages().adminPagesPage.deleteItem(editEvent.getTitle(), editEvent.getRusTitle());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T003_addBlankEvent() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminInternalPage.clickOnAdminTab("Events");
        app.getPages().adminEventPage.clickAddItemButton();
        app.getPages().adminCreateEventPage.fillAllFieldsWithData(blankEvent);
        app.getPages().adminCreateEventPage.pressSubmitButton();
        app.getPages().adminCreateEventPage.checkRequiredFieldsMessages();
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T004_cancelAddingNewEvent() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminInternalPage.clickOnAdminTab("Events");
        app.getPages().adminEventPage.clickAddItemButton();
        app.getPages().adminCreateEventPage.fillAllFieldsWithData(event);
        app.getPages().adminCreateEventPage.pressCancelButton();
        app.getPages().adminMenuPage.clickLogo();
        ArrayList<String> clubs = app.getPages().adminCreateEventPage.getChosenCheckboxes();
        app.getPages().internalPage.setLanguage("eng");
        for (int i = 0; i < clubs.size(); i++) {
            app.getNavigationHelper().gotoClubsPage();
            app.getPages().clubsPage.clickToClub(clubs.get(i));
            app.getPages().clubItemPage.clickEventsTab();
            app.getPages().eventItemPage.checkEventDoesntExist(event);
        }
        app.getPages().internalPage.setLanguage("rus");
        for (int i = 0; i < clubs.size(); i++) {
            app.getNavigationHelper().gotoClubsPage();
            app.getPages().clubsPage.clickToClub(clubs.get(i));
            app.getPages().clubItemPage.clickEventsTab();
            app.getPages().eventItemPage.checkEventDoesntExist(event);
        }
        app.getUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}

