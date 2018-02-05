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
    User admin = TESTADMIN;
    Partner partner = TESTPARTNER;
    Partner editPartner = TESTEDITPARTNER;
    Partner blankPartner = BLANKPARTNER;

    @Test
    public void T001_addNewPartner() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Our Partners");
        app.getPages().adminPartnerPage.clickAddItemButton();
        app.getPages().adminCreatePartnerPage.fillAllFieldsWithData(partner);
        app.getPages().adminCreatePartnerPage.pressSubmitButton();
        app.getNavigationHelper().gotoHomePage();
        app.getPages().homePage.checkDataOfPartners(partner);
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T002_editPartner() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Our Partners");
        app.getPages().adminPartnerPage.clickEditItem(partner.getName());
        app.getPages().adminCreatePartnerPage.fillAllFieldsWithData(editPartner);
        app.getPages().adminCreateNewsPage.pressSubmitButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().homePage.checkDataOfPartners(editPartner);
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Our Partners");
        app.getPages().adminCountiesPage.deleteItem(editPartner.getName());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T003_addBlankPartner() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Our Partners");
        app.getPages().adminPartnerPage.clickAddItemButton();
        app.getPages().adminCreatePartnerPage.fillAllFieldsWithData(blankPartner);
        app.getPages().adminCreatePartnerPage.pressSubmitButton();
        app.getPages().adminCreatePartnerPage.checkRequiredFieldsMessages();
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T004_cancelAddingNewPartner() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Home page");
        app.getPages().adminInternalPage.clickOnAdminTab("Our Partners");
        app.getPages().adminPartnerPage.clickAddItemButton();
        app.getPages().adminCreatePartnerPage.fillAllFieldsWithData(partner);
        app.getPages().adminCreatePartnerPage.pressCancelButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().homePage.checkPartnerDoesntExist(partner);
        app.getPages().internalPage.setLanguage("rus");
        app.getPages().homePage.checkPartnerDoesntExist(partner);
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
