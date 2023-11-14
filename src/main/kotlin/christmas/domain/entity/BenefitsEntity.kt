package christmas.domain.entity

import christmas.enum.DiscountRole
import christmas.enum.MenuRole
import christmas.presentation.model.DateModel
import christmas.presentation.model.DiscountModel
import christmas.presentation.model.MenuModel

class BenefitsEntity(private val date: DateModel, private val order: OrderEntity) {

    val discounts = mutableListOf<DiscountModel>()
    val freeMenus = mutableListOf<MenuModel>()

    init {
        if (order.getTotalPrice() >= MIN_ORDER_PRICE){
            addDDayDiscountPrice()
            addWeekdayDiscount()
            addWeekendDiscount()
            addSpecialDiscount()
            addChampagneFree()
        }
    }

    fun totalDiscountPrice() =
        discounts.sumOf { discount -> if (discount.name == FREE_EVENT) NOT_ADD_PRICE else discount.price }

    fun totalBenefitsPrice() = discounts.sumOf { discount -> discount.price }

    private fun addDDayDiscountPrice() {
        if (date.day <= CHRISTMAS_DATE) {
            discounts.add(
                DiscountModel(
                    DiscountRole.CHRISTMAS_D_DAY.type,
                    DiscountRole.CHRISTMAS_D_DAY.price + (date.day - DAY_MINUS) * D_DAY_DISCOUNT
                )
            )
        }
    }

    private fun addWeekdayDiscount() {
        if (date.isWeekend) return
        val dessertMenus = order.getMenus().filter { menu -> menu.type == WEEKDAY_MENU_TYPE }
        if (dessertMenus.isEmpty()) return
        discounts.add(
            DiscountModel(
                DiscountRole.WEEKDAY.type,
                dessertMenus.sumOf { dessert -> dessert.count * DiscountRole.WEEKDAY.price })
        )
    }

    private fun addWeekendDiscount() {
        if (date.isWeekend.not()) return
        val mainMenus = order.getMenus().filter { menu -> menu.type == WEEKEND_MENU_TYPE }
        if (mainMenus.isEmpty()) return
        discounts.add(
            DiscountModel(
                DiscountRole.WEEKEND.type,
                mainMenus.sumOf { main -> main.count * DiscountRole.WEEKEND.price })
        )
    }

    private fun addSpecialDiscount() {
        if (date.hasStar.not()) return
        discounts.add(DiscountModel(DiscountRole.SPECIAL.type, DiscountRole.SPECIAL.price))
    }

    private fun addChampagneFree() {
        if (order.getTotalPrice() < FREE_EVENT_MIN_PRICE) return
        val champagne = MenuRole.CHAMPAGNE
        freeMenus.add(MenuModel(champagne.menu, champagne.type, champagne.price, FREE_CHAMPAGNE_COUNT))
        discounts.add(DiscountModel(FREE_EVENT, champagne.price))
    }


    private companion object {
        const val FREE_EVENT = "증정 이벤트"
        const val FREE_EVENT_MIN_PRICE = 120_000
        const val FREE_CHAMPAGNE_COUNT = 1
        const val WEEKDAY_MENU_TYPE = "디저트"
        const val WEEKEND_MENU_TYPE = "메인"
        const val D_DAY_DISCOUNT = 100
        const val DAY_MINUS = 1
        const val NOT_ADD_PRICE = 0
        const val CHRISTMAS_DATE = 25
        const val MIN_ORDER_PRICE = 10000
    }
}