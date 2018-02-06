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
        driver.findElement(By.xpath(TITLE_FIELD_LOCATOR)).sendKeys(tournament.getTitle());
        driver.findElement(By.xpath(SLUG_FIELD_LOCATOR)).sendKeys(tournament.getSlug());
        selectRatingTable(tournament.getRatingTable());
        driver.findElement(By.xpath(DATE_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(DATE_FIELD_LOCATOR)).clear();
        chooseRandomDateInNextMonth();
        driver.findElement(By.xpath(DESCRIPTION_FIELD_LOCATOR)).sendKeys(tournament.getDescripion());
        driver.findElement(By.xpath(RATING_OVERVIEW_FIELD_LOCATOR)).sendKeys(tournament.getRatingOverview());
        log(System.getProperty("user.dir"));
        log(imageDirectory);
        addFile(imageDirectory);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //typeTextToTextField(tournament.getText());
        driver.findElement(By.xpath(META_TITLE_FIELD_LOCATOR)).sendKeys(tournament.getMetaTitle());
        driver.findElement(By.xpath(SOCIAL_META_TITLE_FIELD_LOCATOR)).sendKeys(tournament.getSocialMetaTitle());
        driver.findElement(By.xpath(META_DESCRIPTION_FIELD_LOCATOR)).sendKeys(tournament.getMetaDescription());
        driver.findElement(By.xpath(SOCIAL_META_DESCRIPTION_FIELD_LOCATOR)).sendKeys(tournament.getSocialMetaDescription());
        driver.findElement(By.xpath(META_KEYWORDS_LOCATOR)).sendKeys(tournament.getMetaKeywords());
        driver.findElement(By.xpath(RUS_TAB_LOCATOR)).click();
        driver.findElement(By.xpath(RUS_TITLE_FIELD_LOCATOR)).sendKeys(tournament.getRusTitle());
        driver.findElement(By.xpath(RUS_DESCRIPTION_FIELD_LOCATOR)).sendKeys(tournament.getRusDescripion());
        driver.findElement(By.xpath(RUS_RATING_OVERVIEW_FIELD_LOCATOR)).sendKeys(tournament.getRusRatingOverview());
        //typeTextToTextField(news.getText());
        driver.findElement(By.xpath(RUS_META_TITLE_FIELD_LOCATOR)).sendKeys(tournament.getRusMetaTitle());
        driver.findElement(By.xpath(RUS_SOCIAL_META_TITLE_FIELD_LOCATOR)).sendKeys(tournament.getRusSocialMetaTitle());
        driver.findElement(By.xpath(RUS_META_DESCRIPTION_FIELD_LOCATOR)).sendKeys(tournament.getRusMetaDescription());
        driver.findElement(By.xpath(RUS_SOCIAL_META_DESCRIPTION_FIELD_LOCATOR)).sendKeys(tournament.getRusSocialMetaDescription());
        driver.findElement(By.xpath(RUS_META_KEYWORDS_LOCATOR)).sendKeys(tournament.getRusMetaKeywords());
    }

    private void selectRatingTable(String tableName) {
        Select ratingTableSelector = new Select(driver.findElement(By.xpath(RATING_TABLE_SELECTOR_LOCATOR)));
        ratingTableSelector.selectByVisibleText(tableName);
    }

}
