package com.aqatools.jpom.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10.02.17.
 */
public class ComboBox extends UI {

    @Override
    public String getValue() {
        return select()
                .getFirstSelectedOption()
                .getAttribute("innerHTML")
                .trim();
    }

    public void setValue(String value) throws Exception {
        if (getValue().contains(value))
                return;

        List<String> values = getValues();
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).contains(value)) {
                select().selectByIndex(i);
                return;
            }
        }
        throw new Exception(value + " is absent for combobox");
    }

    public List<String> getValues() {
        List<String> values = new ArrayList<>();
        for (WebElement elem: select().getOptions())
            values.add(elem.getAttribute("innerHTML").trim());
        return values;
    }

    protected Select select() {
        return new Select(webElement());
    }
}
