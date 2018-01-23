package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.Partner;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;
import java.io.IOException;
import java.util.logging.Logger;

public class AddNewPartner extends TestBase {
    public static final Logger log = Logger.getLogger(AccountEntryTest.class.getName());

    @Test
    public void addNewPartner() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User admin = TESTADMIN;
        Partner partner = TESTPARTNER;
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Our Partners");
        app.getPages().adminPartnerPage.clickAddItemButton();
        app.getPages().adminCreatePartnerPage.fillAllFieldsWithData(partner);
        app.getPages().adminCreatePartnerPage.pressSubmitButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().homePage.checkDataOfPartners(partner);
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Our Partners");
        app.getPages().adminCountiesPage.deleteItem(partner.getName(), "Name");

        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
