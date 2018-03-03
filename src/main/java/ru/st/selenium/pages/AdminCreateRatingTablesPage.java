package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.st.selenium.model.RatingTable;
import ru.st.selenium.model.TabItem;

public class AdminCreateRatingTablesPage extends AdminCreateItemPage{
    public AdminCreateRatingTablesPage(PageManager pages) {
        super(pages);
    }

    public void fillAllFieldsWithData(TabItem tabItem) {
        RatingTable ratingTable = (RatingTable) tabItem;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TITLE_FIELD_LOCATOR)));
        sendKeysToTitleField(ratingTable);
        Select clubSelect = new Select(driver.findElement(By.xpath("//select[@name = 'club_id']")));
        if (!ratingTable.getClub().equals("")) {
            clubSelect.selectByVisibleText(ratingTable.getClub());
        }
        log("Club '" + ratingTable.getClub() + "' in select field was chosen");
        if (ratingTable.isShowInGlobal() && isElementPresent(By.xpath("//input[@name = 'check_glob' and @checked = 'checked']"))) {
            driver.findElement(By.xpath("//input[@name = 'check_glob']")).click();
            log("Show in global checkbox was set");
        }
        driver.findElement(By.xpath("//input[@name = 'win_citizen']")).clear();
        driver.findElement(By.xpath("//input[@name = 'win_citizen']")).sendKeys(ratingTable.getWinCitizen());
        driver.findElement(By.xpath("//input[@name = 'win_sheriff']")).clear();
        driver.findElement(By.xpath("//input[@name = 'win_sheriff']")).sendKeys(ratingTable.getWinSheriff());
        driver.findElement(By.xpath("//input[@name = 'win_mafia']")).clear();
        driver.findElement(By.xpath("//input[@name = 'win_mafia']")).sendKeys(ratingTable.getWinMafia());
        driver.findElement(By.xpath("//input[@name = 'win_don']")).clear();
        driver.findElement(By.xpath("//input[@name = 'win_don']")).sendKeys(ratingTable.getWinDon());

        driver.findElement(By.xpath("//input[@name = 'fail_citizen']")).clear();
        driver.findElement(By.xpath("//input[@name = 'fail_citizen']")).sendKeys(ratingTable.getFailCitizen());
        driver.findElement(By.xpath("//input[@name = 'fail_sheriff']")).clear();
        driver.findElement(By.xpath("//input[@name = 'fail_sheriff']")).sendKeys(ratingTable.getFailSheriff());
        driver.findElement(By.xpath("//input[@name = 'fail_mafia']")).clear();
        driver.findElement(By.xpath("//input[@name = 'fail_mafia']")).sendKeys(ratingTable.getFailMafia());
        driver.findElement(By.xpath("//input[@name = 'fail_don']")).clear();
        driver.findElement(By.xpath("//input[@name = 'fail_don']")).sendKeys(ratingTable.getFailDon());

        driver.findElement(By.xpath("//input[@name = 'best_player']")).clear();
        driver.findElement(By.xpath("//input[@name = 'best_player']")).sendKeys(ratingTable.getBestPlayer());
        driver.findElement(By.xpath("//input[@name = 'best_step']")).clear();
        driver.findElement(By.xpath("//input[@name = 'best_step']")).sendKeys(ratingTable.getBestStep());
        driver.findElement(By.xpath("//input[@name = 'citizen_killed']")).clear();
        driver.findElement(By.xpath("//input[@name = 'citizen_killed']")).sendKeys(ratingTable.getCoolPlayer());
        driver.findElement(By.xpath("//input[@name = 'prima_nota3']")).clear();
        driver.findElement(By.xpath("//input[@name = 'prima_nota3']")).sendKeys(ratingTable.getPrimaNota3());
        driver.findElement(By.xpath("//input[@name = 'prima_nota2']")).clear();
        driver.findElement(By.xpath("//input[@name = 'prima_nota2']")).sendKeys(ratingTable.getPrimaNota2());

        driver.findElement(By.xpath("//input[@name = 'formula']")).clear();
        driver.findElement(By.xpath("//input[@name = 'formula']")).sendKeys(ratingTable.getFormula());
    }

    public void checkRequiredFieldsMessages() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The title field is required.']")));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The title field is required.']"));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The best player field is required.']"));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The best step field is required.']"));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The win citizen field is required.']"));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The win sheriff field is required.']"));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The win mafia field is required.']"));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The win don field is required.']"));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The fail citizen field is required.']"));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The fail sheriff field is required.']"));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The fail mafia field is required.']"));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The fail don field is required.']"));
        driver.findElement(By.xpath("//div[@class = 'callout callout-danger']//li[text() = 'The citizen killed field is required.']"));

        driver.findElement(By.xpath("//label[contains(text(), 'Title')]/../..//div[@class = 'help-block' and text() = 'The title field is required.']"));
        driver.findElement(By.xpath("//label[contains(text(), 'Win: Citizen')]/../..//div[@class = 'help-block' and text() = 'The win citizen field is required.']"));
        driver.findElement(By.xpath("//label[contains(text(), 'Win: Sheriff')]/../..//div[@class = 'help-block' and text() = 'The win sheriff field is required.']"));
        driver.findElement(By.xpath("//label[contains(text(), 'Win: Mafia')]/../..//div[@class = 'help-block' and text() = 'The win mafia field is required.']"));
        driver.findElement(By.xpath("//label[contains(text(), 'Win: Don')]/../..//div[@class = 'help-block' and text() = 'The win don field is required.']"));
        driver.findElement(By.xpath("//label[contains(text(), 'Fail: Citizen')]/../..//div[@class = 'help-block' and text() = 'The fail citizen field is required.']"));
        driver.findElement(By.xpath("//label[contains(text(), 'Fail: Sheriff')]/../..//div[@class = 'help-block' and text() = 'The fail sheriff field is required.']"));
        driver.findElement(By.xpath("//label[contains(text(), 'Fail: Mafia')]/../..//div[@class = 'help-block' and text() = 'The fail mafia field is required.']"));
        driver.findElement(By.xpath("//label[contains(text(), 'Fail: Don')]/../..//div[@class = 'help-block' and text() = 'The fail don field is required.']"));
        driver.findElement(By.xpath("//label[contains(text(), 'Best Player')]/../..//div[@class = 'help-block' and text() = 'The best player field is required.']"));
        driver.findElement(By.xpath("//label[contains(text(), 'Best Step')]/../..//div[@class = 'help-block' and text() = 'The best step field is required.']"));
        driver.findElement(By.xpath("//label[contains(text(), 'Cool player')]/../..//div[@class = 'help-block' and text() = 'The citizen killed field is required.']"));
    }
}
