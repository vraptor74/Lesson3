package com.example.nikita_khoryakov_shop.presenter

import com.example.nikita_khoryakov_shop.HomeWork.Basket
import com.example.nikita_khoryakov_shop.HomeWork.Product
import com.example.nikita_khoryakov_shop.ui.cart.catalog.BasketView
import moxy.MvpPresenter

class BasketPresenter : MvpPresenter<BasketView>() {
    private val basket = Basket(
        mutableListOf(
            Product(12000.0, 30, "Телефон Samsung"),
            Product(15000.0, 10, "Телефон Huawei"),
            Product(25000.0, 15, "Телефон Iphone"),
            Product(12500.0, 12, "Телефон Honor"),
            Product(15500.0, 17, "Телефон Sony"),
            Product(25500.0, 13, "Телефон LG"),
            Product(13000.0, 23, "Телефон 1"),
            Product(16000.0, 25, "Телефон 3"),
            Product(26000.0, 19, "Телефон 4"),
            Product(11000.0, 21, "Телефон 8"),
            Product(14000.0, 33, "Телефон 7"),
            Product(24000.0, 31, "Телефон 6")
        )
    )

    fun setData() {
        viewState.setProducts(basket.products)
    }

    fun removeItem(productName: String) {
        val position = basket.products.indexOf(
            basket.products.find { product -> product.getProductName() == productName }
        )
        viewState.removeItem(position)
    }
}