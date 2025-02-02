package christmas

class OutputView {
    fun startMessage() {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
    }

    fun readVisitDate(visitDate: Int) {
        println("12월 ${visitDate}일 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
    }

    fun readOrderMenu(orderMenuInput: List<Order>) {
        println("<주문 메뉴>")
        orderMenuInput.forEach { order ->
            println(String.format("%s %d개", order.name, order.num))
        }
    }

    fun totalOriginPrice(orderMenuInput: MutableList<Order>) {
        println("<할인 전 총주문 금액>")
        println(String.format("%,d원",Discount().getTotalPrice(orderMenuInput)))
    }
}