package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import ru.st.selenium.model.Partner;
import ru.st.selenium.model.Slide;
import ru.st.selenium.model.Testimonial;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;

public class HomePage extends InternalPage {
    public HomePage(PageManager pages) {
        super(pages);
    }

    public HomePage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.xpath("//section[@class = 'Carusel ng-scope']")));
        return this;
    }

    public void checkDataOnSlide(Slide slide) {
        String language = getLanguage();
        if (language.equals("rus")) {
            driver.findElement(By.xpath("//h1[@class = 'title' and contains(text(),'"+slide.getRusTitle()+"')]"));
            driver.findElement(By.xpath("//div[@class = 'desc' and contains(text(),'"+slide.getRusDescription()+"')]"));
            driver.findElement(By.xpath("//div[@class = 'btbPost']/a[contains(text(),'"+slide.getRusButtonText()+"')]"));
            String btnLink = driver.findElement(By.xpath("//div[@class = 'btbPost']/a[contains(text(),'"+slide.getRusButtonText()+"')]")).getAttribute("href");
            assertEquals(btnLink, slide.getRusButtonLink());
        } else if (language.equals("eng")) {
            driver.findElement(By.xpath("//h1[@class = 'title' and contains(text(),'"+slide.getTitle()+"')]"));
            driver.findElement(By.xpath("//div[@class = 'desc' and contains(text(),'"+slide.getDescription()+"')]"));
            driver.findElement(By.xpath("//div[@class = 'btnPost']/a[contains(text(),'"+slide.getButtonText()+"')]"));
            String btnLink = driver.findElement(By.xpath("//div[@class = 'btnPost']/a[contains(text(),'"+slide.getButtonText()+"')]")).getAttribute("href");
            assertEquals(btnLink, slide.getButtonLink());
        } else assertEquals(0, 1);
    }

    public void checkDataOnTestimonial(Testimonial testimonial) {
            driver.findElement(By.xpath("//div[@class = 'reviewWr ng-scope']//h2[contains(text(), '"+testimonial.getName()+"')]"));
    }

    public void checkDataOfPartners(Partner partner) {
        driver.findElement(By.xpath("//div[@class = 'partnersWr']//img[@title = '"+partner.getName()+"']"));
        driver.findElement(By.xpath("//div[@class = 'partnersWr']//a[@href = '"+partner.getLink()+"']"));
    }
}
