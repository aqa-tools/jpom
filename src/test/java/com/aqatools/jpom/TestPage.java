package com.aqatools.jpom;

import com.aqatools.jpom.ui.Button;
import com.aqatools.jpom.ui.TextField;
import org.openqa.selenium.By;

/**
 * Created by schipiga on 15.02.17.
 */
public final class TestPage extends Page {

    public Button buttonFind = new Button(By.cssSelector("button.button_theme_websearch"));
    public TextField fieldQuery = new TextField(By.name("text"));

    public TestPage() {
        URL = "/";
        initUI();
    }
}
