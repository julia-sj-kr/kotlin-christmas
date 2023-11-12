package christmas.domain.entity

import christmas.enum.Error
import christmas.presentation.model.MenuModel

class OrderEntity(private val menus: List<MenuModel>) {

    init {
        require(menus.distinct().size == menus.size) { println(Error.DUPLICATE_MENU.message) }
    }

    fun getMenus() = menus
    fun getTotalPrice() = menus.sumOf { menu -> menu.count * menu.price }
}