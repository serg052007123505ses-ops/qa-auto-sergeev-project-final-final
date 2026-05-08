package com.sergeev.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:application.properties")
public interface Config extends org.aeonbits.owner.Config {

    @Key("web.baseUrl")
    @Default("https://www.saucedemo.com")
    String getWebBaseUrl();

    @Key("web.browser")
    @Default("chrome")
    String getWebBrowser();

    @Key("web.browserVersion")
    @Default("100")
    String getWebBrowserVersion();

    @Key("web.browserSize")
    @Default("1920x1080")
    String getWebBrowserSize();

    @Key("web.pageLoadTimeout")
    @Default("10000")
    int getWebPageLoadTimeout();

    @Key("web.timeout")
    @Default("10000")
    int getWebTimeout();

    @Key("web.headless")
    @Default("false")
    boolean isWebHeadless();

    @Key("web.isRemote")
    @Default("false")
    boolean isWebRemote();

    @Key("web.remoteUrl")
    @Default("https://selenoid.autotests.cloud/")
    String getWebRemoteUrl();

    @Key("api.baseUrl")
    @Default("https://dummyapi.io/api")
    String getApiBaseUrl();

    @Key("api.appId")
    @Default("your_app_id_here")
    String getApiAppId();

    @Key("api.timeout")
    @Default("10000")
    int getApiTimeout();

    @Key("threads")
    @Default("1")
    int getThreads();
}