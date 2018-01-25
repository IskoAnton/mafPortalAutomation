package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.st.selenium.model.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdminCreateEventPage extends AdminCreateItemPage {
    public AdminCreateEventPage(PageManager pages) {
        super(pages);
    }

    //private ArrayList<String> chosenClubs = new ArrayList<String>();

    /*public ArrayList<String> getChosenClubs() {
        return chosenClubs;
    }*/

    public void fillAllFieldsWithData(Object obj) {
        Event event = (Event) obj;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TITLE_FIELD_LOCATOR)));
        sendKeysToTitleField(event);
        sendKeysToSlugField(event);
        chooseRandomDateInNextMonth();
        putThreeRandomCheckboxes();
        Select ratingTableSelect = new Select(driver.findElement(By.xpath("//select[@name='table_ratings_id']")));
        ratingTableSelect.selectByVisibleText(event.getRatingTable());
        sendKeysToDescriptionField(event);
        sendKeysToTextField(event);
        addFile(imageDirectory);
        clickRusTab();
        sendKeysToRusTitleField(event);
        sendKeysToRusDescriptionField(event);

    }
}
