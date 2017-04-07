package com.aqatools.jpom;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public abstract class App {
    private String appUrl;
    private WebDriver webDriver;

    public App(final String url, final String browser) {
        if (StringUtils.isBlank(url)) {
            throw new IllegalArgumentException("URL should not be null");
        }
        if (StringUtils.isBlank(browser)) {
            throw new IllegalArgumentException("Browser parameter should not be null");
        }
        appUrl = url.replaceAll("/+$", "");

        final String browserLower = browser.toLowerCase();
        switch (browserLower) {
            case "firefox":
                FirefoxDriverManager.getInstance().setup();
                webDriver = new FirefoxDriver();
                break;
            case "chrome":
                ChromeDriverManager.getInstance().setup();
                webDriver = new ChromeDriver();
                break;
            default:
                throw new IllegalArgumentException("Wrong browser name provided");
        }
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public abstract void initPages();

    public abstract List<Page> getAllPages();

    public void open(String url) {
        webDriver.get(appUrl + url);
    }

    public void quit() {
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public Page getCurrentPage() {
        final String currentUrl = webDriver.getCurrentUrl();

        final Map<String, Page> pages = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });

        for (Page page : getAllPages()) {
            pages.put(page.getURL(), page);
        }

        for (String url : pages.keySet()) {
            if (currentUrl.contains(url)) {
                return pages.get(url);
            }
        }
        throw new UnsupportedOperationException("URL not found");
    }

}
