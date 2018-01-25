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

    @Test
    public void addNewEvent() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User admin = TESTADMIN;
        Event event = TESTEVENT;
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminInternalPage.clickOnAdminTab("Events");
        app.getPages().adminEventPage.clickAddItemButton();
        app.getPages().adminCreateEventPage.fillAllFieldsWithData(event);
        app.getPages().adminCreateEventPage.pressSubmitButton();
        app.getPages().adminMenuPage.clickLogo();
        ArrayList<String> clubs = app.getPages().adminCreateEventPage.getChosenCheckboxes();
        for (int i = 0; i < clubs.size(); i++) {
            app.getNavigationHelper().gotoClubsPage();
            app.getPages().clubsPage.clickToClub(clubs.get(i));
            app.getPages().clubItemPage.clickEventsTab();
            app.getPages().eventItemPage.checkDataOfEvent(event);
       }
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
        app.getPages().adminInternalPage.clickOnAdminTab("Events");
        app.getPages().adminPagesPage.deleteItem(event.getTitle(), event.getRusTitle());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}

