package christmas.presentation.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readDate(): Int {
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (12월 날짜에 포함 되는 1에서 31중에 입력해 주세요!)")
        val input = Console.readLine()
        val day = requireNotNull(input.toIntOrNull())
        require((1..31).contains(day))
        return day
    }
//주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)

    fun readMenus(): List<Pair<String, Int>> {
        println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")
        val input = Console.readLine()
        val menus = input.split(",").map { menu ->
            val (name, count) = menu.split("-")
            Pair(name, requireNotNull(count.toIntOrNull()))
        }
        return menus
    }
}