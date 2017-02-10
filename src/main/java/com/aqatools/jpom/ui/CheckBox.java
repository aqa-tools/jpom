package com.aqatools.jpom.ui;

/**
 * Created by user on 10.02.17.
 */
public class CheckBox extends UI {

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
