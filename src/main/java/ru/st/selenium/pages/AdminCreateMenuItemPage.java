package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.st.selenium.model.MenuItem;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class AdminCreateMenuItemPage extends AdminCreateItemPage{
    public AdminCreateMenuItemPage(PageManager pages) {
        super(pages);
    }


    private final String  LABEL_FIELD_LOCATOR= "//input[@name = 'name']";
    private final String  RUS_LABEL_FIELD_LOCATOR= "//input[@name = 'name_rus']";
    private final String  PARENT_SELECTOR_LOCATOR= "//select[@name = 'parent_id']";
    private final String  TYPE_SELECTOR_LOCATOR= "//select[@id = 'page_or_link_select']";
    private final String  PAGE_OR_LINK_VALUE_LOCATOR= "//div[@id = 'page_or_link_page']/select";


    @FindBy(xpath = LABEL_FIELD_LOCATOR)
    private WebElement labelField;

    @FindBy(xpath = RUS_LABEL_FIELD_LOCATOR)
    private WebElement rusLabelField;


    public void fillAllFieldsWithData(Object obj) {
        MenuItem menuItem = (MenuItem) obj;
        String language = getLanguage();
        Select parentSelector = new Select(driver.findElement(By.xpath(PARENT_SELECTOR_LOCATOR)));
        Select typeSelector = new Select(driver.findElement(By.xpath(TYPE_SELECTOR_LOCATOR)));
        Select pageOrLinkValue = new Select(driver.findElement(By.xpath(PAGE_OR_LINK_VALUE_LOCATOR)));
        labelField.clear();
        labelField.sendKeys(menuItem.getLabel());
        log("Label '" + menuItem.getLabel() + "' was typed to label field");
        rusLabelField.clear();
        rusLabelField.sendKeys(menuItem.getRusLabel());
        log("Rus label '" + menuItem.getRusLabel() + "' was typed to rus label field");
        parentSelector.selectByVisibleText(menuItem.getParentPage());
        if (language.equals("rus")) {
            typeSelector.selectByVisibleText(menuItem.getRusType());
        } else  typeSelector.selectByVisibleText(menuItem.getType());

    }

    public void checkRequiredFieldsMessages() {
        String language = getLanguage();
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The name field is required.']"));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The name rus field is required.']"));
        log("Message 1 is 'The name field is required.'");
        log("Message 1 is 'The rus name field is required.'");
        driver.findElement(By.xpath("//label[contains(text(), 'Label')]/../..//div[@class = 'help-block' and text() = 'The name field is required.']"));
        driver.findElement(By.xpath("//label[contains(text(), 'Russian label')]/../..//div[@class = 'help-block' and text() = 'The name rus field is required.']"));
    }
}
