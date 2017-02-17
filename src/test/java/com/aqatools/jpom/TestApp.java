package com.aqatools.jpom;

/**
 * Created by schipiga on 15.02.17.
 */
public class TestApp extends App {

    public TestPage testPage = new TestPage();

    public TestApp(String url, String browser) {
        super(url, browser);
        webDriver.manage().window().maximize();
        initFields();
    }
}
