package ru.st.selenium.applogic2;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import ru.st.selenium.applogic.ShopHelper;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class ShopHelper2 extends DriverBasedHelper implements ShopHelper {

    public final Logger log = Logger.getLogger(this.getClass().getSimpleName());

    public ShopHelper2(ApplicationManager2 manager) {
        super(manager.getWebDriver());
    }

    List<String> namesOfItem = null;

    @Override
    public void buyItem(String nameOfItem) throws InterruptedException {
        pages.internalPage.clickShopButton();
        //namesOfItem.add(pages.shopPage.getNameOfItem(numberOfItem));
        pages.shopPage.buyItem(nameOfItem);
        pages.shopPage.clickContinueShopingButton();
    }

    public void checkItemInCart(String nameOfItem) {
        pages.internalPage.clickCartButton();
        assertTrue(pages.cartPage.isItemInCart(nameOfItem));
    }

    public void removeItemFromCart(String nameOfItem) {
        pages.internalPage.clickCartButton();
        pages.cartPage.removeItemFromCart(nameOfItem);
    }
}