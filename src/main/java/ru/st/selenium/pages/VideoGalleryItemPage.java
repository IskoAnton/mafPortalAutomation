package ru.st.selenium.pages;

import org.openqa.selenium.By;
import ru.st.selenium.model.PhotoGallery;
import ru.st.selenium.model.VideoGallery;

import static org.testng.Assert.assertEquals;

public class VideoGalleryItemPage extends GalleryPage {
    public VideoGalleryItemPage(PageManager pages) {
        super(pages);
    }

    private final String  VIDEO_GALLERY_TITLE_LOCATOR = "//div[@class = 'title']";

    public void checkDataOfVideoGallery(VideoGallery videoGallery, String language) {
        if(language.equals("rus")){
            assertEquals(driver.findElement(By.xpath(VIDEO_GALLERY_TITLE_LOCATOR)).getText().trim(), videoGallery.getRusTitle());
        }
        else if (language.equals("eng")){
            assertEquals(driver.findElement(By.xpath(VIDEO_GALLERY_TITLE_LOCATOR)).getText().trim(), videoGallery.getTitle());
        }
    }
}
