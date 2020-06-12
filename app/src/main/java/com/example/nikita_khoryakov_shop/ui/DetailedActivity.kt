package com.example.nikita_khoryakov_shop.ui

import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.nikita_khoryakov_shop.App
import com.example.nikita_khoryakov_shop.R
import com.example.nikita_khoryakov_shop.domain.model.CatalogProduct
import com.example.nikita_khoryakov_shop.presenter.DetailedPresenterFactory
import com.example.nikita_khoryakov_shop.presenter.DetailedView
import kotlinx.android.synthetic.main.activity_detailed.*
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class DetailedActivity : BaseActivity(),
    DetailedView {

    @Inject
    lateinit var detailedPresenter: DetailedPresenterFactory

    private val presenter by moxyPresenter { detailedPresenter.create(productId = "") }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        val product = intent?.getParcelableExtra<CatalogProduct>(PRODUCT_TAG) ?: return
        Glide
            .with(ivDetailedImage.context)
            .load(product.imageUrl)
            .error(R.mipmap.ic_launcher)
            .into(ivDetailedImage)
        tvDetailedTitle.text = product.title
        tvDetailedPrice.text = product.lot.calcDiscountPrice().toString()
        presenter.onProductShow(product)
    }

    companion object {
        const val PRODUCT_TAG = "PRODUCT_TAG"
    }
}
