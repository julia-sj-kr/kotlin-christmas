package christmas

class DiscountManager() {
    fun christmasDDAYDiscount(day: Int): Int {
        if (day > 25) return 0
        var discount = 1000
        repeat(day - 1) {
            discount += 100
        }
        return discount
    }

    fun weekDayDiscount(menus: List<OrderMenu>): Int {
        val dessertCount = menus.count { menu -> menu.menu.getMenuType() == MenuType.DESSERT }
        return 2023 * dessertCount
    }

    fun holidayDiscount(menus: List<OrderMenu>): Int {
        val mainCount = menus.count { menu -> menu.menu.getMenuType() == MenuType.MAIN }
        return 2023 * mainCount
    }

    fun specialDayDiscount(startDayOfWeekIndex: Int, day: Int): Int {
        val dayOfWeekIndex = (day + startDayOfWeekIndex) % 7
        if (dayOfWeekIndex == 6 && day == 25) return 1000
        return 0
    }

    fun applyChampagne(menus: List<OrderMenu>): Menu? {
        val totalPrice = menus.sumOf { menu -> menu.menu.price * menu.count }
        if (totalPrice >= 120_000) return Menu.CHAMPAGNE
        return null
    }
}