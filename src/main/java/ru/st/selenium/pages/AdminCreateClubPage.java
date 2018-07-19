package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.st.selenium.model.Club;
import ru.st.selenium.model.RatingTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.assertFalse;

public class AdminCreateClubPage extends AdminCreateItemPage {
    private final String CITY_FIELD_LOCATOR = "//input[@name='city']";
    public AdminCreateClubPage(PageManager pages) {
        super(pages);
    }

    @Override
    public void fillAllFieldsWithData(Object obj) {
        Club club = (Club) obj;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TITLE_FIELD_LOCATOR)));
        sendKeysToTitleField(club);
        sendKeysToSlugField(club);
        driver.findElement(By.xpath(CITY_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(CITY_FIELD_LOCATOR)).sendKeys(club.getCity());
        log("City " + club.getCity() + "was typed to city field");
        Select countrySelect = new Select(driver.findElement(By.xpath("//select[@name = 'country_id']")));
        String language = getLanguage();
        if (language.equals("rus") && club.getRusCountry()!="") {
            countrySelect.selectByVisibleText(club.getRusCountry());
            log("Rus country " + club.getRusCountry() + " was selected");
        } else if(language.equals("eng") && club.getCountry()!="") {
            countrySelect.selectByVisibleText(club.getCountry());
            log("Country " + club.getCountry() + " was selected");
        }

        Select ratingTableSelect = new Select(driver.findElement(By.xpath("//select[@name='table_ratings_id']")));
        if (club.getRatingTable() != "") {
            ratingTableSelect.selectByVisibleText(club.getRatingTable());
            log("Rating table " + club.getRatingTable() + " was selected");
        }
        addFile(imageDirectory);
        sendKeysToTextField(club);
        clickRusTab();
        sendKeysToRusTextField(club);
    }

    public void checkRequiredFieldsMessages() {
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[contains(text(), 'The title field is required.')]"));
        log("Message 1 is 'The title field is required.'");
        driver.findElement(By.xpath("//label[contains(text(), 'Title')]/../..//div[@class = 'help-block' and contains(text(), 'The title field is required.')]"));
        log("Message 2 is 'The title field is required.'");
    }

    public void checkRatingTableExists(RatingTable ratingTable) {
        Select ratingTableSelect = new Select(driver.findElement(By.xpath("//select[@name='table_ratings_id']")));
        ratingTableSelect.selectByVisibleText(ratingTable.getTitle());
        log("Rating table " + ratingTable.getTitle() + " exists");
    }

    public void checkRatingTableDoesntExists(RatingTable ratingTable) {
        boolean isPresent = true;
        try {
            Select ratingTableSelect = new Select(driver.findElement(By.xpath("//select[@name='table_ratings_id']")));
            ratingTableSelect.selectByVisibleText(ratingTable.getTitle());
            log("Rating table " + ratingTable.getTitle() + " exists");
        } catch (Exception e) {
            isPresent = false;
        }
        assertFalse(isPresent);
    }
}
