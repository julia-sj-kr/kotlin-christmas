package christmas.presentation.view

import christmas.domain.entity.BadgeEntity
import christmas.domain.entity.BenefitsEntity
import christmas.presentation.model.MenuModel
import christmas.domain.entity.OrderEntity

class OutputView {

    fun introduce() {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
    }

    fun showOrderMenus(menus: List<MenuModel>) {
        println("<주문 메뉴>")
        menus.forEach { menu ->
            println("${menu.name} ${menu.count}개")
        }
    }

    fun showTotalPrice(order: OrderEntity) {
        println("<할인 전 총주문 금액>")
        val totalPrice = order.getTotalPrice()
        println(formatCurrency(totalPrice))
    }

    fun showFreeMenus(benefits: BenefitsEntity) {
        println("<증정 메뉴>")
        benefits.freeMenus.forEach { freeMenu ->
            println("${freeMenu.name} ${freeMenu.count}개")
        }
    }

    fun showDiscounts(benefits: BenefitsEntity) {
        println("<혜택 내역>")
        benefits.discounts.forEach { discount ->
            println("${discount.name}: ${formatCurrency(-discount.price)}")
        }
    }

    fun showTotalDiscount(benefits: BenefitsEntity) {
        println("<총혜택 금액>")
        val totalBenefitsPrice = benefits.totalBenefitsPrice()
        println(formatCurrency(-totalBenefitsPrice))
    }

    fun showPayment(order: OrderEntity, benefits: BenefitsEntity) {
        println("<할인 후 예상 결제 금액>")
        val payment = order.getTotalPrice() - benefits.totalDiscountPrice()
        println(formatCurrency(payment))
    }

    fun showEventBadge(badge: BadgeEntity) {
        println("<12월 이벤트 배지>")
        println(badge.getType())
    }

    private fun formatCurrency(price: Int) = String.format("%,.0f원", price.toDouble())

}