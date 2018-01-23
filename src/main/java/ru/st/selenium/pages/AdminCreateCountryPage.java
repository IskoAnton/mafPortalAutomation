package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.Country;

public class AdminCreateCountryPage extends AdminCreateItemPage {
    public AdminCreateCountryPage(PageManager pages) {
        super(pages);
    }

    public void fillAllFieldsWithData(Object obj) {
        Country country = (Country) obj;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TITLE_FIELD_LOCATOR)));
        driver.findElement(By.xpath(TITLE_FIELD_LOCATOR)).sendKeys(country.getTitle());
        log(country.getTitle() + " has been typed in Title field");
        clickRusTab();
        driver.findElement(By.xpath(RUS_TITLE_FIELD_LOCATOR)).sendKeys(country.getRusTitle());
        log(country.getTitle() + " has been typed in Rus Title field");
    }
}
