package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.Country;

import static org.testng.AssertJUnit.assertEquals;

public class AdminCreateCountryPage extends AdminCreateItemPage {
    public AdminCreateCountryPage(PageManager pages) {
        super(pages);
    }

    public void fillAllFieldsWithData(Object obj) {
        Country country = (Country) obj;
        sendKeysToTitleField(country);
        sendKeysToTextField(country);
        clickRusTab();
        sendKeysToRusTitleField(country);
        sendKeysToRusTextField(country);
    }

    public void checkRequiredFieldsMessages() {
        String message1 = driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//ul//li")).getText();
        log("Message 1 is '"+message1+"'");
        assertEquals(message1, "The title field is required.");
        String message2 = driver.findElement(By.xpath("//div[@class = 'form-group col-md-12 has-error']/label[contains(text(), 'Title')]/../div[@class = 'help-block']")).getText();
        log("Message 2 is '"+message2+"'");
        assertEquals(message2, "The title field is required.");
    }
}
