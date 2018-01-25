package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.st.selenium.model.TabItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public abstract class AdminCreateItemPage extends AdminInternalPage {
    public AdminCreateItemPage(PageManager pages) {
        super(pages);
    }



    private ArrayList<String> chosenCheckboxes = new ArrayList<String>();

    private final String ADD_FILE_BUTTON_LOCATOR = "//input[@id = 'uploadImage']";
    private final String SUBMIT_BUTTON_LOCATOR = "//button[@type = 'submit']";
    private final String CANCEL_BUTTON_LOCATOR = "//div[@id = 'saveActions']//a[@class = 'btn btn-default']";
    protected final String TEXT_FRAME_LOCATOR = "//iframe[1]";

    protected final String PAGE_NAME_FIELD_LOCATOR = "//input[@name = 'name']";
    protected final String TITLE_FIELD_LOCATOR = "//input[@name = 'title']";
    protected final String SLUG_FIELD_LOCATOR = "//input[@name = 'slug']";
    protected final String DATE_FIELD_LOCATOR = "//input[@id = 'input_calendar']";
    protected final String DESCRIPTION_FIELD_LOCATOR = "//textarea[@name = 'description']";
    protected final String META_TITLE_FIELD_LOCATOR = "//input[@name = 'meta_title_en']";
    protected final String SOCIAL_META_TITLE_FIELD_LOCATOR = "//input[@name = 'social_meta_title_en']";
    protected final String META_DESCRIPTION_FIELD_LOCATOR = "//textarea[@name = 'meta_description_en']";
    protected final String SOCIAL_META_DESCRIPTION_FIELD_LOCATOR = "//textarea[@name = 'social_meta_description_en']";
    protected final String META_KEYWORDS_LOCATOR = "//textarea[@name = 'meta_keywords_en']";

    protected final String RUS_TITLE_FIELD_LOCATOR = "//input[@name = 'title_ru']";
    protected final String RUS_DESCRIPTION_FIELD_LOCATOR = "//textarea[@name = 'description_ru']";
    protected final String RUS_META_TITLE_FIELD_LOCATOR = "//input[@name = 'meta_title_ru']";
    protected final String RUS_SOCIAL_META_TITLE_FIELD_LOCATOR = "//input[@name = 'social_meta_title_ru']";
    protected final String RUS_META_DESCRIPTION_FIELD_LOCATOR = "//textarea[@name = 'meta_description_ru']";
    protected final String RUS_SOCIAL_META_DESCRIPTION_FIELD_LOCATOR = "//textarea[@name = 'social_meta_description_ru']";
    protected final String RUS_META_KEYWORDS_LOCATOR = "//textarea[@name = 'meta_keywords_ru']";
    protected final String RUS_TAB_LOCATOR = "//a[@aria-controls = 'tab_rus']";

    protected String imageDirectory = System.getProperty("user.dir") + "\\src\\main\\resources\\uploads\\test.png";


    @FindBy(xpath = ADD_FILE_BUTTON_LOCATOR)
    WebElement addFileButton;

    @FindBy(xpath = SUBMIT_BUTTON_LOCATOR)
    WebElement submitButton;

    @FindBy(xpath = CANCEL_BUTTON_LOCATOR)
    WebElement cancelButton;

    @FindBy(xpath = TEXT_FRAME_LOCATOR)
    WebElement textFrame;

    public void addFile(String path) {
        wait.until(presenceOfElementLocated(By.xpath(ADD_FILE_BUTTON_LOCATOR)));
        driver.findElement(By.xpath(ADD_FILE_BUTTON_LOCATOR)).sendKeys(path);
        ensureFileAdded();
    }

    public void ensureFileAdded() {
        wait.until(presenceOfElementLocated(By.xpath("//div[@class = 'cropper-container cropper-bg']")));
        log("File was added succsessfully");
    }

    public void pressSubmitButton() {
        log("Trying to click submit button");
        submitButton.click();
        log("Submit button was clicked");
    }

    public void pressCancelButton() {
        log("Trying to click cancel button");
        cancelButton.click();
        log("Cancel button was clicked");
    }

    public void typeTextToTextField(String text) {
        driver.switchTo().frame(textFrame);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("document.getElementsByTagName('g').innerHTML = 'Sample text'");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().defaultContent();
    }

    public void chooseRandomDateInNextMonth() {
        driver.findElement(By.xpath(DATE_FIELD_LOCATOR)).click();
        driver.findElement(By.xpath("//span[@title = 'Next Month']")).click();
        Random random = new Random();
        int randomNumber = random.nextInt(30) + 1;
        System.out.println("Random number is " + randomNumber);
        driver.findElement(By.xpath("//table[@class = 'table-condensed']//tbody//td[contains(text(), '"+randomNumber+"')]")).click();
    }

    public void clickRusTab() {
        driver.findElement(By.xpath(RUS_TAB_LOCATOR)).click();
        log("Rus tab was clicked");
    }

    public void fillAllFieldsWithData(Object obj) {

    }

    public void putThreeRandomCheckboxes() {
        List<WebElement> clubs = driver.findElements(By.xpath("//div[@class = 'checkbox']"));
        Random randomGenerator = new Random();
        int index1;
        int index2;
        int index3;
        index1 = randomGenerator.nextInt(clubs.size()-1)+1;
        while (true) {
            index2 = randomGenerator.nextInt(clubs.size()-1)+1;
            if (index2 != index1) break;
        }
        while (true) {
            index3 = randomGenerator.nextInt(clubs.size()-1)+1;
            if (index3 != index1 && index3 != index2) break;
        }

        try{
            String club1 = driver.findElement(By.xpath("//div[@class = 'col-sm-4']["+ (index1+1) +"]//label")).getText();
            String checkbox1 = "//div[@class = 'col-sm-4']["+ (index1+1) +"]//label/input";
            clubs.get(index1).findElement(By.xpath(checkbox1)).click();
            chosenCheckboxes.add(club1);
        } catch (Exception e) {

        }

        try {
            String club2 = driver.findElement(By.xpath("//div[@class = 'col-sm-4']["+ (index2+1) +"]//label")).getText();
            String checkbox2 = "//div[@class = 'col-sm-4']["+ (index2+1) +"]//label/input";
            clubs.get(index2).findElement(By.xpath(checkbox2)).click();
            chosenCheckboxes.add(club2);
        } catch (Exception e) {

        }

        try{
            String club3 = driver.findElement(By.xpath("//div[@class = 'col-sm-4']["+ (index3+1) +"]//label")).getText();
            String checkbox3 = "//div[@class = 'col-sm-4']["+ (index3+1) +"]//label/input";
            clubs.get(index3).findElement(By.xpath(checkbox3)).click();
            chosenCheckboxes.add(club3);
        } catch (Exception e) {

        }

    }

    public ArrayList<String> getChosenCheckboxes() {
        return chosenCheckboxes;
    }

    public boolean isCheckboxInTheList(String checkbox) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(., '"+checkbox+"')]")));
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public void sendKeysToTitleField(TabItem tabItem) {
        driver.findElement(By.xpath(TITLE_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(TITLE_FIELD_LOCATOR)).sendKeys(tabItem.getTitle());
        log("Title '" + tabItem.getTitle() + "' was typed to title field");
    }

    public void sendKeysToRusTitleField(TabItem tabItem) {
        driver.findElement(By.xpath(RUS_TITLE_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(RUS_TITLE_FIELD_LOCATOR)).sendKeys(tabItem.getRusTitle());
        log("Title '" + tabItem.getRusTitle() + "' was typed to rus title field");
    }

    public void sendKeysToDescriptionField(TabItem tabItem) {
        driver.findElement(By.xpath(DESCRIPTION_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(DESCRIPTION_FIELD_LOCATOR)).sendKeys(tabItem.getDescription());
        log("Description '" + tabItem.getDescription() + "' was typed to description field");
    }

    public void sendKeysToRusDescriptionField(TabItem tabItem) {
        driver.findElement(By.xpath(RUS_DESCRIPTION_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(RUS_DESCRIPTION_FIELD_LOCATOR)).sendKeys(tabItem.getRusDescription());
        log("Rus Description '" + tabItem.getRusDescription() + "' was typed to rus description field");
    }

    public void sendKeysToSlugField(TabItem tabItem) {
        driver.findElement(By.xpath(SLUG_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(SLUG_FIELD_LOCATOR)).sendKeys(tabItem.getSlug());
        log("Slug '" + tabItem.getRusDescription() + "' was typed to slug field");
    }

    public void sendKeysToTextField(TabItem tabItem) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id = 'cke_1_contents']/iframe")));
        WebElement frame = driver.findElement(By.xpath("//div[@id = 'cke_1_contents']/iframe"));
        driver.switchTo().frame(frame);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body")));
        WebElement editor = driver.findElement(By.xpath("//body"));
        editor.clear();
        editor.sendKeys(tabItem.getText());
        driver.switchTo().defaultContent();
        log("Text '" + tabItem.getText() + "' was typed to text field");
    }

    public void sendKeysToRusTextField(TabItem tabItem) {
        WebElement frame = driver.findElement(By.xpath("//div[@id = 'cke_2_contents']/iframe"));
        driver.switchTo().frame(frame);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body")));
        WebElement editor = driver.findElement(By.xpath("//body"));
        editor.clear();
        editor.sendKeys(tabItem.getRusText());
        driver.switchTo().defaultContent();
        log("Rus text '" + tabItem.getRusText() + "' was typed to rus text field");
    }

    public void sendKeysToMetaTitle(TabItem tabItem) {
        driver.findElement(By.xpath(META_TITLE_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(META_TITLE_FIELD_LOCATOR)).sendKeys(tabItem.getMetaTitle());
        log("Metatatitle '" + tabItem.getMetaTitle() + "' was typed to metatitle field");
    }

    public void sendKeysToRusMetaTitle(TabItem tabItem) {
        driver.findElement(By.xpath(RUS_META_TITLE_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(RUS_META_TITLE_FIELD_LOCATOR)).sendKeys(tabItem.getRusMetaTitle());
        log("Rus Metatatitle '" + tabItem.getRusMetaTitle() + "' was typed to rus metatitle field");
    }

    public void sendKeysToSocialMetaTitle(TabItem tabItem) {
        driver.findElement(By.xpath(SOCIAL_META_TITLE_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(SOCIAL_META_TITLE_FIELD_LOCATOR)).sendKeys(tabItem.getSocialMetaTitle());
        log("Social metatatitle '" + tabItem.getSocialMetaTitle() + "' was typed to social metatitle field");
    }

    public void sendKeysToRusSocialMetaTitle(TabItem tabItem) {
        driver.findElement(By.xpath(RUS_SOCIAL_META_TITLE_FIELD_LOCATOR)).sendKeys(tabItem.getRusSocialMetaTitle());
        log("Rus social metatatitle '" + tabItem.getSocialMetaTitle() + "' was typed to rus social metatitle field");
    }

    public void sendKeysToMetaDescription(TabItem tabItem) {
        driver.findElement(By.xpath(META_DESCRIPTION_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(META_DESCRIPTION_FIELD_LOCATOR)).sendKeys(tabItem.getMetaDescription());
        log("Metatadescription '" + tabItem.getMetaDescription() + "' was typed to metadescription field");
    }

    public void sendKeysToRusMetaDescription(TabItem tabItem) {
        driver.findElement(By.xpath(RUS_META_DESCRIPTION_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(RUS_META_DESCRIPTION_FIELD_LOCATOR)).sendKeys(tabItem.getRusMetaDescription());
        log("Rus Metatadescription '" + tabItem.getRusMetaDescription() + "' was typed to rus metadescription field");
    }

    public void sendKeysToSocialMetaDescription(TabItem tabItem) {
        driver.findElement(By.xpath(SOCIAL_META_DESCRIPTION_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(SOCIAL_META_DESCRIPTION_FIELD_LOCATOR)).sendKeys(tabItem.getSocialMetaDescription());
        log("Social metatadescription '" + tabItem.getSocialMetaDescription() + "' was typed to social metadescription field");
    }

    public void sendKeysToRusSocialMetaDescription(TabItem tabItem) {
        driver.findElement(By.xpath(RUS_SOCIAL_META_DESCRIPTION_FIELD_LOCATOR)).clear();
        driver.findElement(By.xpath(RUS_SOCIAL_META_DESCRIPTION_FIELD_LOCATOR)).sendKeys(tabItem.getRusSocialMetaDescription());
        log("Rus Social Metatadescription '" + tabItem.getRusSocialMetaDescription() + "' was typed to rus social metadescription field");
    }

    public void sendKeysToMetaKeywords(TabItem tabItem) {
        driver.findElement(By.xpath(META_KEYWORDS_LOCATOR)).clear();
        driver.findElement(By.xpath(META_KEYWORDS_LOCATOR)).sendKeys(tabItem.getMetaKeywords());
        log("Meta keywords '" + tabItem.getMetaKeywords() + "' was typed to metakeywords field");
    }

    public void sendKeysToRusMetaKeywords(TabItem tabItem) {
        driver.findElement(By.xpath(RUS_META_KEYWORDS_LOCATOR)).clear();
        driver.findElement(By.xpath(RUS_META_KEYWORDS_LOCATOR)).sendKeys(tabItem.getRusMetaKeywords());
        log("Rus Meta keywords '" + tabItem.getRusMetaKeywords() + "' was typed to rus metakeywords field");
    }


}

