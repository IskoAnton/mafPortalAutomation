package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PayPalPurchasePage extends AnyPage{
    public PayPalPurchasePage(PageManager pages) {
        super(pages);
    }

    private static final String CONTINUE_BUTTON_LOCATOR = "//input[@id = 'confirmButtonTop']";
    private static final String AMOUNT_OF_PURCHASE_LOCATOR = "//span[@ng-bind-html = 'amount_formatted']";

    @FindBy (xpath = CONTINUE_BUTTON_LOCATOR)
    private WebElement continueButton;

    @FindBy (xpath = AMOUNT_OF_PURCHASE_LOCATOR)
    private WebElement amountLocator;

    public void clickContinueButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'confirmButtonTop']")));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        continueButton.click();
        log("Continue button was clicked on PayPal purchase page");
    }

    public String getAmountOfPurchase() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(AMOUNT_OF_PURCHASE_LOCATOR)));
        String amount = amountLocator.getText();
        String[] amount2 = amount.split("\\.");
        String totalAmount = amount2[0].replaceAll(",", "");
        log("Amount of purchase is " + totalAmount + " on PayPal purchase page");
        return totalAmount;
    }
}
