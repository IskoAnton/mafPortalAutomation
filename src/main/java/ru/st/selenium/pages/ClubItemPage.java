package ru.st.selenium.pages;

import org.openqa.selenium.By;
import ru.st.selenium.model.Club;


import static org.testng.Assert.assertEquals;

public class ClubItemPage extends ClubsPage {
    public ClubItemPage(PageManager pages) {
        super(pages);
    }

    private final String CLUB_TITLE_LOCATOR = "//h1[@class = 'title']";
    private final String ABOUT_CLUB_LOCATOR = "//section[@class = 'AboutClub']//div[@class = 'cont']/p";

    public void checkDataOnClubItemPage(Club club) {
        String language = "";
        language = getLanguage();
        if (language.equalsIgnoreCase("rus")) {
            assertEquals(driver.findElement(By.xpath(CLUB_TITLE_LOCATOR)).getText(), club.getTitle());
            assertEquals(driver.findElement(By.xpath(ABOUT_CLUB_LOCATOR)).getText(), club.getRusAboutClub());

        } else if (language.equalsIgnoreCase("eng")) {
            assertEquals(driver.findElement(By.xpath(CLUB_TITLE_LOCATOR)).getText(), club.getTitle());
            System.out.println(driver.findElement(By.xpath(ABOUT_CLUB_LOCATOR)).getText());
            assertEquals(driver.findElement(By.xpath(ABOUT_CLUB_LOCATOR)).getText(), club.getAboutClub());
        }
    }

    public void clickEventsTab() {
        driver.findElement(By.xpath("//a[contains(text(), 'События') or contains(text(), 'Events')]")).click();
    }
}
