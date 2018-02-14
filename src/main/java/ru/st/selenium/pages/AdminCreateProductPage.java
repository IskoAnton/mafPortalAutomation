package ru.st.selenium.pages;

import org.openqa.selenium.By;
import ru.st.selenium.model.News;
import ru.st.selenium.model.Product;

public class AdminCreateProductPage extends AdminCreateItemPage {
    public AdminCreateProductPage(PageManager pages) {
        super(pages);
    }

    protected final String PRICE_FIELD_LOCATOR = "//input[@name = 'price']";

    public void fillAllFieldsWithData(Object obj) {
        Product product = (Product) obj;
        sendKeysToTitleField(product);
        sendKeysToDescriptionField(product);
        driver.findElement(By.xpath(PRICE_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(PRICE_FIELD_LOCATOR)).sendKeys(product.getPrice());
        log("Price " + product.getPrice() + " was typed to price field");
    }

    public void checkRequiredFieldsMessages() {
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[contains(text(), 'The title field is required.')]"));
        log("Message 1 is 'The title field is required.'");
        driver.findElement(By.xpath("//label[contains(text(), 'Title')]/../..//div[@class = 'help-block' and contains(text(), 'The title field is required.')]"));
        log("Message 2 is 'The title field is required.'");
    }

}
