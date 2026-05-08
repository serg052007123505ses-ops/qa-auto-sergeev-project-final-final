package com.sergeev.qa.pages;

import com.codeborne.selenide.SelenideElement;
import com.sergeev.qa.config.ConfigLoader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Базовый класс для всех Page Objects
 * Реализует паттерн PageObject
 */
public class BasePage {

    public void openPage(String path) {
        open(ConfigLoader.getConfig().getWebBaseUrl() + path);
    }

    public void openBaseUrl() {
        open(ConfigLoader.getConfig().getWebBaseUrl());
    }

    protected SelenideElement findElement(String selector) {
        return $(selector);
    }

    protected void click(SelenideElement element) {
        element.click();
    }

    protected void type(SelenideElement element, String text) {
        element.clear();
        element.type(text);
    }

    protected String getText(SelenideElement element) {
        return element.text();
    }

    protected boolean isElementVisible(SelenideElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected void waitForElement(SelenideElement element) {
        element.shouldBe(com.codeborne.selenide.Condition.visible);
    }
}