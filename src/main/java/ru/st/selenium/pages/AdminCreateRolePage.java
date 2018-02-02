package ru.st.selenium.pages;

import org.openqa.selenium.By;
import ru.st.selenium.model.Role;

public class AdminCreateRolePage extends AdminCreateItemPage {
    public AdminCreateRolePage(PageManager pages) {
        super(pages);
    }

    public void fillAllFieldsWithData(Object obj) {
        Role role = (Role) obj;
        driver.findElement(By.xpath(PAGE_NAME_FIELD_LOCATOR)).sendKeys(role.getName());
        log("Name '" + role.getName() + "' was typed to name field");
        putThreeRandomCheckboxes();

    }
}
