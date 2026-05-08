package com.sergeev.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Page Object для страницы каталога товаров
 * Паттерн: PageObject
 * Уровень тестирования: Функциональное (Functional Testing)
 */
public class InventoryPage extends BasePage {

    private static final String PRODUCT_SORT = "[data-test='product_sort_container']";
    private static final String ADD_TO_CART_BUTTON = "[data-test='add-to-cart-sauce-labs-backpack']";
    private static final String CART_BUTTON = "[data-test='shopping-cart-link']";
    private static final String PRODUCT_NAME = ".inventory_item_name";
    private static final String PRODUCT_PRICE = ".inventory_item_price";

    private SelenideElement productSort = $(PRODUCT_SORT);
    private SelenideElement addToCartButton = $(ADD_TO_CART_BUTTON);
    private SelenideElement cartButton = $(CART_BUTTON);
    private ElementsCollection productNames = $$(PRODUCT_NAME);
    private ElementsCollection productPrices = $$(PRODUCT_PRICE);

    @Step("Проверить видимость страницы каталога")
    public boolean isInventoryPageVisible() {
        return isElementVisible(productSort);
    }

    @Step("Получить сортировку товаров")
    public SelenideElement getSortDropdown() {
        return productSort;
    }

    @Step("Выбрать сортировку: {option}")
    public InventoryPage selectSort(String option) {
        click(productSort);
        $("[data-test='product_sort_container'] option[value='" + option + "']").click();
        return this;
    }

    @Step("Добавить товар в корзину")
    public InventoryPage addProductToCart(String productId) {
        SelenideElement button = $("[data-test='add-to-cart-" + productId + "']");
        click(button);
        return this;
    }

    @Step("Добавить товар Sauce Labs Backpack в корзину")
    public InventoryPage addBackpackToCart() {
        click(addToCartButton);
        return this;
    }

    @Step("Перейти в корзину")
    public CartPage goToCart() {
        click(cartButton);
        return new CartPage();
    }

    @Step("Получить количество товаров")
    public int getProductCount() {
        return productNames.size();
    }

    @Step("Получить название товара по индексу {index}")
    public String getProductName(int index) {
        return productNames.get(index).text();
    }

    @Step("Получить цену товара по индексу {index}")
    public String getProductPrice(int index) {
        return productPrices.get(index).text();
    }
}