package com.aqatools.jpom;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public abstract class App
{
    protected String appUrl;
    protected WebDriver webDriver;

    public App() {}

    public App(String url, String browser) {

        appUrl = url.replaceAll("/+$", "");

        if (browser.equals("firefox")) {
            FirefoxDriverManager.getInstance().setup();
            webDriver = new FirefoxDriver();
        }
        if (browser.equals("chrome")) {
            ChromeDriverManager.getInstance().setup();
            webDriver = new ChromeDriver();
        }
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public void initPages() {
        Class cls = this.getClass();
        for (Field f: cls.getDeclaredFields()) {
            try {
                Page p = (Page) f.get(this);
                p.setApp(this);
            } catch (IllegalAccessException e) {
                System.out.println(e);
            }
        }
    }

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
        String currentUrl = webDriver.getCurrentUrl();

        Map<String, Page> pages = new HashMap<>();

        Class c = this.getClass();
        for (Field f : c.getDeclaredFields()) {
            try {
                Page p = (Page) f.get(this);
                pages.put(p.URL, p);
                pages.put("he", p);
            } catch (IllegalAccessException e) {
                continue;
            }
        }
        Object[] keys = pages.keySet().toArray();
        Arrays.sort(keys, new java.util.Comparator<Object>() {
            @Override
            public int compare(Object s1, Object s2) {
                // TODO: Argument validation (nullity, length)
                return ((String) s2).length() - ((String) s1).length();// comparision
            }
        });

        for(Object key: keys) {
            String url = (String) key;
            if (currentUrl.contains(url))
                return pages.get(url);
        }
        return null;
    }
}
