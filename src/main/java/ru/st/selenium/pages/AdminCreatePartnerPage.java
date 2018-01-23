package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.Partner;

public class AdminCreatePartnerPage extends AdminCreateItemPage{
    public AdminCreatePartnerPage(PageManager pages) {
        super(pages);
    }

    private final String LINK_FIELD_LOCATOR = "//input[@name = 'link']";

    public void fillAllFieldsWithData(Object obj) {
        Partner partner = (Partner) obj;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PAGE_NAME_FIELD_LOCATOR)));
        driver.findElement(By.xpath(PAGE_NAME_FIELD_LOCATOR)).sendKeys(partner.getName());
        driver.findElement(By.xpath(LINK_FIELD_LOCATOR)).sendKeys(partner.getLink());
        addFile(imageDirectory);
    }
}
