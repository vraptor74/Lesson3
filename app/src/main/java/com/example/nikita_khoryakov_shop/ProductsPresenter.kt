package com.example.nikita_kho


import com.example.nikita_khoryakov_shop.CreateOrderModel
import com.example.nikita_khoryakov_shop.Product
import com.example.nikita_khoryakov_shop.ProductsView
import moxy.MvpPresenter

class ProductsPresenter : MvpPresenter<ProductsView>() {

    private val iphoneCase = Product(price = 123.5, salePercent = 30, productName = "IphoneCase")
    private val samsungCase = Product(price = 124.5, salePercent = 15, productName = "SamsungCase")


    private val products = listOf(iphoneCase, samsungCase)

    private val model = CreateOrderModel()

    fun checkFirstName(text: String) {
        if (!checkSymbols(text)) model.firstName = text
        viewState.showErrorForFirstName(checkSymbols(text))
    }

    fun checkLastName(text: String) {
        if (!checkSymbols(text)) model.LastName = text
        viewState.showErrorForLastName(checkSymbols(text))
    }


    private fun checkSymbols(text: String): Boolean = text.length < 3


    fun pricePrinter() {
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

    fun productNameAndPrice() {
        products.forEach { product ->
            viewState.print("${product.getProductName()}: ${product.calcDiscountPrice()}")

        }

    }
}

