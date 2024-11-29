package christmas

class OutputView {
    fun printStart() = println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")

    fun printOrderMenus(orderMenus: List<OrderMenu>) {
        println("<주문 메뉴>")
        orderMenus.forEach { orderMenu ->
            println(orderMenu.menu.menu + "${orderMenu.count}개")
        }
    }
}