package com.sergeev.qa.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object для страницы оформления заказа
 * Паттерн: PageObject
 * Уровень тестирования: Функциональное (Functional Testing)
 */
public class CheckoutPage extends BasePage {

    private static final String FIRST_NAME = "[data-test='firstName']";
    private static final String LAST_NAME = "[data-test='lastName']";
    private static final String ZIP_CODE = "[data-test='postalCode']";
    private static final String CONTINUE_BUTTON = "[data-test='continue']";
    private static final String FINISH_BUTTON = "[data-test='finish']";

    private SelenideElement firstNameInput = $(FIRST_NAME);
    private SelenideElement lastNameInput = $(LAST_NAME);
    private SelenideElement zipCodeInput = $(ZIP_CODE);
    private SelenideElement continueButton = $(CONTINUE_BUTTON);
    private SelenideElement finishButton = $(FINISH_BUTTON);

    @Step("Ввести имя: {firstName}")
    public CheckoutPage enterFirstName(String firstName) {
        type(firstNameInput, firstName);
        return this;
    }

    @Step("Ввести фамилию: {lastName}")
    public CheckoutPage enterLastName(String lastName) {
        type(lastNameInput, lastName);
        return this;
    }

    @Step("Ввести почтовый индекс: {zipCode}")
    public CheckoutPage enterZipCode(String zipCode) {
        type(zipCodeInput, zipCode);
        return this;
    }

    @Step("Нажать Continue")
    public CheckoutPage clickContinue() {
        click(continueButton);
        return this;
    }

    @Step("Нажать Finish")
    public CheckoutPage clickFinish() {
        click(finishButton);
        return this;
    }

    @Step("Заполнить данные и продолжить")
    public CheckoutPage fillCheckoutData(String firstName, String lastName, String zipCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterZipCode(zipCode);
        return clickContinue();
    }

    @Step("Завершить заказ")
    public void completeOrder() {
        clickFinish();
    }
}