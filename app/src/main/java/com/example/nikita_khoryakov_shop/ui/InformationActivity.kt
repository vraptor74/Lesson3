package com.example.nikita_khoryakov_shop.ui

import android.content.Intent
import android.os.Bundle
import com.example.nikita_khoryakov_shop.R
import com.example.nikita_khoryakov_shop.ui.cart.catalog.CatalogActivity
import kotlinx.android.synthetic.main.information_layout.*

class InformationActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.information_layout)


        backButton.setOnClickListener {
            val intent = Intent(this, CatalogActivity::class.java)
            startActivity(intent)
            finish()
        }

        checkoutButton.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))

        }

    }
}