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

    fun showFreeMenus(benefits: Benefits) {
        println("<증정 메뉴>")
        benefits.freeMenus.forEach { freeMenu ->
            println("${freeMenu.name} ${freeMenu.count}개")
        }
    }

    fun showDiscounts(benefits: Benefits) {
        println("<혜택 내역>")
        benefits.discounts.forEach { discount ->
            println("${discount.name}: ${formatCurrency(-discount.price)}")
        }
    }

    fun showTotalDiscount(benefits: Benefits) {
        println("<총혜택 금액>")
        val totalDiscount = benefits.totalDiscountPrice()
        println(formatCurrency(-totalDiscount))
    }

    fun showPayment(order: Order,benefits: Benefits){
        println("<할인 후 예상 결제 금액>")
        val payment = order.getTotalPrice() - benefits.totalDiscountPrice()
        println(formatCurrency(payment))
    }

    private fun formatCurrency(price: Int) = String.format("%,.0f원", price.toDouble())

}