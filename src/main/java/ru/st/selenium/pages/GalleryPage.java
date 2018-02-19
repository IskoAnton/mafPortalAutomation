package ru.st.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import ru.st.selenium.model.PhotoGallery;
import ru.st.selenium.model.VideoGallery;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class GalleryPage extends InternalPage {
    public GalleryPage(PageManager pages) {
        super(pages);
    }

    private final String  GALLERY_PAGE_TITLE_LOCATOR= "//h1[@class = 'title_name' and (contains(text(), 'Gallery') or contains(text(), 'Галерея'))]";

    public GalleryPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.xpath(GALLERY_PAGE_TITLE_LOCATOR)));
        log("Gallery page was loaded successfully");
        return this;
    }

    public void clickPhotoGallery(PhotoGallery photoGallery) {
        driver.findElement(By.xpath("//div[contains(text(), '"+photoGallery.getRusTitle()+"') or contains(text(), '"+photoGallery.getTitle()+"')]")).click();
    }

    public void clickVideoGallery(VideoGallery videoGallery) {
        String language = getLanguage();
        String title = driver.findElement(By.xpath("//div[contains(text(),'"+videoGallery.getRusTitle()+"') or contains(text(), '"+videoGallery.getTitle()+"')]")).getText();
        if (language.equals("rus")) {
            assertEquals(videoGallery.getRusTitle(), title);
        } else assertEquals(videoGallery.getTitle(), title);
    }

    public void clickVideoTab() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//a[contains(text(), 'Видео') or contains(text(), 'Video')]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkPhotoGalleryDoesntExist(PhotoGallery photoGallery) {
        String language = getLanguage();
        boolean isPresent = true;
        if (language.equals("rus")) {
            isPresent = isElementPresent(By.xpath("//div[@class = 'item_title' and contains(text(),'"+ photoGallery.getRusTitle() + "')]"));
        }
        if (language.equals("eng")) {
            isPresent = isElementPresent(By.xpath("//div[@class = 'item_title' and contains(text(),'"+ photoGallery.getTitle() + "')]"));
        }
        log("There is no video gallery '" + photoGallery.getTitle() + "' on gallery page");
        assertFalse(isPresent);
    }

    public void checkVideoGalleryDoesntExist(VideoGallery videoGallery) {
        String language = getLanguage();
        boolean isPresent = true;
        if (language.equals("rus")) {
            isPresent = isElementPresent(By.xpath("//div[contains(text(), '"+ videoGallery.getRusTitle() + "')]"));
        }
        if (language.equals("eng")) {
            isPresent = isElementPresent(By.xpath("//div[contains(text(), '"+ videoGallery.getTitle() + "')]"));
        }
        log("There is no video gallery '" + videoGallery.getTitle() + "' on gallery page");
        assertFalse(isPresent);
    }
}
