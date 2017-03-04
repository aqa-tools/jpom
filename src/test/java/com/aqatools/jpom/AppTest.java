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
        app = new TestApp("https://yandex.ru", "chrome");
    }

    @Test
    public void startApplication() throws InterruptedException {
        app.testPage.open();
        TimeUnit.SECONDS.sleep(3);
        app.testPage.fieldQuery.setValue("yandex");
        app.testPage.buttonFind.click();
        TimeUnit.SECONDS.sleep(3);
    }

    @After
    public void TearDown() {
        app.quit();
    }
}
