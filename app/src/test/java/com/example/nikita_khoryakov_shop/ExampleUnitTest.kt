package com.example.nikita_khoryakov_shop

import com.example.nikita_khoryakov_shop.domain.model.Product
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {


    private val presenter = Presenter()
    @Test
    fun example() {
        presenter.printBasket()

    }
}

class Presenter {
    val iphoneCase = Product(
        price = 123.5,
        salePercent = 30,
        productName = "IphoneCase"
    )
    val samsungCase = Product(
        price = 124.5,
        salePercent = 15,
        productName = "SamsungCase"
    )


    private val pricePrinter: PricePrinter = ConsolePricePrinter()
    private val products = listOf(iphoneCase, samsungCase)
    val testBasket = Basket(products)

    fun printBasket() {
        pricePrinter.print(testBasket.getFinalPrice())
    }


    fun pricePrinter() {
        products.forEach { product ->
            pricePrinter.print(product.calcDiscountPrice())
        }
    }

    fun productNamePrint() {
        products.forEach { product ->
            pricePrinter.print(product.getProductName())
        }
    }

    fun productNameAndPrice() {
        products.forEach { product ->
            pricePrinter.print("${product.getProductName()}: ${product.calcDiscountPrice()}")

        }


    }
}

class Basket(products: List<Product>) {
    private var overallPrice: Double = 0.0

    init {
        for (item in products) {
            this.overallPrice = this.overallPrice + item.calcDiscountPrice()
        }
    }

    fun getFinalPrice(): Double = this.overallPrice
}

class Product(
    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int = 0,
    private val productName: String
) {
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */
    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)

    fun getProductName(): String = productName
}

interface PricePrinter {

    /**
     * Outputs price in <PRICE>P format.
     * If price have not fractional part than it will be printed as integer
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    fun print(price: Double)
    fun print(name: String)
}

class ConsolePricePrinter : PricePrinter {

    override fun print(price: Double) {
        println(price)
    }

    override fun print(name: String) {
        println(name)

    }

}
