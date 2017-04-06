package com.aqatools.jpom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by schipiga on 17.02.17.
 */
public interface Container {

    WebElement findElement(By locator);

    List<WebElement> findElements(By locator);
}
