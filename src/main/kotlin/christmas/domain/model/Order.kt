package christmas.domain.model

class Order(private val menus: List<Menu>) {

    fun getMenus() = menus
    fun getTotalPrice() = menus.sumOf { menu -> menu.count * menu.price }
}