package christmas

import java.text.DecimalFormat

class OutputView {
    fun printStart() = println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")

    fun printOrderMenus(orderMenus: List<OrderMenu>) {
        println("<주문 메뉴>")
        orderMenus.forEach { orderMenu ->
            println(orderMenu.menu.menu + " ${orderMenu.count}개")
        }
    }

    fun printTotalOrderPrice(totalOrderPrice: Int) {
        println("<할인 전 총주문 금액>")
        println(totalOrderPrice.toWonFormat())
    }

    fun printApply(hasApplyMenu: Boolean) {
        if (hasApplyMenu.not()) return
        println("<증정 메뉴>")
        println(Menu.CHAMPAGNE.menu + " ${Menu.CHAMPAGNE.price}개")
    }

    fun printEventResult(christmasDiscounts: List<ChristmasDiscount>) {
        christmasDiscounts.forEach { christmasDiscount ->
            println("${christmasDiscount.name}: -${christmasDiscount.discountPrice.toWonFormat()}")
        }
    }

    fun printTotalEventPrice(totalDiscountPrice: Int) {
        println("<총혜택 금액>")
        println("-${totalDiscountPrice.toWonFormat()}")
    }

    fun printPaymentAmount(paymentAmount: Int) {
        println("<할인 후 예상 결제 금액>")
        println(paymentAmount.toWonFormat())
    }

    fun printEventBadge(badge: String) {
        println("<12월 이벤트 배지>")
        println(badge)
    }

    private fun Int.toWonFormat(): String {
        val formatter = DecimalFormat("#,###원")
        return formatter.format(this)
    }
}