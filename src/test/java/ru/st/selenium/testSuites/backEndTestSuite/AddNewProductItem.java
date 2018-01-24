package ru.st.selenium.testSuites.backEndTestSuite;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.Product;
import ru.st.selenium.model.Tournament;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;
import ru.st.selenium.testSuites.frontEndTestSuite.AccountEntryTest;

import java.io.IOException;

public class AddNewProductItem extends TestBase {
    public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AccountEntryTest.class.getName());
    @Test
    public void addNewProduct() {
        log.info("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        User admin = TESTADMIN;
        Product product = TESTPRODUCT;
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Shop");
        app.getPages().adminInternalPage.clickOnAdminTab("Products");
        app.getPages().adminProductsPage.clickAddItemButton();
        app.getPages().adminCreateProductPage.fillAllFieldsWithData(product);
        app.getPages().adminCreateMenuItemPage.pressSubmitButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getNavigationHelper().gotoShopPage();
        app.getPages().shopPage.checkDataOfProduct(product);
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().shopPage.checkDataOfProduct(product);
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Shop");
        app.getPages().adminInternalPage.clickOnAdminTab("Products");
        app.getPages().adminPagesPage.deleteItem(product.getTitle());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");

    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
