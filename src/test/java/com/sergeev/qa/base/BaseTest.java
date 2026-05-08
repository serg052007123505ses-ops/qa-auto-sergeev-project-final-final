package com.sergeev.qa.base;

import com.codeborne.selenide.Selenide;
import com.sergeev.qa.driver.DriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Базовый класс для всех тестов
 * Содержит setup и teardown методы
 */
public class BaseTest {

    @BeforeEach
    @Step("Инициализация браузера")
    public void setUp() {
        DriverManager.initDriver();
    }

    @AfterEach
    @Step("Закрытие браузера")
    public void tearDown() {
        DriverManager.closeDriver();
    }

    protected void attachScreenshot(String name) {
        Selenide.screenshot(name);
    }
}