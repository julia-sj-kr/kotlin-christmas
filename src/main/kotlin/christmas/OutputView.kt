package christmas

import java.text.DecimalFormat

class OutputView {
    fun printStart() = println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")

    fun printOrderMenus(menus: List<OrderMenu>) {
        println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n")
        println("<주문 메뉴>")
        menus.forEach { menu -> println("${menu.menu} ${menu.count}개") }
        println()
    }

    fun printTotalPrice(totalPrice: Int) {
        println("<할인 전 총주문 금액>")
        println(totalPrice)
    }

    fun printApply(apply: List<ApplyMenu>) {
        println("<증정 메뉴>")
        apply.forEach { menu -> println("${menu.menu} ${menu.count}개") }
    }

    fun printBenefit(benefitDiscount: BenefitDiscount) {
        printEmptyDiscount("크리스마스 디데이 할인", benefitDiscount.dDay)
        printEmptyDiscount("평일 할인", benefitDiscount.weekDay)
        printEmptyDiscount("주말 할인", benefitDiscount.holiday)
        printEmptyDiscount("특별 할인", benefitDiscount.special)
        printEmptyDiscount("증정 이벤트", benefitDiscount.apply)
    }

    fun printTotalBenefit(benefitDiscount: BenefitDiscount) {
        println("<총혜택 금액>")
        println("-${benefitDiscount.totalBenefit()}")
    }

    fun printPayment(benefitDiscount: BenefitDiscount) {
        println("<할인 후 예상 결제 금액>")
        println("-${benefitDiscount.totalDiscount()}")
    }

    fun printBadge(benefitDiscount: BenefitDiscount) {
        println("<12월 이벤트 배지>")
        when {
            benefitDiscount.totalBenefit() >= 20_000 -> println("산타")
            benefitDiscount.totalBenefit() >= 10_000 -> println("트리")
            benefitDiscount.totalBenefit() >= 5000 -> println("별")
        }
    }

    private fun printEmptyDiscount(benefitName: String, discount: Int) {
        if (discount == 0) return
        println("${benefitName}: -${discount.wonFormat()}")
    }

    fun Int.wonFormat(): String {
        val formatter = DecimalFormat("#,###원")
        return formatter.format(this)
    }
}