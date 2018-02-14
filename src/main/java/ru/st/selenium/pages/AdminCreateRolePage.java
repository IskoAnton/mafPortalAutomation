package ru.st.selenium.pages;

import org.openqa.selenium.By;
import ru.st.selenium.model.Role;

public class AdminCreateRolePage extends AdminCreateItemPage {
    public AdminCreateRolePage(PageManager pages) {
        super(pages);
    }

    public void fillAllFieldsWithData(Object obj) {
        Role role = (Role) obj;
        driver.findElement(By.xpath(PAGE_NAME_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(PAGE_NAME_FIELD_LOCATOR)).sendKeys(role.getName());
        log("Name '" + role.getName() + "' was typed to name field");
        putThreeRandomCheckboxes();

    }

    public void checkRequiredFieldsMessages() {
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[contains(text(), 'The name field is required.')]"));
        log("Message 1 is 'The name field is required.'");
        driver.findElement(By.xpath("//label[contains(text(), 'Name')]/../..//div[@class = 'help-block' and contains(text(), 'The name field is required.')]"));
        log("Message 2 is 'The name field is required.'");
    }
}
