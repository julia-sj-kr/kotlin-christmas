package christmas

class ChristmasController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val discountManager = DiscountManager()

    fun run() {
        outputView.printStart()
        val visitDay = inputView.readVisitDay()
        val orderMenus = inputView.readOrderMenus()
    }
}