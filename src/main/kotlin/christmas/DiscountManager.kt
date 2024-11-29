package christmas

//- 크리스마스 디데이 할인
//    - 이벤트 기간: 2023.12.1 ~ 2023.12.25
//    - 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
//    - 총주문 금액에서 해당 금액만큼 할인
//      (e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인)
//- 평일 할인(일요일~목요일): 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인
//- 주말 할인(금요일, 토요일): 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
//- 특별 할인: 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
//- 증정 이벤트: 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정
//- 이벤트 기간: '크리스마스 디데이 할인'을 제외한 다른 이벤트는 2023.12.1 ~ 2023.12.31 동안 적용
class DiscountManager() {
    fun christmasDDAYDiscount(day: Int): Int {
        var discount = 3400
        repeat(25 - day) {
            discount -= 100
        }
        return discount.coerceAtLeast(0)
    }

    fun weekDayDiscount(orderMenus: List<OrderMenu>): Int {
        val dessertCount =
            orderMenus.count { orderMenu -> MenuType.convertMenuType(orderMenu.menu) == MenuType.DESSERT }
        return dessertCount * 2023
    }

    fun holidayDiscount(orderMenus: List<OrderMenu>): Int {
        val mainCount = orderMenus.count { orderMenu -> MenuType.convertMenuType(orderMenu.menu) == MenuType.MAIN }
        return mainCount * 2023
    }

    fun isApplyChampagne(totalOrderPrice: Int) = totalOrderPrice >= 120_000
}