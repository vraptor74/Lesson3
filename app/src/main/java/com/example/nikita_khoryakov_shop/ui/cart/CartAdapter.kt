package com.example.nikita_khoryakov_shop.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.nikita_khoryakov_shop.R
import com.example.nikita_khoryakov_shop.domain.model.CartProduct
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.cart_item.*

class CartAdapter(
    private val onProductClick: (CartProduct) -> Unit
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bind(item: CartProduct) {
            containerView.setOnClickListener { onProductClick(item) }
            tvCartItemTitle.text = item.title
            tvCartItemPrice.text = item.lot.price.toString()
        }
    }

    private var dataSet: List<CartProduct> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_item, parent, false) as ConstraintLayout

        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun changeItemSource(products: List<CartProduct>) {
        dataSet = products
        notifyDataSetChanged()
    }
}