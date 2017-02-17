package com.aqatools.jpom.ui;

import org.openqa.selenium.By;

/**
 * Created by user on 10.02.17.
 */
public class CheckBox extends UI {

    public CheckBox(By locator) {
        super(locator);
    }

    public boolean isSelected() {
        return webElement().isSelected();
    }

    public void select() {
        if (!isSelected())
            webElement().click();
    }

    public void unselect() {
        if (isSelected())
            webElement().click();
    }
}
