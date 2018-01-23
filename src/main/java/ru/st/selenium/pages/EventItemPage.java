package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.Event;

public class EventItemPage extends ClubsPage{

    public EventItemPage(PageManager pages) {
        super(pages);
    }

    public void checkDataOfEvent(Event event) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'sub_item ng-scope']/a[contains(text(), '"+event.getRusTitle()+"') or contains(text(), '"+event.getTitle()+"')]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'sub_item ng-scope']/p[contains(text(), '"+event.getRusDescription()+"') or contains(text(), '"+event.getDescription()+"')]")));
    }
}
