package com.aqatools.jpom;

import com.aqatools.jpom.ui.Block;
import org.openqa.selenium.By;

/**
 * Created by user on 04.03.17.
 */
public class BlockSearch extends Block {

    public BlockSearch blockSearch = new BlockSearch(By.className("home-arrow__search-wrapper"));

    public BlockSearch(By locator) {
        super(locator);
        initUI();
    }
}
