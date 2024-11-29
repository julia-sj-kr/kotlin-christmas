package christmas

import java.text.DecimalFormat

class OutputView {
    fun printStart() = println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")

    fun printOrderMenus(orderMenus: List<OrderMenu>) {
        println("<주문 메뉴>")
        orderMenus.forEach { orderMenu ->
            println(orderMenu.menu.menu + "${orderMenu.count}개")
        }
    }

    fun printTotalOrderPrice(orderMenus: List<OrderMenu>) {
        val totalOrderPrice = orderMenus.sumOf { it.menu.price * it.count }
        println("<할인 전 총주문 금액>")
        println(totalOrderPrice.toWonFormat())
    }

    private fun Int.toWonFormat(): String {
        val formatter = DecimalFormat("#,###원")
        return formatter.format(this)
    }
}