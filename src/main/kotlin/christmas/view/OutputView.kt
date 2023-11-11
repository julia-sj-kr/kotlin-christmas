package christmas.view

import christmas.domain.model.Benefits
import christmas.domain.model.Menu
import christmas.domain.model.Order

class OutputView {

    fun introduce() {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
    }

    fun showOrderMenus(menus: List<Menu>) {
        println("<주문 메뉴>")
        menus.forEach { menu ->
            println("${menu.name} ${menu.count}개")
        }
    }

    fun showTotalPrice(order: Order) {
        println("<할인 전 총주문 금액>")
        val totalPrice = order.getTotalPrice()
        println(formatCurrency(totalPrice))
    }

    fun showFreeMenus(benefits: Benefits){
        println("<증정 메뉴>")
        benefits.freeMenus.forEach { freeMenu ->
            println("${freeMenu.name} ${freeMenu.count}개")
        }
    }

    private fun formatCurrency(price: Int) = String.format("%,.0f원", price)

}