package christmas.domain.model

class Order(private val menus: List<Menu>) {

    fun getTotalPrice() = menus.sumOf { menu -> menu.count * menu.price }
}