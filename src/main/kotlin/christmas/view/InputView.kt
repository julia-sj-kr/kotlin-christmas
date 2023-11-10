package christmas.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readDate(): Int {
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
        val input = Console.readLine()
        val day = requireNotNull(input.toIntOrNull())
        require((1..31).contains(day))
        return day
    }

}