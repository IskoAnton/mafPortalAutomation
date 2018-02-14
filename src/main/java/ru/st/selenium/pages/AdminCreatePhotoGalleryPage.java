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
        driver.findElement(By.xpath(TITLE_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(TITLE_FIELD_LOCATOR)).sendKeys(photoGallery.getTitle());
        log("Title field filled with '" + photoGallery.getTitle() + "'");
        driver.findElement(By.xpath(RUS_TITLE_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(RUS_TITLE_FIELD_LOCATOR)).sendKeys(photoGallery.getRusTitle());
        log("Rus title field filled with '" + photoGallery.getRusTitle() + "'");
        driver.findElement(By.xpath(SLUG_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(SLUG_FIELD_LOCATOR)).sendKeys(photoGallery.getSlug());
        log("Slug field filled with '" + photoGallery.getSlug() + "'");
        Select clubSelect = new Select(driver.findElement(By.xpath("//select[@name = 'club_id']")));
        if (!photoGallery.getClub().equals("")) {
            clubSelect.selectByVisibleText(photoGallery.getClub());
        }
        log("Club '" + photoGallery.getClub() + "' in select field was chosen");
        Select tournamentSelect = new Select(driver.findElement(By.xpath("//select[@name = 'tournament_id']")));
        if (language.equals("eng") && !photoGallery.getTournament().equals("")) {
            tournamentSelect.selectByVisibleText(photoGallery.getTournament());
        }
        else if (language.equals("rus") && !photoGallery.getRusTournament().equals("")) {
            tournamentSelect.selectByVisibleText(photoGallery.getRusTournament());
        }
        log("Tournament '" + photoGallery.getTournament() + "' in select field was chosen");
        if (photoGallery.isShowInGlobalGallery() && !isElementPresent(By.xpath("//input[@type = 'checkbox' and @checked = 'checked']"))) {
            driver.findElement(By.xpath(SHOW_IN_GLOBAL_GALLERY_LOCATOR)).click();
        }
        addFile(imageDirectory);
    }

    public void checkRequiredFieldsMessages() {
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[contains(text(), 'The title field is required.')]"));
        log("Message 1 is 'The title field is required.'");
        driver.findElement(By.xpath("//label[contains(text(), 'Title')]/../..//div[@class = 'help-block' and contains(text(), 'The title field is required.')]"));
        log("Message 2 is 'The title field is required.'");
    }

    public boolean isAddGalleryFirstMessagePresent() {
        boolean isPres = isElementPresent(By.xpath("//div[@class = 'form-group col-md-12']/p[contains(text(), 'Чтобы добавить фотографии, создайте фотогалерею, затем перейдите на страницу редактирования фотогалереи!') or contains(text(), 'To upload photos, create a photo gallery, then go to the photo gallery editing page!')]"));
        if (isPres) log("Message 'Add gallery first' is on the page");
        else log("There is no message 'Add gallery first' is on the page");
        return isPres;

    }

    public boolean isFileContainerPresent() {
        boolean isPres = isElementPresent(By.xpath("//div[@class = 'well well-sm file-preview-container']"));
        if (isPres) log("File container is on the page");
        else log("There is no file container on the page");
        return isPres;
    }
}
