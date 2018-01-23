package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.st.selenium.model.Club;

import java.util.List;

public class AdminCreateClubPage extends AdminCreateItemPage {
    private final String CITY_FIELD_LOCATOR = "//input[@name='city']";
    public AdminCreateClubPage(PageManager pages) {
        super(pages);
    }

    @Override
    public void fillAllFieldsWithData(Object obj) {
        Club club = (Club) obj;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TITLE_FIELD_LOCATOR)));
        driver.findElement(By.xpath(TITLE_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(TITLE_FIELD_LOCATOR)).sendKeys(club.getTitle());
        driver.findElement(By.xpath(SLUG_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(SLUG_FIELD_LOCATOR)).sendKeys(club.getSlug());
        driver.findElement(By.xpath(CITY_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(CITY_FIELD_LOCATOR)).sendKeys(club.getCity());
        Select countrySelect = new Select(driver.findElement(By.xpath("//select[@name = 'country_id']")));
        String language = getLanguage();
        if (language == "rus" && club.getRusCountry()!="") {
            countrySelect.selectByVisibleText(club.getRusCountry());
        } else if(language == "eng" && club.getCountry()!="") {
            countrySelect.selectByVisibleText(club.getCountry());
        }

        Select ratingTableSelect = new Select(driver.findElement(By.xpath("//select[@name='table_ratings_id']")));
        if (club.getRatingTable() != "") {
            ratingTableSelect.selectByVisibleText(club.getRatingTable());
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id = 'cke_1_contents']/iframe")));
        WebElement frame = driver.findElement(By.xpath("//div[@id = 'cke_1_contents']/iframe"));
        driver.switchTo().frame(frame);
        WebElement editor = driver.findElement(By.xpath("//body"));
        editor.clear();
        editor.sendKeys(club.getAboutClub());
        driver.switchTo().defaultContent();
        addFile(imageDirectory);
        clickRusTab();
        WebElement rusFrame = driver.findElement(By.xpath("//div[@id = 'cke_2_contents']/iframe"));
        driver.switchTo().frame(rusFrame);
        WebElement rusEditor = driver.findElement(By.xpath("//body"));
        rusEditor.clear();
        rusEditor.sendKeys(club.getRusAboutClub());
        driver.switchTo().defaultContent();
    }

    public void checkRequiredFieldsMessages() {
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[contains(text(), 'The title field is required.')]"));
        driver.findElement(By.xpath("//label[contains(text(), 'Title')]/../..//div[@class = 'help-block' and contains(text(), 'The title field is required.')]"));
    }
}
