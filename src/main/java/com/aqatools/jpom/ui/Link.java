package com.aqatools.jpom.ui;

import org.openqa.selenium.By;

/**
 * Created by user on 05.03.17.
 */
public class Link extends UI {

    public Link(By locator) {
        super(locator);
    }

    public String getHref() {
        return webElement().getAttribute("href");
    }
}
