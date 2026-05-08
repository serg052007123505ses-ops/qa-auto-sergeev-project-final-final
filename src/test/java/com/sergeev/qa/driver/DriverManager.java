package com.sergeev.qa.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.sergeev.qa.config.ConfigLoader;

import static com.codeborne.selenide.Browsers.CHROME;

public class DriverManager {

    public static void initDriver() {
        Configuration.browser = CHROME;
        Configuration.browserSize = ConfigLoader.getConfig().getWebBrowserSize();
        Configuration.pageLoadTimeout = ConfigLoader.getConfig().getWebPageLoadTimeout();
        Configuration.timeout = ConfigLoader.getConfig().getWebTimeout();
        Configuration.headless = ConfigLoader.getConfig().isWebHeadless();
        Configuration.remote = ConfigLoader.getConfig().isWebRemote() ? ConfigLoader.getConfig().getWebRemoteUrl() : null;
        Configuration.screenshots = true;
        Configuration.savePageSource = true;
        Configuration.holdBrowserOpen = false;
    }

    public static void closeDriver() {
        Selenide.closeWebDriver();
    }
}