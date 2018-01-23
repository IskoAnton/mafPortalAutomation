package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import ru.st.selenium.model.Tournament;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class TournamentsPage extends InternalPage {
    public TournamentsPage(PageManager pages) {
        super(pages);
    }

    private final String  TOURNAMENTS_PAGE_TITLE_LOCATOR = "//div[@class = 'title_name' and (contains(text(), 'Турниры и Особые События') or contains(text(), 'Tournaments and Special Events'))]";


    public TournamentsPage ensurePageLoaded() {
        super.ensurePageLoaded();
        //log(driver.findElement(By.xpath("//h1[@class = 'title_name']")).getText() + "!!!!!!!!!!!!!!!!");
        wait.until(presenceOfElementLocated(By.xpath(TOURNAMENTS_PAGE_TITLE_LOCATOR)));
        log("Tournaments page was loaded successfully");
        return this;
    }

    public void clickOnTournament(Tournament tournament) {

        driver.findElement(By.xpath("//div[contains(text(), '"+tournament.getTitle()+"') or contains(text(), '"+tournament.getRusTitle()+"')]")).click();
    }
}
