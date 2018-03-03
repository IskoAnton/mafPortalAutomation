package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.st.selenium.model.GameResults;
import ru.st.selenium.model.TabItem;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.SystemColor.window;
import static org.testng.AssertJUnit.assertEquals;

public class AdminCreateGameResultsPage extends AdminCreateItemPage{
    public AdminCreateGameResultsPage(PageManager pages) {
        super(pages);
    }
    public void fillAllFieldsWithData(TabItem tabItem) {
        GameResults gameResults = (GameResults) tabItem;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TITLE_FIELD_LOCATOR)));
        sendKeysToTitleField(gameResults);
        sendKeysToSlugField(gameResults);
        Select clubSelect = new Select(driver.findElement(By.xpath("//select[@name = 'club_id']")));
        if (!gameResults.getClub().equals("")) {
            clubSelect.selectByVisibleText(gameResults.getClub());
        }
        Select tournamentSelect = new Select(driver.findElement(By.xpath("//select[@name = 'tournament_id']")));
        if (!gameResults.getTournament().equals("")) {
            tournamentSelect.selectByVisibleText(gameResults.getTournament());
        }
        Select ratingTableSelect = new Select(driver.findElement(By.xpath("//select[@name = 'table_ratings_id']")));
        if (!gameResults.getRatingTable().equals("")) {
            ratingTableSelect.selectByVisibleText(gameResults.getRatingTable());
        }
        chooseRandomDateInNextMonth();
        WebElement searchField = driver.findElement(By.xpath("//input[@id = 's2id_autogen1_search']"));
        WebElement arrow = driver.findElement(By.xpath("//div[@id = 's2id_select2_ajax_moderator']//span[@class = 'select2-arrow']"));
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath(TITLE_FIELD_LOCATOR)).click();
        wait.until(ExpectedConditions.elementToBeClickable(arrow));
        arrow.click();
        searchField.click();
        searchField.clear();
        searchField.sendKeys(gameResults.getModerator());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement match = driver.findElement(By.xpath("//span[@class = 'select2-match']"));
        actions.moveToElement(match).click().perform();
    }

    public void checkRequiredFieldsMessages() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The title field is required.']")));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The title field is required.']"));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The moderator field is required.']"));
        driver.findElement(By.xpath("//label[contains(text(), 'Title')]/../..//div[@class = 'help-block' and text() = 'The title field is required.']"));
        driver.findElement(By.xpath("//label[contains(text(), 'Moderator')]/../..//div[@class = 'help-block' and text() = 'The moderator field is required.']"));
    }
}
