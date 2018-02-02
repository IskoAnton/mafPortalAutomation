package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.Event;

import java.util.List;

import static org.testng.Assert.assertFalse;

public class EventItemPage extends ClubsPage{

    public EventItemPage(PageManager pages) {
        super(pages);
    }

    public void checkDataOfEvent(Event event) {
        String language = getLanguage();
        if (language.equals("rus")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'sub_item ng-scope']/a[contains(text(), '" + event.getRusTitle() + "')]")));
            log("Rus title is OK");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'sub_item ng-scope']/p[contains(text(), '" + event.getRusDescription() + "')]")));
            log("Rus description is OK");
        } else if (language.equals("eng")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'sub_item ng-scope']/a[contains(text(), '" + event.getTitle() + "')]")));
            log("Eng title is OK");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'sub_item ng-scope']/p[contains(text(), '" + event.getDescription() + "')]")));
            log("Eng description is OK");
        }
    }

    public void checkEventDoesntExist(Event event) {
        String language = getLanguage();
        boolean isPresent = true;
        if (language.equals("rus")) {
            isPresent = isElementPresent(By.xpath("//div[@class = 'sub_item ng-scope']/a[contains(text(), '" + event.getRusTitle() + "')]"));
            log("There is no event '" + event.getRusTitle() + "' on clubs page");
        }
        if (language.equals("eng")) {
            isPresent = isElementPresent(By.xpath("//div[@class = 'sub_item ng-scope']/a[contains(text(), '" + event.getTitle() + "')]"));
            log("There is no event '" + event.getTitle() + "' on clubs page");
        }
        assertFalse(isPresent);
    }
}
