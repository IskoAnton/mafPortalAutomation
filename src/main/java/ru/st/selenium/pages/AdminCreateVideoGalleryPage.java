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
        sendKeysToTitleField(videoGallery);
        sendKeysToRusTitleField(videoGallery);
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
        if (videoGallery.isShowInGlobalGallery() && !isElementPresent(By.xpath("//input[@type = 'checkbox' and @checked = 'checked']"))) {
            driver.findElement(By.xpath(SHOW_IN_GLOBAL_GALLERY_LOCATOR)).click();
        }
        driver.findElement(By.xpath(YOUTUBE_LINK_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(YOUTUBE_LINK_FIELD_LOCATOR)).sendKeys(videoGallery.getYoutubeLink());
        addFile(imageDirectory);

    }

    public void checkRequiredFieldsMessages() {
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The title field is required.']"));
        log("Message 1 is 'The title name is required.'");
        driver.findElement(By.xpath("//label[contains(text(), 'Title')]/../..//div[@class = 'help-block' and text() = 'The title field is required.']"));
        log("Message 2 is 'The title field is required.'");
    }
}
