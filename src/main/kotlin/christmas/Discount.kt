package christmas

import christmas.MenuBoard.category
import christmas.MenuBoard.menuItems
import java.awt.Menu

class Discount {

    fun christmasDiscount(date: Int): Int {
        return if (date in 1..25) 1000 + 100 * (date - 1)
        else 0
    }

    fun weekDayDiscount(date: Int, orderList: MutableList<Order>): Int {
        var dessertDiscount: Int = 0
        if (!Calendar().sortWeekend(date)) {
            orderList.forEach { order ->
                val category = MenuBoard.category
                if (category["디저트"]?.contains(order.name) == true) {
                    dessertDiscount += 2023 * order.num
                }
            }
        }
        return dessertDiscount
    }

    //함수형 스타일
    fun weekendDiscount(date: Int, orderList: MutableList<Order>): Int {
        var mainDiscount: Int = 0
        if (Calendar().sortWeekend(date)) {
            mainDiscount = orderList.filter { order -> category["메인"]?.contains(order.name) == true }.sumOf { it.num * 2023 }
        }
        return mainDiscount
    }

    fun specialDayDiscount(date: Int): Int {
        return if (Calendar().checkSpecialDays(date)) 1000
        else 0
    }

    fun getTotalPrice(orderList: MutableList<Order>): Int {
        return orderList.sumOf { order ->
            menuItems[order.name]!! * order.num
        }
    }

    fun getChampagne(orderList: MutableList<Order>): Int {
        val totalPrice = getTotalPrice(orderList)

        if (totalPrice > 120000) {
            orderList.add(Order("샴페인", 1))
            return menuItems["샴페인"]!!
        } else return 0
    }
}


