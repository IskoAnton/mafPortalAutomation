package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import ru.st.selenium.model.News;
import ru.st.selenium.model.Tournament;

import java.text.ParseException;

public class AdminCreateTournamentPage extends AdminCreateItemPage{

    public AdminCreateTournamentPage(PageManager pages) {
        super(pages);
    }

    protected final String RATING_TABLE_SELECTOR_LOCATOR = "//select[@name = 'table_ratings_id']";
    protected final String RATING_OVERVIEW_FIELD_LOCATOR = "//textarea[@name = 'rating_overview']";
    protected final String RUS_RATING_OVERVIEW_FIELD_LOCATOR = "//textarea[@name = 'rating_overview_ru']";

    public void fillAllFieldsWithData(Object obj) {
        Tournament tournament = (Tournament) obj;
        sendKeysToTitleField(tournament);
        sendKeysToSlugField(tournament);
        if (!tournament.getRatingTable().equals("")) {
            selectRatingTable(tournament.getRatingTable());
            log("Rating table '" + tournament.getRatingTable() + "' was selected");
        }
        driver.findElement(By.xpath(DATE_FIELD_LOCATOR)).clear();
        chooseRandomDateInNextMonth();
        sendKeysToDescriptionField(tournament);
        driver.findElement(By.xpath(RATING_OVERVIEW_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(RATING_OVERVIEW_FIELD_LOCATOR)).sendKeys(tournament.getRatingOverview());
        addFile(imageDirectory);
        typeTextToTextField(tournament.getText());
        /*sendKeysToMetaTitle(tournament);
        sendKeysToSocialMetaTitle(tournament);
        sendKeysToMetaDescription(tournament);
        sendKeysToSocialMetaDescription(tournament);
        sendKeysToMetaKeywords(tournament);*/
        driver.findElement(By.xpath(RUS_TAB_LOCATOR)).click();
        sendKeysToRusTitleField(tournament);
        sendKeysToRusDescriptionField(tournament);
        driver.findElement(By.xpath(RUS_RATING_OVERVIEW_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(RUS_RATING_OVERVIEW_FIELD_LOCATOR)).sendKeys(tournament.getRusRatingOverview());
        //typeTextToTextField();
        /*sendKeysToRusMetaTitle(tournament);
        sendKeysToRusSocialMetaTitle(tournament);
        sendKeysToRusMetaDescription(tournament);
        sendKeysToRusSocialMetaDescription(tournament);
        sendKeysToRusMetaKeywords(tournament);*/
    }

    private void selectRatingTable(String tableName) {
        Select ratingTableSelector = new Select(driver.findElement(By.xpath(RATING_TABLE_SELECTOR_LOCATOR)));
        ratingTableSelector.selectByVisibleText(tableName);
    }

    public void checkRequiredFieldsMessages() {
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The title field is required.']"));
        log("Message 1 is 'The title name is required.'");
        driver.findElement(By.xpath("//label[contains(text(), 'Title')]/../..//div[@class = 'help-block' and text() = 'The title field is required.']"));
        log("Message 2 is 'The title field is required.'");
    }

}
