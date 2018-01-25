package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.Event;

public class EventItemPage extends ClubsPage{

    public EventItemPage(PageManager pages) {
        super(pages);
    }

    public void checkDataOfEvent(Event event) {
        String language = getLanguage();
        if (language.equals("rus")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'sub_item ng-scope']/a[contains(text(), '" + event.getRusTitle() + "')]")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'sub_item ng-scope']/p[contains(text(), '" + event.getRusDescription() + "')]")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'sub_item ng-scope']/p[contains(text(), '" + event.getRusText() + "')]")));
        } else if (language.equals("eng")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'sub_item ng-scope']/a[contains(text(), '" + event.getTitle() + "')]")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'sub_item ng-scope']/p[contains(text(), '" + event.getDescription() + "')]")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'sub_item ng-scope']/p[contains(text(), '" + event.getText() + "')]")));
        }
    }
}
