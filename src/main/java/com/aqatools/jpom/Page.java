package com.aqatools.jpom;

import com.aqatools.jpom.ui.Container;
import com.aqatools.jpom.ui.UI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by schipiga on 15.02.17.
 */
public abstract class Page extends Container {

    protected String URL;

    protected WeakReference<App> app;
    protected WebDriver webDriver;

    public Page() {}

    public void setApp(App app) {
        this.app = new WeakReference<>(app);
        webDriver = app.getWebDriver();
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

    public String getTitle() {
        return webDriver.getTitle();
    }

    public WebElement findElement(By locator) {
        return webDriver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return webDriver.findElements(locator);
    }
}
