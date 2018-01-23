package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.st.selenium.model.Product;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import java.util.List;

public class ShopPage extends InternalPage {
    public ShopPage(PageManager pages) {
        super(pages);
    }
    private final String  SHOP_ITEM_LOCATOR= "//ul[@class = 'ProductList']/li";
    private final String  BUY_BUTTON_LOCATOR= "//a[@class = 'buy']";
    private final String  ITEM_TITLE_LOCATOR= "//a[@class = 'item_title']";
    private final String CONTINUE_SHOPPING_BUTTON_LOCATOR = "//div[contains(text(), 'Continue Shopping') or contains(text(), 'Продолжить покупки')]";
    private final String  SHOP_PAGE_TITLE_LOCATOR = "//h1[@class = 'title_name' and (contains(text(), 'Maf Shop') or contains(text(), 'Магазин'))]";


    @FindBy(xpath = SHOP_ITEM_LOCATOR)
    private List<WebElement> shopItemsList;

    @FindBy(xpath = BUY_BUTTON_LOCATOR)
    private WebElement buyButton;

    @FindBy(xpath = CONTINUE_SHOPPING_BUTTON_LOCATOR)
    private WebElement continueShoppingButton;


    public ShopPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.xpath(SHOP_PAGE_TITLE_LOCATOR)));
        log("Shop page was loaded successfully");
        return this;
    }

    public void buyItem(String nameOfItem) throws InterruptedException {
        List<WebElement> itemTitles = driver.findElements(By.xpath(ITEM_TITLE_LOCATOR));
        for (int i = 0; i < itemTitles.size(); i++) {
            if (itemTitles.get(i).getText().equalsIgnoreCase(nameOfItem)) {
                itemTitles.get(i).findElement(By.xpath("..//a[@class = 'buy']")).click();
                log("Buy button was clicked");
                log("Item \"" + nameOfItem + "\" was bought");
                break;
            }
        }
    }

    public void clickContinueShopingButton() throws InterruptedException {
        continueShoppingButton.click();
        log("\"Continue shopping\" button was clicked");
        Thread.sleep(4000);
    }

    public String getNameOfItem(int numberOfItem) {
        return shopItemsList.get(numberOfItem-1).findElement(By.xpath("//a[@class = 'item_title']")).getText();
    }

    public void checkDataOfProduct(Product product) {
        driver.findElement(By.xpath("//a[@class = 'item_title' and contains(text(), '"+product.getTitle()+"')]"));
        driver.findElement(By.xpath("//div[@class = 'desc' and contains(text(), '"+product.getDesription()+"')]"));
        driver.findElement(By.xpath("//span[@class = 'cena' and contains(text(), '$"+product.getPrice()+"')]"));
    }
}
