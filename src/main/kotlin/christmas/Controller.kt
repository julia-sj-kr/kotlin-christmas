package christmas

class Controller {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun run() {
        outputView.startMessage()
        val visitDate = getVisitDate()
        val orderMenuInput = getOrderMenu()
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

    private fun getOrderMenu(): MutableList<Order> {
        while (true) {
            val orderMenus = mutableListOf<Order>()
            val inputOrderMenus = inputView.readMenu().split(",")
            try {
                inputOrderMenus.forEach { order ->
                    val input = order.split("-")
                    val name = input[0]
                    require(MenuBoard.menuItems.contains(name)) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
                    val num = requireNotNull(input[1].toIntOrNull()) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
                    require(num >= 1) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
                    orderMenus.add(Order(name, num))
                }
                require(orderMenus.map { it.name }.size == orderMenus.map { it.name }
                    .distinct().size) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
                return orderMenus
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}