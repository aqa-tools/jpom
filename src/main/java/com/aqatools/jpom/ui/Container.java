package com.aqatools.jpom.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by user on 10.02.17.
 */
public abstract class Container extends UI {

    protected Container() {}

    public Container(By locator) {
        super(locator);
    }

    public void initUI() {
        //TODO: remove reflection
        Class cls = this.getClass();
        for (Field f: cls.getDeclaredFields()) {
            try {
                UI ui = (UI) f.get(this);
                ui.setContainer(this);
            } catch (IllegalAccessException e) {
                System.out.println(e);
            }
        }
    }

    public WebElement findElement(By locator) {
        return webElement().findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return webElement().findElements(locator);
    }
}
