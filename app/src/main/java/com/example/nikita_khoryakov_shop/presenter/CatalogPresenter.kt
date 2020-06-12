package com.example.nikita_khoryakov_shop.presenter

import com.example.nikita_khoryakov_shop.domain.MainApi
import com.example.nikita_khoryakov_shop.domain.ViewedProductDao
import com.example.nikita_khoryakov_shop.domain.iteractor.AddProductToCartUseCase

import com.example.nikita_khoryakov_shop.ui.cart.catalog.CatalogView
import kotlinx.coroutines.launch
import moxy.InjectViewState
import javax.inject.Inject


@InjectViewState
class CatalogPresenter @Inject constructor(
    private val viewedProductDao: ViewedProductDao,
    private val mainApi: MainApi,
    private val addProductToCartUseCase: AddProductToCartUseCase
) : BasePresenter<CatalogView>() {

    private val list = mutableListOf(
        "Телевизоры",
        "Телефоны",
        "Планшеты",
        "Часы",
        "Компютеры",
        "Ноутбуки"
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        launch {
            val remoteProducts = mainApi.allProducts(author = "default")
            val productNames = remoteProducts.map { remoteProduct -> remoteProduct.name }
            viewState.setProductNames(productNames)
        }
    }

    override fun onFailure(e: Throwable) {
        super.onFailure(e)
        println(e)
    }

    override fun attachView(view: CatalogView?) {
        super.attachView(view)
        val productIds = viewedProductDao.getAllProducts()
        viewState.showProductIds(productIds)
    }

    fun setData() {
        viewState.setProductNames(list)
    }

    fun removeItem(category: String) {
        val position = list.indexOf(category)
        list.remove(category)
        viewState.removeItem(position)
    }

    fun addProductToCart() {

    }

}