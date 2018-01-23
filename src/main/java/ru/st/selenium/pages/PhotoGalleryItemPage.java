package ru.st.selenium.pages;

import org.openqa.selenium.By;
import ru.st.selenium.model.PhotoGallery;

import static org.testng.Assert.assertEquals;

public class PhotoGalleryItemPage extends GalleryPage{
    public PhotoGalleryItemPage(PageManager pages) {
        super(pages);
    }

    private final String  PHOTO_GALLERY_TITLE_LOCATOR = "//div[@class = 'title']";

    public void checkDataOfPhotoGallery(PhotoGallery photoGallery, String language) {
        if(language.equals("rus")){
            assertEquals(driver.findElement(By.xpath(PHOTO_GALLERY_TITLE_LOCATOR)).getText().trim(), photoGallery.getRusTitle());
        }
        else if (language.equals("eng")){
            assertEquals(driver.findElement(By.xpath(PHOTO_GALLERY_TITLE_LOCATOR)).getText().trim(), photoGallery.getTitle());
        }
    }
}
