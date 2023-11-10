package christmas.domain.model

import christmas.enum.Main

class Benefits(val date: Date, val order: Order) {

    val discounts = mutableListOf<Discount>()
    init {
        DDayDiscountPrice()
        weekdayDiscount()
    }
    fun DDayDiscountPrice() {
        if (date.day > 25) return
        discounts.add(Discount("크리스마스 디 데이 할인", 1000 + (date.day - 1) * 100))
    }

    fun weekdayDiscount() {
        if (date.isWeekend) return
        val mainMenuCount = order.getMenus().count { menu -> menu.type == "디저트" }
        discounts.add(Discount("평일 할인", mainMenuCount * 2023))
    }

}