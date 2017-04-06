package com.aqatools.jpom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/**
 * Created by schipiga on 17.02.17.
 */
public class AppTest {

    TestApp app;

    @Before
    public void SetUp() {
        app = new TestApp("https://yandex.ru", "firefox");
    }

    @Test
    public void startApplication() {
        app.testPage.open();
        app.testPage.blockSearch.fieldQuery.setValue("yandex");
        app.testPage.blockSearch.buttonFind.click();
        app.resultPage.blockResult.waitForPresence(null);
        System.out.println(app.getCurrentPage());
    }

    @After
    public void TearDown() {
        app.quit();
    }
}
