package com.example.nikita_khoryakov_shop.ui.cart.catalog

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nikita_khoryakov_shop.App
import com.example.nikita_khoryakov_shop.R
import com.example.nikita_khoryakov_shop.presenter.CatalogPresenter
import com.example.nikita_khoryakov_shop.ui.BaseActivity
import com.example.nikita_khoryakov_shop.ui.CategoryAdapter
import com.example.nikita_khoryakov_shop.ui.cart.CartActivity
import kotlinx.android.synthetic.main.catalog_layout.*
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class CatalogActivity : BaseActivity(),
    CatalogView {

    @Inject
    lateinit var catalogPresenter: CatalogPresenter

    private val presenter by moxyPresenter { catalogPresenter }

    private val adapter =
        CategoryAdapter { category ->
            presenter.removeItem(category)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)

        Log.d(tag, "savedInstanceState = $savedInstanceState")
        val savedInt = savedInstanceState?.getInt(SAVE_SATE_INT)
        Log.d(tag, "savedInt $savedInt")

        catalogBasketBtn.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java).apply {
                putExtra(PRODUCT_ID, 1000)
            }
            startActivityForResult(
                intent,
                REQUEST_AUTH
            )
        }

        categoryRv.layoutManager = LinearLayoutManager(this)
        categoryRv.adapter = adapter
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(SAVE_SATE_INT, 89)
        super.onSaveInstanceState(outState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (REQUEST_AUTH == requestCode) {
            val isUserAuth = data?.extras?.getBoolean(IS_USER_AUTH)
            Log.d(tag, "onActivityResult ${isUserAuth.toString()}")
        }
    }

    override fun setProductNames(list: List<String>) {
        adapter.setData(list)
    }

    override fun removeItem(position: Int) {
        adapter.notifyItemRemoved(position)
    }

    override fun showProductIds(productIds: List<Long>) {
        Toast.makeText(this, productIds.joinToString(","), Toast.LENGTH_LONG).show()
    }

    companion object {
        const val PRODUCT_ID = "PRODUCT_ID"
        const val REQUEST_AUTH: Int = 10
        const val IS_USER_AUTH = "IS_USER_AUTH"
        const val SAVE_SATE_INT = "SAVE_SATE_INT"
    }
}


val AppCompatActivity.sharedPreferences: SharedPreferences
    get() = getSharedPreferences("data", MODE_PRIVATE)