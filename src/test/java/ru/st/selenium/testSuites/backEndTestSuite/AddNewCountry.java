package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.Country;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;

import java.io.IOException;
import java.util.logging.Logger;

public class AddNewCountry extends TestBase {
        public static final Logger log = Logger.getLogger(AccountEntryTest.class.getName());

        @Test
        public void addNewCountry() {
            log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
            User admin = TESTADMIN;
            Country country = TESTCOUNTRY;
            app.getAdminUserHelper().logindAs(admin);
            app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
            app.getPages().adminInternalPage.clickOnAdminTab("Countries");
            app.getPages().adminCountiesPage.clickAddItemButton();
            app.getPages().adminCreateCountryPage.fillAllFieldsWithData(country);
            app.getPages().adminCreateCountryPage.pressSubmitButton();
            app.getPages().adminMenuPage.clickLogo();
            app.getNavigationHelper().gotoClubsPage();
            app.getPages().internalPage.setLanguage("eng");
            app.getPages().clubsPage.checkCountryExists(country);
            app.getPages().internalPage.setLanguage("rus");
            app.getNavigationHelper().gotoAdminPage();
            app.getPages().adminInternalPage.clickOnAdminTab("Clubs");
            app.getPages().adminInternalPage.clickOnAdminTab("Countries");
            app.getPages().adminCountiesPage.deleteItem(country.getTitle(), country.getRusTitle());
            log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        }

        @AfterMethod
        public void saveScreenshot(ITestResult testResult) throws IOException {
            app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
        }
}
