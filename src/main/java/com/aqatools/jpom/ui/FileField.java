package com.aqatools.jpom.ui;

import org.openqa.selenium.By;

/**
 * Created by user on 05.03.17.
 */
public class FileField extends TextField {

    public FileField(By locator) {
        super(locator);
    }

    public String getValue() {
        waitForPresence(null);
        return webElement().getText();
    }
}
