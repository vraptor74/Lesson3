package com.example.nikita_khoryakov_shop.domain.iteractor

import com.example.nikita_khoryakov_shop.domain.MainApi
import com.example.nikita_khoryakov_shop.domain.ViewedProductDao
import kotlinx.coroutines.delay
import javax.inject.Inject

class AddProductToCartUseCase @Inject constructor(
    private val mainApi: MainApi,
    private val viewedProductDao: ViewedProductDao
) {

    suspend operator fun invoke() {
        // TODO realization
        delay(1000)
        Time() - Time()
    }
}

class Time() {
    operator fun minus(time: Time) {

    }
}