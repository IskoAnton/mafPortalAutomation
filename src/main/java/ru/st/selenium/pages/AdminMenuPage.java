package ru.st.selenium.pages;

import javafx.scene.web.WebEvent;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

import java.util.List;

public class AdminMenuPage extends AdminAnyTabPage {
    public AdminMenuPage(PageManager pages) {
        super(pages);
    }

    /*public void deleteMenuItem(String name) {
        List<WebElement> elements = getMenuItemsInTable();
        for (int i = 0; i<elements.size(); i++) {
            String label = elements.get(i).findElement(By.xpath(".//td[2]")).getText();
            System.out.println(label);
            if (label.equalsIgnoreCase(name)) {
                elements.get(i).findElement(By.xpath(".//a[@data-button-type = 'delete']")).click();
                Alert alert = driver.switchTo().alert();
                alert.accept();
                log("Menu item " + name + " has been deleted");
            }
        }
    }

    public List<WebElement> getMenuItemsInTable() {
        return driver.findElements(By.xpath("//table[@id = 'crudTable']/tbody/tr"));
    }*/
}
