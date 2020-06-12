package com.example.nikita_khoryakov_shop.domain

interface ViewedProductDao {

    fun addProduct(productId: Long)


    fun getAllProducts(): List<Long>
}