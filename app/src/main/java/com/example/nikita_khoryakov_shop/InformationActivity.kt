package com.example.nikita_khoryakov_shop

import android.content.Intent
import android.os.Bundle
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
        catalogCheckoutBtn.setOnClickListener {
            startActivity(Intent(this, CatalogActivity::class.java))

        }
        basketButton.setOnClickListener {
            startActivity(Intent(this, BasketActivity::class.java))

        }
        checkoutButton.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))

        }

    }
}