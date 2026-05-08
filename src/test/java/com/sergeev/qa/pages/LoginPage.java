package com.sergeev.qa.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object для страницы логина SauceDemo
 * Паттерн: PageObject
 * Уровень тестирования: Функциональное (Functional Testing)
 */
public class LoginPage extends BasePage {

    private static final String USERNAME_INPUT = "[data-test='username']";
    private static final String PASSWORD_INPUT = "[data-test='password']";
    private static final String LOGIN_BUTTON = "[data-test='login-button']";
    private static final String ERROR_MESSAGE = "[data-test='error']";

    private SelenideElement usernameInput = $(USERNAME_INPUT);
    private SelenideElement passwordInput = $(PASSWORD_INPUT);
    private SelenideElement loginButton = $(LOGIN_BUTTON);
    private SelenideElement errorMessage = $(ERROR_MESSAGE);

    @Step("Открыть страницу логина")
    public void openLoginPage() {
        openBaseUrl();
    }

    @Step("Ввести логин: {username}")
    public LoginPage enterUsername(String username) {
        type(usernameInput, username);
        return this;
    }

    @Step("Ввести пароль: {password}")
    public LoginPage enterPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    @Step("Нажать кнопку Login")
    public InventoryPage clickLoginButton() {
        click(loginButton);
        return new InventoryPage();
    }

    @Step("Выполнить логин с учетными данными: {username}/{password}")
    public InventoryPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        return clickLoginButton();
    }

    @Step("Получить текст ошибки")
    public String getErrorMessage() {
        return getText(errorMessage);
    }

    @Step("Проверить видимость сообщения об ошибке")
    public boolean isErrorMessageVisible() {
        return isElementVisible(errorMessage);
    }
}