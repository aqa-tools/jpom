package com.aqatools.jpom;

import java.util.Arrays;
import java.util.List;

/**
 * Created by schipiga on 15.02.17.
 */
public final class TestApp extends App {

    private final TestPage TEST_PAGE = new TestPage();
    private final ResultPage RESULT_PAGE = new ResultPage();

    public TestApp(final String url, final String browser) {
        super(url, browser);
        initPages();
        getWebDriver().manage().window().maximize();
    }

    @Override
    public void initPages() {
        TEST_PAGE.setApp(this);
        RESULT_PAGE.setApp(this);
    }

    @Override
    public List<Page> getAllPages() {
        return Arrays.asList(TEST_PAGE, RESULT_PAGE);
    }

    public TestPage getTestPage() {
        return TEST_PAGE;
    }

    public ResultPage getResultPage() {
        return RESULT_PAGE;
    }

}
