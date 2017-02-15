package com.aqatools.jpom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.ref.WeakReference;

/**
 * Created by schipiga on 15.02.17.
 */
public abstract class Page {

    protected static final String URL = null;

    protected WeakReference<App> app;
    protected WebDriver webDriver;
    protected WebElement webElement;

    public Page() { super(); }

    public Page(App app) {
        this.app = new WeakReference<>(app);
        webDriver = app.getWebDriver();
        webElement = webDriver.findElement(By.tagName("html"));
    }

    public void refresh() {
        webDriver.navigate().refresh();
    }

    public void open() {
        app.get().open(URL);
    }

    public void forward() {
        webDriver.navigate().forward();
    }

    public void back() {
        webDriver.navigate().back();
    }
}
