package christmas.presentation.view

import camp.nextstep.edu.missionutils.Console
import christmas.enum.Error

class InputView {
    fun readDate(): Int {
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (12월 날짜에 포함 되는 1에서 31중에 입력해 주세요!)")
        val input = Console.readLine()
        val day = requireNotNull(input.toIntOrNull()) { println(Error.DATE.message) }
        require((1..31).contains(day)) { println(Error.DATE.message) }
        return day
    }
//주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)

    fun readMenus(): List<Pair<String, Int>> {
        println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")
        val input = Console.readLine()
        val menus = input.split(",").map { menu ->
            val (inputName, inputCount) = menu.split("-")
            val count = requireNotNull(inputCount.toIntOrNull()) { println(Error.MENU_FORM.message) }
            require(count >= 1) { println(Error.MENU_COUNT.message) }
            Pair(inputName, count)
        }
        return menus
    }
}