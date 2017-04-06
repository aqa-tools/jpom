package com.aqatools.jpom;

/**
 * Created by schipiga on 15.02.17.
 */
public final class TestApp extends App {

    public TestPage testPage = new TestPage();
    public ResultPage resultPage = new ResultPage();

    public TestApp(String url, String browser) {
        super(url, browser);
        initPages();
        webDriver.manage().window().maximize();
    }
}
