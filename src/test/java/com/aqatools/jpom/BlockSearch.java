package com.aqatools.jpom;

import com.aqatools.jpom.ui.Block;
import com.aqatools.jpom.ui.Button;
import com.aqatools.jpom.ui.TextField;
import org.openqa.selenium.By;

/**
 * Created by user on 04.03.17.
 */
public class BlockSearch extends Block {

    public Button buttonFind = new Button(By.cssSelector("button.button_theme_websearch"));
    public TextField fieldQuery = new TextField(By.name("text"));

    public BlockSearch(By locator) {
        super(locator);
        initUI();
    }
}
