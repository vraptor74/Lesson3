package com.example.nikita_khoryakov_shop

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.sqrt

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    fun PriceFormat(price : Double, measure: String, discount: Int = 0) : String{
        val finalPrice : String
        if((discount > 0) and (discount <= 100)){
            //вычисляем цену по скидке
            val discountPrice : Double = ((100 - discount)*price)/100;
            //определяем, целое число или дробное
            if (Math.floor(discountPrice) == (discountPrice)) {
                //число целое - цена без дробной части
                finalPrice  = Math.floor(discountPrice).toInt().toString()
            } else {
                //число дробное - цена с дробной частью
                finalPrice = String.format("%.2f", discountPrice);
            }
            return "$finalPrice/$measure (скидка $discount%)"
        }
        else if (discount == 0){
            //определяем, целое число или дробное
            if (Math.floor(price) == (price)) {
                //число целое - цена без дробной части
                finalPrice  = Math.floor(price).toInt().toString()
            } else {
                //число дробное - цена с дробной частью
                finalPrice = String.format("%.2f", price);
            }
            //выводим цену без скидки
            return "$finalPrice/$measure"
        }
        else{
            return "Скидка не может принимать значение меньше 0 или больше 100"
        }
    }
    @Test
    fun addition_isCorrect() {
        print(PriceFormat(8.0, "КГ", 4))
    }

    }
