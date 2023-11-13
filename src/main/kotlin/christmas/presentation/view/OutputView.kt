package christmas.presentation.view

import christmas.domain.entity.BadgeEntity
import christmas.domain.entity.BenefitsEntity
import christmas.presentation.model.MenuModel
import christmas.domain.entity.OrderEntity
import christmas.enum.MenuRole

class OutputView {

    fun introduce() {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
        println()
    }

    fun showMenus() {
        println("<메뉴판>")
        MenuRole.values().forEach { menuRole ->
            println("이름:${menuRole.menu} 분류:${menuRole.type} 가격:${formatCurrency(menuRole.price)}")
        }
        println()
    }

    fun showCaution() {
        println("<주문 주의 사항>")
        println("총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.")
        println("음료만 주문 시, 주문할 수 없습니다.")
        println("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.(e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)")
        println()
    }

    fun showOrderMenus(menus: List<MenuModel>) {
        println("<주문 메뉴>")
        menus.forEach { menu ->
            println("${menu.name} ${menu.count}개")
        }
        println()
    }

    fun showTotalPrice(order: OrderEntity) {
        println("<할인 전 총주문 금액>")
        val totalPrice = order.getTotalPrice()
        println(formatCurrency(totalPrice))
        println()
    }

    fun showFreeMenus(benefits: BenefitsEntity) {
        println("<증정 메뉴>")
        if (benefits.freeMenus.isEmpty()) {
            println("없음")
            println()
            return
        }
        benefits.freeMenus.forEach { freeMenu ->
            println("${freeMenu.name} ${freeMenu.count}개")
        }
        println()
    }

    fun showDiscounts(benefits: BenefitsEntity) {
        println("<혜택 내역>")
        if (benefits.discounts.isEmpty()) {
            println("없음")
            println()
            return
        }
        benefits.discounts.forEach { discount ->
            println("${discount.name}: ${formatCurrency(-discount.price)}")
        }
        println()
    }

    fun showTotalDiscount(benefits: BenefitsEntity) {
        println("<총혜택 금액>")
        val totalBenefitsPrice = benefits.totalBenefitsPrice()
        println(formatCurrency(-totalBenefitsPrice))
        println()
    }

    fun showPayment(order: OrderEntity, benefits: BenefitsEntity) {
        println("<할인 후 예상 결제 금액>")
        val payment = order.getTotalPrice() - benefits.totalDiscountPrice()
        println(formatCurrency(payment))
        println()
    }

    fun showEventBadge(badge: BadgeEntity) {
        println("<12월 이벤트 배지>")
        println(badge.getType())
    }

    private fun formatCurrency(price: Int) = String.format("%,.0f원", price.toDouble())

}