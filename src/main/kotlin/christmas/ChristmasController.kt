package christmas

class ChristmasController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        outputView.printStart()
        val visitDay = inputView.readVisitDay()
        val orderMenus = inputView.readOrderMenus()
        outputView.printOrderMenus(orderMenus)
        val totalOrderPrice = getTotalOrderPrice(orderMenus)
        outputView.printTotalOrderPrice(totalOrderPrice)
        val christmasEvent = ChristmasEvent(visitDay, orderMenus, totalOrderPrice)
        outputView.printApply(christmasEvent.hasApplyMenu())
        outputView.printEventResult(christmasEvent.getDiscounts())
    }

    private fun getTotalOrderPrice(orderMenus: List<OrderMenu>): Int {
        return orderMenus.sumOf { it.menu.price * it.count }
    }
}