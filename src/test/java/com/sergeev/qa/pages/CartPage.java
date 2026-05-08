package com.sergeev.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Page Object для страницы корзины
 * Паттерн: PageObject
 * Уровень тестирования: Функциональное (Functional Testing)
 */
public class CartPage extends BasePage {

    private static final String CHECKOUT_BUTTON = "[data-test='checkout']";
    private static final String CART_ITEM = ".cart_item";
    private static final String CART_QUANTITY = ".cart_quantity";

    private SelenideElement checkoutButton = $(CHECKOUT_BUTTON);
    private ElementsCollection cartItems = $$(CART_ITEM);
    private ElementsCollection cartQuantities = $$(CART_QUANTITY);

    @Step("Проверить видимость кнопки Checkout")
    public boolean isCheckoutButtonVisible() {
        return isElementVisible(checkoutButton);
    }

    @Step("Получить количество товаров в корзине")
    public int getCartItemCount() {
        return cartItems.size();
    }

    @Step("Нажать кнопку Checkout")
    public CheckoutPage clickCheckout() {
        click(checkoutButton);
        return new CheckoutPage();
    }

    @Step("Проверить, что товар в корзине")
    public boolean isItemInCart(String itemName) {
        return cartItems.stream()
                .anyMatch(item -> item.text().contains(itemName));
    }
}