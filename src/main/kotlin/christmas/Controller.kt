package christmas

import java.util.function.ToIntFunction

class Controller {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun run() {
        outputView.startMessage()
        val visitDate = visitDate()
        println(visitDate)

    }

    fun visitDate(): Int {
        var visitDate: Int
        do {
            visitDate = inputView.readDate()
            if (visitDate!in 1..31) println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        } while (visitDate!in 1..31)
        return visitDate
    }
}