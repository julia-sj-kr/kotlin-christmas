package christmas

class OutputView {
    private val discount = Discount()

    fun startMessage() {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
    }

    fun printVisitDate(visitDate: Int) {
        println("12월 ${visitDate}일 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
    }

    fun printOrderMenu(orderMenuInput: List<Order>) {
        println("<주문 메뉴>")
        orderMenuInput.forEach { order ->
            println(String.format("%s %d개", order.name, order.num))
        }
    }

    fun printTotalOriginPrice(orderMenuInput: MutableList<Order>) {
        println("<할인 전 총주문 금액>")
        println(String.format("%,d원", discount.getTotalPrice(orderMenuInput)))
    }

    fun printGiftMessage(orderMenuInput: MutableList<Order>) {
        println("<증정 메뉴>")
        if (discount.getChampagne(orderMenuInput) > 0) println("샴페인 1개")
        else println("없음")
    }

    fun showFinalPaymentDetails(date: Int, orderList: MutableList<Order>) {
//        - 고객에게 적용된 이벤트 내역만 보여 주세요.
//            크리스마스 디데이 할인: -1,200원
//            평일 할인: -4,046원
//            특별 할인: -1,000원
//            증정 이벤트: -25,000원
//        - 적용된 이벤트가 하나도 없다면 혜택 내역 "없음"으로 보여 주세요.
//        - 혜택 내역에 여러 개의 이벤트가 적용된 경우, 출력 순서는 자유롭게 출력해주세요. =>set 구조(순서가 있는 구조는 list)
        val christmasDiscount = discount.christmasDiscount(date)
        val weekendDiscount = discount.weekendDiscount(date, orderList)
        val weekDayDiscount = discount.weekDayDiscount(date, orderList)
        val specialDayDiscount = discount.specialDayDiscount(date)
        val getChampagne = discount.getChampagne(orderList)

        val benefits = mutableSetOf<String>()
        if (christmasDiscount != 0) benefits.add("크리스마스 디데이 할인: -${String.format("%,d", christmasDiscount)}원")
        if (weekendDiscount != 0) benefits.add("주말 할인: -${String.format("%,d", weekendDiscount)}원")
        if (weekDayDiscount != 0) benefits.add("평일 할인 -${String.format("%,d", weekDayDiscount)}원")
        if (specialDayDiscount != 0) benefits.add("특별 할인 -${String.format("%,d", specialDayDiscount)}원")
        if (getChampagne != 0) benefits.add("증정 이벤트 -${String.format("%,d", getChampagne)}원")

        println("<혜택 내역>")
        if (benefits.isEmpty()) println("없음")
        else println(benefits.joinToString("\n"))

        println("<총혜택 금액>")
        val totalBenefitAmount =
            christmasDiscount + weekendDiscount + weekDayDiscount + specialDayDiscount + getChampagne
        println(String.format("%,d원",totalBenefitAmount*-1))

        println("<할인 후 예상 결제 금액>")
        println(String.format("%,d원",discount.getTotalPrice(orderList)-totalBenefitAmount+getChampagne))

        println("<12월 이벤트 배지>")
        println(Badge.getBadge(totalBenefitAmount).type)
    }
}