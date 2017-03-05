package com.aqatools.jpom.ui.proxy;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by user on 05.03.17.
 */
public class WebElementHandler implements InvocationHandler {

    private WebElementGetter webElementGetter;
    private WebElement webElement;

    public WebElementHandler(WebElementGetter getter) {
        webElementGetter = getter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            webElement = webElement != null ? webElement : webElementGetter.get();
            return method.invoke(webElement, args);
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            WebElement webElement = webElementGetter.get();
            return method.invoke(webElement, args);
        }
    }
}
