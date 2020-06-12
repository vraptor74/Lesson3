package com.example.nikita_kho


import com.example.nikita_khoryakov_shop.domain.model.CreateOrderModel
import com.example.nikita_khoryakov_shop.domain.model.Product
import com.example.nikita_khoryakov_shop.presenter.ProductsView
import moxy.MvpPresenter

class ProductsPresenter : MvpPresenter<ProductsView>() {

    private val iphoneCase = Product(
        price = 123.5,
        salePercent = 30,
        productName = "IPhone Case"
    )
    private val samsungCase = Product(
        price = 124.5,
        salePercent = 15,
        productName = "Samsung Case"
    )

    private val products = listOf(iphoneCase, samsungCase)

    private val model = CreateOrderModel()

    fun checkFirstName(text: String) {
        if (!checkSymbols(text)) model.firstName = text
        viewState.showErrorForFirstName(checkSymbols(text))
    }

    fun checkSecondName(text: String) {
        if (!checkSymbols(text)) model.secondName = text
        viewState.showErrorForSecondName(checkSymbols(text))
    }

    fun checkMiddleName(text: String) {
        if (!checkSymbols(text)) model.middleName = text
        viewState.showErrorForMiddleName(checkSymbols(text))
    }

    private fun checkSymbols(text: String): Boolean = text.length < 3

    fun pricePrint() {
        viewState.print(iphoneCase.calcDiscountPrice())

        val allPrice: Double = 0.0
        products.forEach { product ->
            viewState.print(product.calcDiscountPrice())
        }
    }

    fun productNamePrint() {
        products.forEach { product ->
            viewState.print(product.getProductName())
        }
    }

    fun productNameAndPricePrint() {
        products.forEach { product ->
            viewState.print("${product.getProductName()}: ${product.calcDiscountPrice()}")
        }
    }
}

