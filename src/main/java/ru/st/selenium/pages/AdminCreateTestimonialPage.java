package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.Testimonial;

public class AdminCreateTestimonialPage extends AdminCreateItemPage {
    public AdminCreateTestimonialPage(PageManager pages) {
        super(pages);
    }

    public void fillAllFieldsWithData(Object obj) {
        Testimonial testimonial = (Testimonial) obj;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PAGE_NAME_FIELD_LOCATOR)));
        driver.findElement(By.xpath(PAGE_NAME_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(PAGE_NAME_FIELD_LOCATOR)).sendKeys(testimonial.getName());
        log("Testimonial name '" + testimonial.getName() + "' was typed to name field");
        driver.findElement(By.xpath("//textarea[@name = 'text']")).clear();
        driver.findElement(By.xpath("//textarea[@name = 'text']")).sendKeys(testimonial.getText());
        log("Text '" + testimonial.getText() + "' was typed to text field");
        addFile(imageDirectory);
    }

    public void checkRequiredFieldsMessages() {
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The name field is required.']"));
        log("Message 1 is 'The title name is required.'");
        driver.findElement(By.xpath("//label[contains(text(), 'Name')]/../..//div[@class = 'help-block' and text() = 'The name field is required.']"));
        log("Message 2 is 'The name field is required.'");
    }


}
