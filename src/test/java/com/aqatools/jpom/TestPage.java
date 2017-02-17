package com.aqatools.jpom;

import com.aqatools.jpom.ui.Button;
import org.openqa.selenium.By;

/**
 * Created by schipiga on 15.02.17.
 */
public class TestPage extends Page<TestPage> {

    public Button button = new Button(By.cssSelector("button.button_theme_websearch"));

    public TestPage() {
        URL = "/";
        button.setContainer(this);
    }
}
