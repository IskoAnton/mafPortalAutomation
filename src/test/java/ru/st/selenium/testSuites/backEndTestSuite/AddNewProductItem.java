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

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AddNewProductItem extends TestBase {
    public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AccountEntryTest.class.getName());
    User admin = TESTADMIN;
    Product product = TESTPRODUCT;
    Product editProduct = EDITPRODUCT;
    Product blankProduct = BLANKPRODUCT;

    @Test
    public void T001_addNewProduct() {
        log.info("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
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
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T002_editProduct() throws InterruptedException {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Shop");
        app.getPages().adminInternalPage.clickOnAdminTab("Products");
        app.getPages().adminProductsPage.clickEditItem(product.getTitle());
        app.getPages().adminCreateProductPage.fillAllFieldsWithData(editProduct);
        app.getPages().adminCreateProductPage.pressSubmitButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getNavigationHelper().gotoShopPage();
        app.getPages().shopPage.checkDataOfProduct(editProduct);
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().shopPage.checkDataOfProduct(editProduct);
        app.getNavigationHelper().gotoAdminPage();
        app.getPages().adminInternalPage.clickOnAdminTab("Shop");
        app.getPages().adminInternalPage.clickOnAdminTab("Products");
        app.getPages().adminPagesPage.deleteItem(editProduct.getTitle());
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }



    @Test
    public void T003_addBlankProduct() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Shop");
        app.getPages().adminInternalPage.clickOnAdminTab("Products");
        app.getPages().adminPhotoPage.clickAddItemButton();
        app.getPages().adminCreateProductPage.fillAllFieldsWithData(blankProduct);
        app.getPages().adminCreateProductPage.pressSubmitButton();
        app.getPages().adminCreateProductPage.checkRequiredFieldsMessages();
        app.getNavigationHelper().gotoAdminPage();
        app.getAdminUserHelper().logout();
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @Test
    public void T004_cancelAddingNewProduct() {
        log("--------Starting \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
        app.getAdminUserHelper().logindAs(admin);
        app.getPages().adminInternalPage.clickOnAdminTab("Shop");
        app.getPages().adminInternalPage.clickOnAdminTab("Products");
        app.getPages().adminProductsPage.clickAddItemButton();
        app.getPages().adminCreateProductPage.fillAllFieldsWithData(product);
        app.getPages().adminCreatePhotoGalleryPage.pressCancelButton();
        app.getPages().adminInternalPage.clickLogo();
        app.getPages().internalPage.setLanguage("rus");
        app.getNavigationHelper().gotoShopPage();
        app.getPages().shopPage.checkProductDoesntExist(product);
        app.getPages().internalPage.setLanguage("eng");
        app.getPages().shopPage.checkProductDoesntExist(product);
        log("--------Finishing \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" test---------");
    }

    @AfterMethod
    public void saveScreenshot(ITestResult testResult) throws IOException {
        app.takeScreenShotOnFailure(testResult, this.getClass().getSimpleName());
    }
}
