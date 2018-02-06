package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.Club;


import static org.testng.Assert.assertEquals;

public class ClubItemPage extends ClubsPage {
    public ClubItemPage(PageManager pages) {
        super(pages);
    }

    private final String CLUB_TITLE_LOCATOR = "//h1[@class = 'title']";
    private final String ABOUT_CLUB_LOCATOR = "//section[@class = 'AboutClub']//div[@class = 'cont']/p";

    public void checkDataOnClubItemPage(Club club) {
        log("Checking data on Clubs page");
        String language = "";
        language = getLanguage();
        if (language.equalsIgnoreCase("rus")) {
            //TODO wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLUB_TITLE_LOCATOR)));
            //assertEquals(driver.findElement(By.xpath(CLUB_TITLE_LOCATOR)).getText(), club.getRusTitle());
            //log("Rus title is Ok");
            assertEquals(driver.findElement(By.xpath(ABOUT_CLUB_LOCATOR)).getText(), club.getRusText());
            log("Rus about club is Ok");

        } else if (language.equalsIgnoreCase("eng")) {
            //TODO wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLUB_TITLE_LOCATOR)));
            //assertEquals(driver.findElement(By.xpath(CLUB_TITLE_LOCATOR)).getText(), club.getTitle());
            //log("Title is Ok");
            assertEquals(driver.findElement(By.xpath(ABOUT_CLUB_LOCATOR)).getText(), club.getText());
            log("About club is Ok");
        }
    }

    public void clickEventsTab() {
        driver.findElement(By.xpath("//a[contains(text(), 'События') or contains(text(), 'Events')]")).click();
        log("Events tab was clicked");
    }
}
