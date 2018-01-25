package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.Event;

import java.util.List;

public class EventItemPage extends ClubsPage{

    public EventItemPage(PageManager pages) {
        super(pages);
    }

    public void checkDataOfEvent(Event event) {
        String language = getLanguage();
        if (language.equals("rus")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'sub_item ng-scope']/a[contains(text(), '" + event.getRusTitle() + "')]")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'sub_item ng-scope']/p[contains(text(), '" + event.getRusDescription() + "')]")));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'sub_item ng-scope']/a[contains(text(), '" + event.getRusTitle() + "')]")));
            List<WebElement> caruselElements = driver.findElements(By.xpath("//div[@class = 'sub_item ng-scope']/a[contains(text(), '" + event.getRusTitle() + "')]"));
            for (int i = 0; i<caruselElements.size(); i++) {
                boolean isVisible = caruselElements.get(i).isDisplayed();
                if (isVisible) {
                    caruselElements.get(i).click();
                    break;
                }
            }
            //driver.findElement(By.xpath("//div[@class = 'sub_item ng-scope']/a[contains(text(), '" + event.getRusTitle() + "')]")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'NewTitle' and contains(text(), '"+event.getRusTitle()+"')]")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'descWr']//div[@class = 'text' and contains(text(), '"+event.getRusDescription()+"')]")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'MainCont']//p[contains(text(), '"+event.getRusText()+"')]")));
        } else if (language.equals("eng")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'sub_item ng-scope']/a[contains(text(), '" + event.getTitle() + "')]")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'sub_item ng-scope']/p[contains(text(), '" + event.getDescription() + "')]")));
            List<WebElement> caruselElements = driver.findElements(By.xpath("//div[@class = 'sub_item ng-scope']/a[contains(text(), '" + event.getRusTitle() + "')]"));
            for (int i = 0; i<caruselElements.size(); i++) {
                boolean isVisible = caruselElements.get(i).isDisplayed();
                if (isVisible) {
                    caruselElements.get(i).click();
                    break;
                }
            }
            //driver.findElement(By.xpath("//div[@class = 'sub_item ng-scope']/a[contains(text(), '" + event.getTitle() + "')]")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'NewTitle' and contains(text(), '"+event.getTitle()+"')]")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'descWr']//div[@class = 'text' and contains(text(), '"+event.getDescription()+"')]")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'MainCont']//p[contains(text(), '"+event.getText()+"')]")));
        }
    }
}
