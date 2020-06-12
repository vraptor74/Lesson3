package com.example.nikita_khoryakov_shop.HomeWork


class HomeWorkLesson5 {
    fun example() {
        val iphoneCase = Product(price = 155.0, salePercent = 20, name = "")
        val samsungCase = Product(price = 123.0, salePercent = 30, name = "")

        val productList: List<Product> = listOf(iphoneCase, samsungCase)
        val basket = Basket(productList)
        val totalCasePrice = basket.calcTotalDiscountPrice()

        val pricePrinterInRubles: PricePrinter = PricePrinterInRubles()
        pricePrinterInRubles.print(totalCasePrice)

    }
}

class Basket(
    val products: List<Product>
) {
    fun calcTotalDiscountPrice(): Double = products.map { it.calcDiscountPrice() }.sum()
}

class Product(
    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int = 0,
    private val name: String


) {
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */
    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
    fun getProductName(): String = name
    fun getProductPrice(): Double = price
    fun getProductSale(): Int = salePercent
}

interface PricePrinter {
    /**
     * Accepts the price in rubles.
     * Outputs price in <PRICE> <currency> format.
     * If price have not fractional part than it will be printed as integer.
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    fun print(price: Double)
}

class PricePrinterInRubles : PricePrinter {
    override fun print(price: Double) {
        val stringPrice: String = if (price % 1 == 0.0) {
            price.toInt().toString()
        } else {
            String.format("%.2f", price)
        }
        println("Стоимость: $stringPrice P")
    }
}