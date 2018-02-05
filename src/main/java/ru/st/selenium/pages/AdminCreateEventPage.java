package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.st.selenium.model.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.testng.AssertJUnit.assertEquals;

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
        if (!event.getRatingTable().equals("")) {
            ratingTableSelect.selectByVisibleText(event.getRatingTable());
        }
        sendKeysToDescriptionField(event);
        sendKeysToTextField(event);
        //addFile(imageDirectory);
        clickRusTab();
        sendKeysToRusTitleField(event);
        sendKeysToRusDescriptionField(event);

    }

    public void checkRequiredFieldsMessages() {
        String message1 = driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//ul//li")).getText();
        log("Message 1 is '"+message1+"'");
        assertEquals(message1, "The title field is required.");
        String message2 = driver.findElement(By.xpath("//div[@class = 'form-group col-md-6 has-error']/label[contains(text(), 'Title')]/../div[@class = 'help-block']")).getText();
        log("Message 2 is '"+message2+"'");
        assertEquals(message2, "The title field is required.");
    }
}
