package christmas.domain.entity

import christmas.presentation.model.MenuModel

class OrderEntity(private val menus: List<MenuModel>) {

    fun getMenus() = menus
    fun getTotalPrice() = menus.sumOf { menu -> menu.count * menu.price }
}