package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import ru.st.selenium.model.VideoGallery;


public class AdminCreateVideoGalleryPage extends AdminCreateItemPage{
    public AdminCreateVideoGalleryPage(PageManager pages) {
        super(pages);
    }

    private final String  SHOW_IN_GLOBAL_GALLERY_LOCATOR= "//input[@type = 'checkbox']";
    private final String  YOUTUBE_LINK_FIELD_LOCATOR= "//input[@name = 'id_youtube']";

    public void fillAllFieldsWithData(Object obj) {
        VideoGallery videoGallery = (VideoGallery) obj;
        String language = getLanguage();
        driver.findElement(By.xpath(TITLE_FIELD_LOCATOR)).sendKeys(videoGallery.getTitle());
        log("Title field filled with '" + videoGallery.getTitle() + "'");
        driver.findElement(By.xpath(RUS_TITLE_FIELD_LOCATOR)).sendKeys(videoGallery.getRusTitle());
        log("Rus title field filled with '" + videoGallery.getRusTitle() + "'");
        Select clubSelect = new Select(driver.findElement(By.xpath("//select[@name = 'club_id']")));
        clubSelect.selectByVisibleText(videoGallery.getClub());
        log("Club '" + videoGallery.getClub() + "' in select field was chosen");
        Select tournamentSelect = new Select(driver.findElement(By.xpath("//select[@name = 'tournament_id']")));
        String tournament = "";
        if (language.equals("eng")) {
            tournamentSelect.selectByVisibleText(videoGallery.getTournament());
            tournament = videoGallery.getTournament();
        } else if (language.equals("rus")) {
            tournamentSelect.selectByVisibleText(videoGallery.getRusTournament());
            tournament = videoGallery.getRusTournament();
        }
        log("Tournament '" + tournament + "' in select field was chosen");
        if (videoGallery.isShowInGlobalGallery()) {
            driver.findElement(By.xpath(SHOW_IN_GLOBAL_GALLERY_LOCATOR)).click();
        }
        driver.findElement(By.xpath(YOUTUBE_LINK_FIELD_LOCATOR)).sendKeys(videoGallery.getYoutubeLink());
        //addFile(imageDirectory);

    }
}
