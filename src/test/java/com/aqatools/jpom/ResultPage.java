package com.aqatools.jpom;

import com.aqatools.jpom.ui.Block;
import org.openqa.selenium.By;

/**
 * Created by user on 04.03.17.
 */
public class ResultPage extends Page {

    public Block blockResult = new Block(By.className("serp-list"));

    public ResultPage() {
        setURL("/search");
        initUI();
    }
}
