package com.aqatools.jpom.ui;

import org.openqa.selenium.By;

/**
 * Created by user on 05.03.17.
 */
public class Form extends Block {

    public Form(By locator) {
        super(locator);
    }

    public void submit() {
        waitForPresence(null);
        webElement().submit();
    }
}
