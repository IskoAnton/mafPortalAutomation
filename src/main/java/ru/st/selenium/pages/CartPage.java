package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class CartPage extends InternalPage {

    public CartPage(PageManager pages) {
            super(pages);
        }

    private final String  ITEMS_IN_CART_LOCATOR= "//div[@class = 'Rating_table']//tr[@class = 'animate_repeat ng-scope']";
    private final String  CART_PAGE_TITLE_LOCATOR= "//h1[@class = 'title_name' and (contains(text(), 'Cart') or contains(text(), 'Корзина'))]";


    @FindBy(xpath = ITEMS_IN_CART_LOCATOR)
    private List<WebElement> itemsInCart;



    public CartPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.xpath(CART_PAGE_TITLE_LOCATOR)));
        log("Cart page was loaded successfully");
        return this;
    }

    public boolean isItemInCart(String itemName) {
        try {
            driver.findElement(By.xpath("//th[@class = 'ng-binding' and contains(text(), '" + itemName + "')]"));
            log("Item " + itemName + " exist in the cart");
            return true;
        } catch (Exception e) {
            log("Item " + itemName + " doesn't exist in the cart");
            return false;
        }
    }

    public void removeItemFromCart(String itemName) {
        try {
            WebElement item = driver.findElement(By.xpath("//th[@class = 'ng-binding' and contains(text(), '" + itemName + "')]"));
            item.findElement(By.xpath("..//th[6]/a")).click();
            log("Item " + itemName + " was removed from the cart");
        } catch (Exception e) {
            log("Item " + itemName + " doesn't exist in the cart");

        }
    }


}
