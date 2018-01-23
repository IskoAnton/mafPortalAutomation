package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPagesPage extends AdminAnyTabPage{
    public AdminPagesPage(PageManager pages) {
        super(pages);
    }

    public void clickOpenPage(String name) {
        List<WebElement> elements = getItemsInTable();
        for (int i = 0; i<elements.size(); i++) {
            String label = elements.get(i).findElement(By.xpath(".//td[1]")).getText();
            if (label.equalsIgnoreCase(name)) {
                elements.get(i).findElement(By.xpath(".//a[contains(text(), ' Open')]")).click();
                log("Button 'Open' was clicked for page " + name);
            }
        }
    }
}
