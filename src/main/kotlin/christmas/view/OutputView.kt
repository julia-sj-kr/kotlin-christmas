package christmas.view

import christmas.domain.model.Menu

class OutputView {

    fun introduce(){
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
    }

  fun showOrderMenus(menus: List<Menu>){
      println("<주문 메뉴>")
      menus.forEach { menu ->
          println("${menu.name} ${menu.count}개")
      }
  }

}