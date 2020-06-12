package com.example.nikita_khoryakov_shop.presenter

import com.example.nikita_khoryakov_shop.domain.model.CartProduct
import com.example.nikita_khoryakov_shop.domain.model.CartProductFactory
import moxy.MvpPresenter

class CartPresenter() : MvpPresenter<ICartView>() {

    private val factory = CartProductFactory()

    private val myDataSet = listOf(
        factory.createCartProduct(1, "Картошка", "123321", 1220.0, 0),
        factory.createCartProduct(2, "Морковь", "123321", 1700.0, 0),
        factory.createCartProduct(3, "Капуста", "123321", 100.0, 0),
        factory.createCartProduct(4, "Виноград", "123321", 8000.0, 0),
        factory.createCartProduct(5, "Орех", "123321", 1200.0, 0),
        factory.createCartProduct(6, "Помидор", "123321", 1250.0, 0)
    )

    fun getProducts() {
        viewState.showProducts(myDataSet)
    }

    fun onProductClick(product: CartProduct) {
        viewState.showProductDerailed(product)
    }
}