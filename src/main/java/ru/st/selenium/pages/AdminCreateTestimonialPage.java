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
        driver.findElement(By.xpath(PAGE_NAME_FIELD_LOCATOR)).sendKeys(testimonial.getName());
        addFile(imageDirectory);
    }
}
