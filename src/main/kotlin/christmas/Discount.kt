package christmas

import christmas.MenuBoard.category
import christmas.MenuBoard.menuItems
import java.awt.Menu

class Discount {
//    크리스마스 디데이 할인
//    이벤트 기간: 2023.12.1 ~ 2023.12.25
//    1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
//    총주문 금액에서 해당 금액만큼 할인
//    (e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인)
//
//    평일 할인(일요일~목요일): 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인
//
//    주말 할인(금요일, 토요일): 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
//
//    특별 할인: 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
//
//    증정 이벤트: 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정
//
//    이벤트 기간: '크리스마스 디데이 할인'을 제외한 다른 이벤트는 2023.12.1 ~ 2023.12.31 동안 적용


    fun christmasDiscount(date: Int): Int {
        return if (date in 1..25) 1000 + 100 * (date - 1)
        else 0
    }

    fun weekDayDiscount(date: Int, orderList: MutableList<Order>): Int {
        var dessertDiscount: Int = 0
        ////true이면 주말, false이면 평일
        if (!Calendar().sortWeekend(date)) {
            orderList.forEach { order ->
                val category = MenuBoard.category
                if (category["디저트"]?.contains(order.name) == true) {
                    dessertDiscount += 2023 * order.num
                }
            }
        }
        return dessertDiscount
    }

    //함수형 스타일
    fun weekendDiscount(date: Int, orderList: MutableList<Order>): Int {
        var mainDiscount: Int = 0
        if (Calendar().sortWeekend(date)) {
            mainDiscount = orderList.filter { order -> category["메인"]?.contains(order.name) == true }.sumOf { it.num*2023 }
        }
        return mainDiscount
    }

    fun specialDayDiscount(date: Int): Int {
        return if (Calendar().checkSpecialDays(date)) 1000
        else 0
    }

    fun getTotalPrice(orderList: MutableList<Order>): Int {
        return orderList.sumOf { order ->
            menuItems[order.name]!! * order.num
        }
    }

    fun getChampagne(orderList: MutableList<Order>): Int {
        val totalPrice = getTotalPrice(orderList)

        if (totalPrice > 120000) {
            orderList.add(Order("샴페인", 1))
            return menuItems["샴페인"]!!
        } else return 0
    }
}


