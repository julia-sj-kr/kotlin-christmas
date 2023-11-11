package christmas.domain.entity

import christmas.presentation.model.Menu

class Order(private val menus: List<Menu>) {

    fun getMenus() = menus
    fun getTotalPrice() = menus.sumOf { menu -> menu.count * menu.price }
}