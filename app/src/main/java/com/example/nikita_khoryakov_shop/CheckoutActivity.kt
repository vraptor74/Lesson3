package com.example.nikita_khoryakov_shop

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import com.example.nikita_kho.ProductsPresenter
import com.example.nikita_khoryakov_shop.CatalogActivity.Companion.IS_USER_AUTH
import com.example.nikita_khoryakov_shop.CatalogActivity.Companion.PRODUCT_ID
import com.example.nikita_khoryakov_shop.CatalogActivity.Companion.REQUEST_AUTH
import kotlinx.android.synthetic.main.activity_main.*

class CheckoutActivity : BaseActivity(), ProductsView {

    private val presenter = ProductsPresenter()
    private var isAuth: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)
        setListener()


        backButton.setOnClickListener {
            val intent = Intent(this, CatalogActivity::class.java)
            startActivity(intent)
            finish()
        }

        checkoutConfirm.setOnClickListener {
            startActivity(Intent(this, InformationActivity::class.java))
        }
        catalogButton.setOnClickListener {
            startActivity(Intent(this, CatalogActivity::class.java))
        }

        val productID = intent.extras?.getInt(PRODUCT_ID, -1)
        Log.d(tag, productID.toString())



        checkoutPay.setOnClickListener {
            startActivity(Intent(this, BasketActivity::class.java))
            isAuth = true
            setResult(REQUEST_AUTH, Intent().apply {
                putExtra(IS_USER_AUTH, isAuth)

            })

        }


    }


    private fun setListener() {


        checkoutLastName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.checkLastName(s.toString())


            }


            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        }
        )
        checkoutFirstName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.checkFirstName(s.toString())

            }


            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        }
        )

    }


    override fun print(price: Double) {
        Log.d("Print", "Price: $price")

    }

    override fun print(name: String) {
        TODO("Not yet implemented")
    }

    override fun showErrorForFirstName(visible: Boolean) {
        checkoutFirstName.showError(visible)
    }

    override fun showErrorForLastName(visible: Boolean) {
        checkoutLastName.showError(visible)
    }


    fun EditText.showError(visible: Boolean) {
        val drawable = if (visible) R.drawable.ic_error
        else 0

        this.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)
    }


}
