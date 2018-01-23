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
        driver.findElement(By.xpath(TITLE_FIELD_LOCATOR)).sendKeys(product.getTitle());
        driver.findElement(By.xpath(DESCRIPTION_FIELD_LOCATOR)).sendKeys(product.getDesription());
        driver.findElement(By.xpath(PRICE_FIELD_LOCATOR)).sendKeys(product.getPrice());

    }

}
