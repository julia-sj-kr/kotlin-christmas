package christmas

class Controller {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun run() {
        outputView.startMessage()
        val visitDate = getVisitDate()
        val orderMenuInput = orderMenu()
        outputView.printVisitDate(visitDate)
        outputView.printOrderMenu(orderMenuInput)//샴페인 증정품 유무 검증 이전 주문내역
        outputView.printTotalOriginPrice(orderMenuInput)
        outputView.printGiftMessage(orderMenuInput)
        outputView.showFinalPaymentDetails(visitDate, orderMenuInput)
    }

    private fun getVisitDate(): Int {
        while (true) {
            try {
                val visitDate = inputView.readDate()
                val date = requireNotNull(visitDate.toIntOrNull()) { "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." }
                require(date in 1..31) { "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." }
                return date
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun orderMenu(): MutableList<Order> {
        val orderMenus = mutableListOf<Order>()
//        //고객이 메뉴판에 없는 메뉴를 입력하는 경우
//        //메뉴의 개수는 1 이상일때만 유효
//        //메뉴 형식이 다를때
//        //중복 메뉴일 경우
//
//        do {
//
//        } while (false)
        val inputOrderMenus = inputView.readMenu().split(",")
        inputOrderMenus.forEach { order ->
            val input = order.split("-")
            val name = input[0]
            val num = input[1].toInt()
            orderMenus.add(Order(name, num))
        }
        return orderMenus
    }
}