package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.st.selenium.model.MenuItem;

import java.util.List;

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


    public void fillAllFieldsWithData(Object obj, String language) {
        MenuItem menuItem = (MenuItem) obj;
        Select parentSelector = new Select(driver.findElement(By.xpath(PARENT_SELECTOR_LOCATOR)));
        Select typeSelector = new Select(driver.findElement(By.xpath(TYPE_SELECTOR_LOCATOR)));
        Select pageOrLinkValue = new Select(driver.findElement(By.xpath(PAGE_OR_LINK_VALUE_LOCATOR)));
        labelField.sendKeys(menuItem.getLabel());
        rusLabelField.sendKeys(menuItem.getRusLabel());
        parentSelector.selectByVisibleText(menuItem.getParentPage());
        if (language.equals("rus")) {
            typeSelector.selectByVisibleText(menuItem.getRusType());
        } else  typeSelector.selectByVisibleText(menuItem.getType());

    }
}
