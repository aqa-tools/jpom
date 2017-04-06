package com.aqatools.jpom.ui;

import org.openqa.selenium.By;

/**
 * Created by user on 04.03.17.
 */
public class IntegerField extends TextField {

    public IntegerField(By locator) {
        super(locator);
    }

    public String getValue() {
        waitForPresence(null);
        return webElement().getAttribute("value");
    }
}