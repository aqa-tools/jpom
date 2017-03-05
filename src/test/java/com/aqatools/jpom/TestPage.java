package com.aqatools.jpom;

import org.openqa.selenium.By;

/**
 * Created by schipiga on 15.02.17.
 */
public final class TestPage extends Page {

    public BlockSearch blockSearch = new BlockSearch(By.className("home-arrow__search-wrapper"));

    public TestPage() {
        URL = "/";
        initUI();
    }
}
