package com.aqatools.jpom.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by user on 10.02.17.
 */
public class Container extends UI {

    public WebElement findElement(By locator) {
        return webElement().findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return webElement().findElements(locator);
    }
}
