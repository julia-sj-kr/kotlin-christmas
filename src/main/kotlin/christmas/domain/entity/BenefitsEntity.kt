package christmas.domain.entity

import christmas.enum.MenuRole
import christmas.presentation.model.DateModel
import christmas.presentation.model.DiscountModel
import christmas.presentation.model.MenuModel

class BenefitsEntity(private val date: DateModel, private val order: OrderEntity) {

    val discounts = mutableListOf<DiscountModel>()
    val freeMenus = mutableListOf<MenuModel>()

    init {
        addDDayDiscountPrice()
        addWeekdayDiscount()
        addWeekendDiscount()
        addSpecialDiscount()
        addChampagneFree()
    }

    fun totalDiscountPrice() = discounts.sumOf { discount -> if (discount.name == "증정 이벤트") 0 else discount.price }

    fun totalBenefitsPrice() = discounts.sumOf { discount -> discount.price }

    private fun addDDayDiscountPrice() {
        if (date.day < 25) discounts.add(DiscountModel("크리스마스 디 데이 할인", 1000 + (date.day - 1) * 100))
    }

    private fun addWeekdayDiscount() {
        if (date.isWeekend) return
        val dessertMenus = order.getMenus().filter { menu -> menu.type == "디저트" }
        discounts.add(DiscountModel("평일 할인", dessertMenus.sumOf { dessert -> dessert.count * 2023 }))
    }

    private fun addWeekendDiscount() {
        if (date.isWeekend.not()) return
        val mainMenus = order.getMenus().filter { menu -> menu.type == "메인" }
        discounts.add(DiscountModel("주말 할인", mainMenus.sumOf { main -> main.count * 2023 }))
    }

    private fun addSpecialDiscount() {
        if (date.hasStar.not()) return
        discounts.add(DiscountModel("특별 할인", 1000))
    }

    private fun addChampagneFree() {
        if (order.getTotalPrice() < 120_000) return
        val champagne = MenuRole.Champagne
        freeMenus.add(MenuModel(champagne.menu, champagne.type, champagne.price, 1))
        discounts.add(DiscountModel("증정 이벤트", champagne.price))
    }


}