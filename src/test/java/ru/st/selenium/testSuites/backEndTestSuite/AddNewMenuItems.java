package ru.st.selenium.testSuites.backEndTestSuite;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.MenuItem;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class AddNewMenuItems extends TestBase{
    public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AccountEntryTest.class.getName());

    @Test
    public void addNewMenuItem() {
        User admin = TESTADMIN;
        MenuItem menuItem = TESTMENUITEM;
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Menu");
        app.getPages().adminMenuPage.clickAddItemButton();
        app.getPages().adminCreateMenuItemPage.fillAllFieldsWithData(menuItem);
        app.getPages().adminCreateMenuItemPage.pressSubmitButton();
        app.getPages().adminMenuPage.clickLogo();
        app.getPages().internalPage.getWebDriver().findElement(By.xpath("//nav[@class = 'headMenu']//a[contains(text(),'"+menuItem.getLabel()+"') or contains(text(),'"+menuItem.getRusLabel()+"')]"));
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Menu");
        app.getPages().adminMenuPage.deleteItem(menuItem.getRusLabel(), "Russian label");
        app.getPages().adminMenuPage.deleteItem(menuItem.getLabel(), "Russian label");
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
