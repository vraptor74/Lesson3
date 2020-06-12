package com.example.nikita_khoryakov_shop.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import com.example.nikita_kho.ProductsPresenter
import com.example.nikita_khoryakov_shop.R
import com.example.nikita_khoryakov_shop.presenter.ProductsView
import com.example.nikita_khoryakov_shop.ui.cart.catalog.CatalogActivity.Companion.IS_USER_AUTH
import com.example.nikita_khoryakov_shop.ui.cart.catalog.CatalogActivity.Companion.PRODUCT_ID
import kotlinx.android.synthetic.main.activity_checkout.*

class CheckoutActivity : BaseActivity(), ProductsView {
    private val presenter = ProductsPresenter()
    private var isAuth: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        presenter.attachView(this)
        setListeners()

        val productId = intent.extras?.getInt(PRODUCT_ID, -1)
        Log.d(tag, productId.toString())
        presenter.pricePrint()
        checkoutPay.setOnClickListener {
            isAuth = true
            setResult(Activity.RESULT_OK, Intent().apply {
                putExtra(IS_USER_AUTH, isAuth)
            })
        }
    }

    private fun setListeners() {
        checkoutLastName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.checkSecondName(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        checkoutFirstName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.checkFirstName(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        checkoutMiddleName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.checkMiddleName(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    override fun print(price: Double) {
        Log.d("Print", "Price: $price")
    }

    override fun print(name: String) {
//        TODO("Not yet implemented")
    }

    fun EditText.showError(visible: Boolean) {
        val drawable = if (visible) R.drawable.ic_error
        else 0

        this.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)
    }

    override fun showErrorForFirstName(visible: Boolean) {
        checkoutFirstName.showError(visible)
    }

    override fun showErrorForSecondName(visible: Boolean) {
        checkoutLastName.showError(visible)
    }

    override fun showErrorForMiddleName(visible: Boolean) {
        checkoutMiddleName.showError(visible)
    }
}
