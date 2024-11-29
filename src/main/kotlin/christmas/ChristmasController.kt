package christmas

class ChristmasController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        outputView.printStart()
        val visitDay = inputView.readVisitDay()
        val orderMenus = inputView.readOrderMenus()
    }
}