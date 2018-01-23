package ru.st.selenium.listeners;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

public class WebEventListener extends AbstractWebDriverEventListener implements WebDriverEventListener {

    public final Logger log = Logger.getLogger(this.getClass().getSimpleName());

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {

    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {

    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
//        log("Trying to find element: " + element.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
 //       log("Element: " + element.toString() + " has been found");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        log("Trying to click at " + element.toString());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        log("Clicked at " + element.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }

    public void log(String text) {
        log.info(text);
        Reporter.log(text);
    }
}
