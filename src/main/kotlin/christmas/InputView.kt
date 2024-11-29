package christmas

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readVisitDay(): Int {
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
        val visitDay = requireNotNull(Console.readLine().toIntOrNull()) { "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." }
        require(visitDay in 1..31) { "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." }
        return visitDay
    }

    fun readOrderMenus(): List<OrderMenu> {
        val menusInput = Console.readLine().split(",")
        val menus = menusInput.map { menuInput ->
            val menu = menuInput.split("-")
            require(menu.size == 2) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
            val (name, countInput) = menu
            val count = requireNotNull(countInput.toIntOrNull()) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
            require(count >= 1) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }

            OrderMenu(name, count)
        }
        require(menus.distinctBy { it.name }.size == menus.size) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
        return menus
    }

    fun getMenuType(name: String) {
        MenuType.values().map { it.menus.contains(name) }
    }
}