package com.aqatools.jpom.ui;

import org.openqa.selenium.By;

/**
 * Created by user on 04.03.17.
 */
public class TextField extends UI {

    public TextField(By locator) {
        super(locator);
    }

    public String getValue() {
        waitForPresence(null);
        String text = webElement().getText();
        if (text == null || text.equals(""))
            text = webElement().getAttribute("value");
        return text;
    }

    public void setValue(String value) {
        waitForPresence(null);
        webElement().clear();
        webElement().sendKeys(value);
    }
}
