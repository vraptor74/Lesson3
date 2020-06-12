package com.example.nikita_khoryakov_shop.presenter


import com.example.nikita_khoryakov_shop.domain.ViewedProductDao
import com.example.nikita_khoryakov_shop.domain.model.CatalogProduct
import moxy.MvpPresenter
import javax.inject.Inject

class DetailedPresenter @Inject constructor(
    private val viewedProductDao: ViewedProductDao,
    private val productId: String
) : MvpPresenter<DetailedView>() {
    fun onProductShow(product: CatalogProduct) {
        viewedProductDao.addProduct(product.id.toLong())
    }
}

class DetailedPresenterFactory @Inject constructor(
    private val viewedProductDao: ViewedProductDao
) {
    fun create(productId: String): DetailedPresenter {
        return DetailedPresenter(
            viewedProductDao,
            productId
        )
    }
}