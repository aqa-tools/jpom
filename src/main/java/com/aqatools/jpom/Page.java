package com.aqatools.jpom;

import com.aqatools.jpom.ui.Container;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by schipiga on 15.02.17.
 */
public abstract class Page extends Container {

    private String URL;

    protected App app;
    protected WebDriver webDriver;
    protected By locator = By.tagName("html");

    public Page() {
    }

    public void setApp(final App app) {
        this.app = app;
        this.webDriver = app.getWebDriver();
    }

    public WebDriver getWebDriver() {
        if (webDriver == null) {
            throw new RuntimeException("Webdriver is not defined");
        }
        return webDriver;
    }

    public void refresh() {
        webDriver.navigate().refresh();
    }

    public void open() {
        app.open(URL);
    }

    public void forward() {
        webDriver.navigate().forward();
    }

    public void back() {
        webDriver.navigate().back();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public WebElement findElement(By locator) {
        return webDriver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return webDriver.findElements(locator);
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
