package com.aqatools.jpom;

/**
 * Created by schipiga on 15.02.17.
 */
public class TestApp extends App {

    Page testPage;

    public TestApp(String url, String browser) {
        super(url, browser);
        testPage = new TestPage(this);
    }
}
