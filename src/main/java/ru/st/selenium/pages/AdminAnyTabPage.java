package ru.st.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public abstract class AdminAnyTabPage extends AdminInternalPage{
    public AdminAnyTabPage(PageManager pages) {
        super(pages);
    }
    private final String ADD_ITEM_BUTTON_LOCATOR = "//span[@class = 'ladda-label']";

    private final String SEARCH_FIELD_LOCATOR = "//input[@type = 'search']";

    @FindBy(xpath = SEARCH_FIELD_LOCATOR)
    private WebElement searchField;

    @FindBy(xpath = ADD_ITEM_BUTTON_LOCATOR)
    private WebElement addItemButton;

    public void clickAddItemButton() {
        addItemButton.click();
        log("Add item was clicked on " + this.getClass().getSimpleName());
    }

    public void clickEditItem(String name, String rusName) {
        try {
            typeToSearchField(name);
            driver.findElement(By.xpath("//table[@id = 'crudTable']//td[contains(text(), '"+name+"')]"));
            //Press edit button
            driver.findElement(By.xpath("//table[@id = 'crudTable']//td[contains(text(), '"+name+"')]/../..//i[@class = 'fa fa-edit']")).click();
        } catch (Exception e) {
            typeToSearchField(rusName);
            driver.findElement(By.xpath("//table[@id = 'crudTable']//td[contains(text(), '"+rusName+"')]"));
            //Press edit button
            driver.findElement(By.xpath("//table[@id = 'crudTable']//td[contains(text(), '"+rusName+"')]/../..//i[@class = 'fa fa-edit']")).click();

        }
    }

    public void clickEditItem(String name) {
        typeToSearchField(name);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id = 'crudTable']//td[contains(text(), '"+name+"')]")));
        //Press edit button
        driver.findElement(By.xpath("//table[@id = 'crudTable']//td[contains(text(), '"+name+"')]/../..//i[@class = 'fa fa-edit']")).click();
        log("Edit button of " + name + " was clicked");
    }

    public void deleteItem(String name, String rusName) {
        String language = getLanguage();
        if (language.equals("eng")) {
            typeToSearchField(name);
            driver.findElement(By.xpath("//table[@id = 'crudTable']//td[contains(text(), '" + name + "')]"));
            //Press delete button
            driver.findElement(By.xpath("//table[@id = 'crudTable']//td[contains(text(), '" + name + "')]/..//a[@data-button-type = 'delete']")).click();
        } else if(language.equals("rus")) {
            typeToSearchField(rusName);
            driver.findElement(By.xpath("//table[@id = 'crudTable']//td[contains(text(), '" + rusName + "')]"));
            //Press edit button
            driver.findElement(By.xpath("//table[@id = 'crudTable']//td[contains(text(), '" + rusName + "')]/..//a[@data-button-type = 'delete']")).click();
        }


        Alert alert = driver.switchTo().alert();
        alert.accept();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log("Item " + name + " has been deleted");
    }

    public void deleteItem(String name) {
            typeToSearchField(name);
            driver.findElement(By.xpath("//table[@id = 'crudTable']//td[contains(text(), '"+name+"')]"));
            driver.findElement(By.xpath("//table[@id = 'crudTable']//td[contains(text(), '"+name+"')]/../..//a[@data-button-type = 'delete']")).click();
            Alert alert = driver.switchTo().alert();
            alert.accept();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log("Item " + name + " has been deleted");
        }

    public void typeToSearchField(String text) {
        searchField.clear();
        searchField.sendKeys(text);
        log("Text " + text + " was typed to the search field");
    }



    //public void getValueOfColumn()
}
