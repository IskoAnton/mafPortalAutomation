package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.st.selenium.model.PageItem;
import ru.st.selenium.model.PhotoGallery;

public class AdminCreatePhotoGalleryPage extends AdminCreateItemPage{
    public AdminCreatePhotoGalleryPage(PageManager pages) {
        super(pages);
    }

    private final String  SHOW_IN_GLOBAL_GALLERY_LOCATOR= "//input[@type = 'checkbox']";

    public void fillAllFieldsWithData(Object obj) {
        String language = getLanguage();
        PhotoGallery photoGallery = (PhotoGallery) obj;
        driver.findElement(By.xpath(TITLE_FIELD_LOCATOR)).sendKeys(photoGallery.getTitle());
        log("Title field filled with '" + photoGallery.getTitle() + "'");
        driver.findElement(By.xpath(RUS_TITLE_FIELD_LOCATOR)).sendKeys(photoGallery.getRusTitle());
        log("Rus title field filled with '" + photoGallery.getRusTitle() + "'");
        driver.findElement(By.xpath(SLUG_FIELD_LOCATOR)).sendKeys(photoGallery.getSlug());
        log("Slug field filled with '" + photoGallery.getSlug() + "'");
        Select clubSelect = new Select(driver.findElement(By.xpath("//select[@name = 'club_id']")));
        clubSelect.selectByVisibleText(photoGallery.getClub());
        log("Club '" + photoGallery.getClub() + "' in select field was chosen");
        Select tournamentSelect = new Select(driver.findElement(By.xpath("//select[@name = 'tournament_id']")));
        if (language.equals("eng")) {
            tournamentSelect.selectByVisibleText(photoGallery.getTournament());
        }
        else if (language.equals("rus")) {
            tournamentSelect.selectByVisibleText(photoGallery.getRusTournament());
        }
        log("Tournament '" + photoGallery.getTournament() + "' in select field was chosen");
        if (photoGallery.isShowInGlobalGallery()) {
            driver.findElement(By.xpath(SHOW_IN_GLOBAL_GALLERY_LOCATOR)).click();
        }
        addFile(imageDirectory);
    }
}
