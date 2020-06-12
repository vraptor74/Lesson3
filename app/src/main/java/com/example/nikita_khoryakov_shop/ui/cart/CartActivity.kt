package com.example.nikita_khoryakov_shop.ui.cart

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nikita_khoryakov_shop.R
import com.example.nikita_khoryakov_shop.domain.model.CartProduct
import com.example.nikita_khoryakov_shop.presenter.CartPresenter
import com.example.nikita_khoryakov_shop.presenter.ICartView
import com.example.nikita_khoryakov_shop.ui.BaseActivity
import com.example.nikita_khoryakov_shop.ui.CheckoutActivity
import com.example.nikita_khoryakov_shop.ui.DetailedActivity
import com.example.nikita_khoryakov_shop.ui.DetailedActivity.Companion.PRODUCT_TAG
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : BaseActivity(), ICartView {
    private lateinit var cardAdapter: CartAdapter

    private val presenter = CartPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        btnApply.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))

        }

        with(cartProducts) {
            layoutManager = LinearLayoutManager(context)
            adapter = CartAdapter {
                presenter.onProductClick(it)
            }
                .also { cardAdapter = it }
        }
        presenter.attachView(this)
        presenter.getProducts()
    }

    override fun showProducts(products: List<CartProduct>) {
        cardAdapter.changeItemSource(products)
    }

    override fun showProductDerailed(product: CartProduct) {
        startActivity(Intent(this, DetailedActivity::class.java).apply {
            putExtra(PRODUCT_TAG, product)
        })
    }


}
