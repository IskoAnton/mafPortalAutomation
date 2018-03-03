package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.Season;

import static org.testng.Assert.assertFalse;

public class RatingPage extends ClubsPage{
    public RatingPage(PageManager pages) {
        super(pages);
    }

    public void checkSeasonExists(Season season) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id = 'select_season']/option[contains(text(), '"+season.getTitle()+"')]")));
    }

    public void checkSeasonDoesntExists(Season season) {
        boolean isPresent = isElementPresent(By.xpath("//select[@id = 'select_season']/option[contains(text(), '"+season.getTitle()+"')]"));
        assertFalse(isPresent);
    }
}
