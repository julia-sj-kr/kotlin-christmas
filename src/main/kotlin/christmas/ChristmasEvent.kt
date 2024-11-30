package christmas

class ChristmasEvent(private val day: Int, private val orderMenus: List<OrderMenu>, private val totalOrderPrice: Int) {
    private var discounts = mutableListOf<ChristmasDiscount>()

    init {
        discounts.add(christmasDDAYDiscount())
        if (Calendar.isWeekDay(day)) discounts.add(weekDayDiscount())
        else discounts.add(holidayDiscount())
        discounts.add(specialDiscount())
        discounts.add(applyChampagneDiscount())
        discounts.removeAll { it.discountPrice == 0 }
    }

    private fun christmasDDAYDiscount(): ChristmasDiscount {
        if (day > 25) return ChristmasDiscount(Discount.CHRISTMAS_D_DAY.title, 0)
        return ChristmasDiscount(Discount.CHRISTMAS_D_DAY.title, 1000 + (day-1) * 100)
    }

    private fun weekDayDiscount(): ChristmasDiscount {
        val dessertCount =
            orderMenus.count { orderMenu -> MenuType.convertMenuType(orderMenu.menu) == MenuType.DESSERT }
        val weekDayDiscount = dessertCount * Discount.WEEK_DAY.price
        return ChristmasDiscount(Discount.WEEK_DAY.title, weekDayDiscount)
    }

    private fun holidayDiscount(): ChristmasDiscount {
        val mainCount = orderMenus.count { orderMenu -> MenuType.convertMenuType(orderMenu.menu) == MenuType.MAIN }
        val holidayDiscount = mainCount * Discount.HOLIDAY.price
        return ChristmasDiscount(Discount.HOLIDAY.title, holidayDiscount)
    }

    private fun specialDiscount(): ChristmasDiscount {
        if (Calendar.isSpecialDay(day)) return ChristmasDiscount(Discount.SPECIAL.title, Discount.SPECIAL.price)
        return ChristmasDiscount(Discount.SPECIAL.title, 0)
    }

    private fun applyChampagneDiscount(): ChristmasDiscount {
        if (totalOrderPrice >= 120_000) return ChristmasDiscount(Discount.APPLY.title, Discount.APPLY.price)
        return ChristmasDiscount(Discount.APPLY.title, 0)
    }

    fun getDiscounts() = discounts.toList()

    fun hasApplyMenu() = discounts.find { it.name == Discount.APPLY.title } != null

    fun getTotalEventPrice() = discounts.sumOf { it.discountPrice }

    fun getTotalDiscountPrice() = discounts.filter { it.name != Discount.APPLY.title }.sumOf { it.discountPrice }
}