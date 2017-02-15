package com.aqatools.jpom;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

        if (browser.equals("firefox"))
            FirefoxDriverManager.getInstance().setup();
            webDriver = new FirefoxDriver();
        if (browser.equals("chrome"))
            ChromeDriverManager.getInstance().setup();
            webDriver = new ChromeDriver();
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

//    public Page getCurrentPage() {
//        String currentUrl = webDriver.getCurrentUrl();
//        return Page();
//    }
}