package com.aqatools.jpom.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

/**
 * Created by user on 10.02.17.
 */
public abstract class UI {

    protected By locator;
    protected Container container;
    protected Integer index = null;

    protected UI() {}

    public UI(By locator) {
        this.locator = locator;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public void click() {
        webElement().click();
    }

    public String getValue() {
        return webElement().getAttribute("innerHTML").trim();
    }

    public boolean isPresent() {
        try {
            return webElement().isDisplayed();
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            return false;
        }
    }

    public boolean isEnabled() {
        return webElement().isEnabled();
    }

    protected WebElement webElement() {
        if (index == null)
            return container.findElement(locator);
        else
            return container.findElements(locator).get(index);
    }
}
