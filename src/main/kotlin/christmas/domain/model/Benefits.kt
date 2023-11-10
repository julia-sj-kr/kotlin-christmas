package christmas.domain.model

import christmas.enum.Beverage

class Benefits(val date: Date, val order: Order) {

    val discounts = mutableListOf<Discount>()
    val freeMenus = mutableListOf<Menu>()

    init {
        addDDayDiscountPrice()
        addWeekdayDiscount()
        addWeekendDiscount()
        addSpecialDiscount()
        addChampagneFree()
    }

    private fun addDDayDiscountPrice() {
        if (date.day > 25) discounts.add(Discount("크리스마스 디 데이 할인", 1000 + (date.day - 1) * 100))
    }

    private fun addWeekdayDiscount() {
        if (date.isWeekend) return
        val dessertMenus = order.getMenus().filter { menu -> menu.type == "디저트" }
        discounts.add(Discount("평일 할인", dessertMenus.sumOf { dessert -> dessert.count * 2023 }))
    }

    private fun addWeekendDiscount() {
        if (date.isWeekend.not()) return
        val mainMenus = order.getMenus().filter { menu -> menu.type == "메인" }
        discounts.add(Discount("주말 할인", mainMenus.sumOf { main -> main.count * 2023 }))
    }

    private fun addSpecialDiscount() {
        if (date.hasStar.not()) return
        discounts.add(Discount("특별 할인", 1000))
    }

    private fun addChampagneFree() {
        if (order.getTotalPrice() < 120_000) return
        val champagne = Beverage.Champagne
        freeMenus.add(Menu(champagne.name, champagne.type, champagne.price, 1))
    }


}