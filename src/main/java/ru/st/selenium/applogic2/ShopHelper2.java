package ru.st.selenium.applogic2;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.applogic.ShopHelper;
import ru.st.selenium.model.User;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShopHelper2 extends DriverBasedHelper implements ShopHelper {

    public final Logger log = Logger.getLogger(this.getClass().getSimpleName());

    public ShopHelper2(ApplicationManager2 manager) {
        super(manager.getWebDriver());
    }

    List<String> namesOfItem = null;

    @Override
    public void buyItemOnShopPage(String nameOfItem) throws InterruptedException {
        pages.internalPage.clickShopButton();
        //namesOfItem.add(pages.shopPage.getNameOfItem(numberOfItem));
        pages.shopPage.buyItem(nameOfItem);
        pages.shopPage.clickContinueShopingButton();
    }

    @Override
    public void checkItemInCart(String nameOfItem) {
        pages.internalPage.clickCartButton();
        assertTrue(pages.cartPage.isItemInCart(nameOfItem));
    }

    @Override
    public void removeItemFromCart(String nameOfItem) {
        pages.internalPage.clickCartButton();
        pages.cartPage.removeItemFromCart(nameOfItem);
    }

    @Override
    public void buyItemsInCart(User user) {
        pages.cartPage.fillShippingAddress(user);
        String amountInTable = pages.cartPage.getFullAmountOfItemsInTable();
        String amountOnButton = pages.cartPage.getAmountOnPayTheOrderButton();
        assertEquals(amountInTable, amountOnButton);
        pages.cartPage.clickPayTheOrder();
        pages.payPalLoginPage.typeEmailToEmailField(user.getLogin());
        pages.payPalLoginPage.typePasswordToPasswordField(user.getPassword());
        pages.payPalLoginPage.clickLoginButton();
        String amountOnPayPalPurchasePage = pages.payPalPurchasePage.getAmountOfPurchase();
        assertEquals(amountOnPayPalPurchasePage, amountOnButton);
        pages.payPalPurchasePage.clickContinueButton();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Thanks for your order!')]")));
    }


}