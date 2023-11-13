package christmas.domain.entity

import christmas.enum.Error
import christmas.enum.MenuRole
import christmas.presentation.model.MenuModel

class OrderEntity(private val menus: List<MenuModel>) {

    init {
        require(menus.distinct().size == menus.size) { println(Error.DUPLICATE_MENU.message) }
        require(menus.any { menu -> menu.type != BEVERAGE }) { println(Error.ONLY_BEVERAGE) }
        require(menus.sumOf { menu -> menu.count } <= MAX_MENU_COUNT) { println(Error.OVER_MENU_COUNT) }
    }

    fun getMenus() = menus
    fun getTotalPrice() = menus.sumOf { menu -> menu.count * menu.price }

    companion object {
        const val BEVERAGE = "음료"
        const val MAX_MENU_COUNT = 20
    }
}