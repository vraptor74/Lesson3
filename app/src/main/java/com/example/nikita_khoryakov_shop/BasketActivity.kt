package com.example.nikita_khoryakov_shop

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.backet_layout.*

class BasketActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.backet_layout)

        backButton.setOnClickListener {
            val intent = Intent(this, CatalogActivity::class.java)
            startActivity(intent)
            finish()
        }

        catalogCheckoutBtn.setOnClickListener {
            startActivity(Intent(this, CatalogActivity::class.java))

        }
        informationButton.setOnClickListener {
            startActivity(Intent(this, InformationActivity::class.java))

        }
        catalogCheckoutBtn.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))

        }
    }
}