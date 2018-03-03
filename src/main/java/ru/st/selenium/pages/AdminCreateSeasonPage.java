package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.st.selenium.model.Season;
import ru.st.selenium.model.TabItem;

public class AdminCreateSeasonPage extends AdminCreateItemPage {
    public AdminCreateSeasonPage(PageManager pages) {
        super(pages);
    }

    public void fillAllFieldsWithData(TabItem tabItem) {
        Season season = (Season) tabItem;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TITLE_FIELD_LOCATOR)));
        sendKeysToTitleField(season);
        Select clubSelect = new Select(driver.findElement(By.xpath("//select[@name = 'club_id']")));
        if (!season.getClub().equals("")) {
            clubSelect.selectByVisibleText(season.getClub());
        }
    }

    public void checkRequiredFieldsMessages() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The title field is required.']")));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The title field is required.']"));
        driver.findElement(By.xpath("//label[contains(text(), 'Title')]/../..//div[@class = 'help-block' and text() = 'The title field is required.']"));
    }
}
