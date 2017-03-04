package com.aqatools.jpom.ui;

import com.aqatools.jpom.Runner;
import com.aqatools.jpom.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

/**
 * Created by user on 10.02.17.
 */
public abstract class UI {

    protected static int TIMEOUT = 30;

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
        waitForPresence(null);
        webElement().click();
    }

    public String getValue() {
        waitForPresence(null);
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
        waitForPresence(null);
        return webElement().isEnabled();
    }

    public void waitForPresence(Integer timeout) {
        UI that = this;
        timeout = timeout != null ? timeout : TIMEOUT;
        boolean isOk = Utils.wait(new Runner() {
            public boolean exec() {
                return that.isPresent();
            }
        }, timeout);
        if (!isOk)
            throw new RuntimeException("Object is still absent");
    }

    public void waitForAbsence(Integer timeout) {
        UI that = this;
        timeout = timeout != null ? timeout : TIMEOUT;
        boolean isOk = Utils.wait(new Runner() {
            public boolean exec() {
                return !that.isPresent();
            }
        }, timeout);
        if (!isOk)
            throw new RuntimeException("Object is still present");
    }

    protected WebElement webElement() {
        if (index == null)
            return container.findElement(locator);
        else
            return container.findElements(locator).get(index);
    }
}
