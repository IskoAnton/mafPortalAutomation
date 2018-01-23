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
        driver.findElement(By.xpath(TITLE_FIELD_LOCATOR)).sendKeys(event.getTitle());
        driver.findElement(By.xpath(SLUG_FIELD_LOCATOR)).sendKeys(event.getTitle());
        chooseRandomDateInNextMonth();
        putThreeRandomCheckboxes();
        Select ratingTableSelect = new Select(driver.findElement(By.xpath("//select[@name='table_ratings_id']")));
        ratingTableSelect.selectByVisibleText(event.getRatingTable());
        driver.findElement(By.xpath(DESCRIPTION_FIELD_LOCATOR)).sendKeys(event.getDescription());
        String imageDirectory = System.getProperty("user.dir") + "\\src\\main\\resources\\uploads\\test.png";
        addFile(imageDirectory);
        clickRusTab();
        driver.findElement(By.xpath(RUS_TITLE_FIELD_LOCATOR)).sendKeys(event.getRusTitle());
        driver.findElement(By.xpath(RUS_DESCRIPTION_FIELD_LOCATOR)).sendKeys(event.getRusDescription());
    }
}
