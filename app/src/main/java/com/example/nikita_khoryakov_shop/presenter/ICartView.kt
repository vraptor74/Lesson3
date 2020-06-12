package com.example.nikita_khoryakov_shop.presenter


import com.example.nikita_khoryakov_shop.domain.model.CartProduct
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface ICartView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProducts(products: List<CartProduct>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showProductDerailed(product: CartProduct)

}