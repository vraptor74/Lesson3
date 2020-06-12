package com.example.nikita_khoryakov_shop.ui.cart.catalog

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface CatalogView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setProductNames(list: List<String>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun removeItem(position: Int)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showProductIds(productIds: List<Long>)
}