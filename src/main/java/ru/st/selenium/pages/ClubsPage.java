package ru.st.selenium.pages;
import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.Club;
import ru.st.selenium.model.Country;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ClubsPage extends InternalPage {
    public ClubsPage(PageManager pages) {
        super(pages);
    }

    private final String  CLUBS_PAGE_TITLE_LOCATOR= "//h1[@class = 'title_name' and (contains(text(), 'Клубы') or contains(text(), 'Clubs'))]";

    public ClubsPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.xpath(CLUBS_PAGE_TITLE_LOCATOR)));
        log("Clubs page was loaded successfully");
        return this;
    }

    //Check that country of created club on the clubs page is correct
    public void checkClubCountry(Club club) {
        String country = driver.findElement(By.xpath("//a[contains(text(),'"+club.getTitle()+"')]/../../../div[@class = 'country']")).getText();
        try {
            assertEquals(country, club.getCountry());
        } catch (AssertionError e) {
            assertEquals(country, club.getRusCountry());
        }
    }

    public void checkClubDoesntExist(Club club) {
        boolean isPresent = isElementPresent(By.xpath("//a[contains(text(),'"+club.getTitle()+"')]"));
        log("There is no club '" + club.getTitle() + "' on clubs page");
        assertFalse(isPresent);
    }

    public void clickToClub(Club club) {
        WebElement clubLink =  driver.findElement(By.xpath("//a[contains(text(),'"+club.getTitle()+"')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(clubLink);
        actions.perform();
        driver.findElement(By.xpath("//a[contains(text(),'"+club.getTitle()+"')]")).click();
    }

    public void clickToClub(String club) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//ul[@class = 'cityList']//a[contains(text(),'" + club + "')]")).click();
        log("Club " + club + " was clicked");
    }

    public void checkCountryExists(Country country) {
        String language = getLanguage();

        if (language.equals("eng")) {
            driver.findElement(By.xpath("//div[@class = 'clubList']//div[contains(text(),'" + country.getTitle() + "')]"));
            log("Country '" + country.getTitle() + "' exists on clubs page");
            String desc = driver.findElement(By.xpath("//div[@class = 'clubList']//div[contains(text(),'" + country.getTitle() + "')]/../div[@class = 'desc']/p")).getText();
            assertEquals(desc, country.getText());
            log("Description is '" + country.getText() + "'");
        } else if(language.equals("rus")) {
            driver.findElement(By.xpath("//div[@class = 'clubList']//div[contains(text(),'" + country.getRusTitle() + "')]"));
            log("Country '" + country.getRusTitle() + "' exists on clubs page");
            String desc = driver.findElement(By.xpath("//div[@class = 'clubList']//div[contains(text(),'" + country.getRusTitle() + "')]/../div[@class = 'desc']/p")).getText();
            assertEquals(desc, country.getRusText());
            log("Description is '" + country.getRusText() + "'");
        }
    }

    public void checkCountryDoesntExist(Country country) {
        String language = getLanguage();
        boolean isPresent = true;
        if (language.equals("rus")) {
            isPresent = isElementPresent(By.xpath("//div[contains(text(), '"+country.getRusTitle()+"')]"));
        }
        if (language.equals("eng")) {
            isPresent = isElementPresent(By.xpath("//div[contains(text(), '"+country.getTitle()+"')]"));
        }
        log("There is no country '" + country.getTitle() + "' on clubs page");
        assertFalse(isPresent);
    }
}
