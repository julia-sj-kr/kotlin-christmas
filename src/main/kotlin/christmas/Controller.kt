package christmas


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
            if (visitDate !in 1..31) println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        } while (visitDate !in 1..31)
        return visitDate
    }

    fun orderMenu(): List<Order> {
        val orderMenus = mutableListOf<Order>()
        //고객이 메뉴판에 없는 메뉴를 입력하는 경우
        //메뉴의 개수는 1 이상일때만 유효
        //메뉴 형식이 다를때
        //중복 메뉴일 경우

        do {

        } while (false)
        val inputOrderMenus = inputView.readMenu().split("-")
        return orderMenus
    }
}