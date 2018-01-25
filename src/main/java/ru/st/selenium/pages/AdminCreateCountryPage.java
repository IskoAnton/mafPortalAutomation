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
        sendKeysToTitleField(country);
        clickRusTab();
        sendKeysToRusTitleField(country);
    }
}
