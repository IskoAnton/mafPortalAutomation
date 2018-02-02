package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.Permission;

public class AdminCreatePermitionPage extends AdminCreateItemPage {
    public AdminCreatePermitionPage(PageManager pages) {
        super(pages);
    }

    public void fillAllFieldsWithData(Object obj) {
        Permission permission = (Permission) obj;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PAGE_NAME_FIELD_LOCATOR)));
        driver.findElement(By.xpath(PAGE_NAME_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(PAGE_NAME_FIELD_LOCATOR)).sendKeys(permission.getName());
        log("Permission name '" + permission.getName() + "' was typed to name field");
        if (!permission.getName().equals("")) {
            putThreeRandomCheckboxes();
        }
    }
}
