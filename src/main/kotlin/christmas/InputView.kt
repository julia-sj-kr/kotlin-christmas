package christmas

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readVisitDay(): Int {
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
        val visitDay = requireNotNull(Console.readLine().toIntOrNull()) { "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." }
        require(visitDay in 1..31) { "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." }
        return visitDay
    }
}