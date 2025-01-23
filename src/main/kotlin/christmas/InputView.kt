package christmas

class InputView {
    fun readDate(): Int {
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
        //scanner, BufferedReader
        //val input = Console.readLine()
        while (true){
            try {
                val input = readln()
                return input.toInt()
            }catch (e:NumberFormatException){
                println("잘못된 입력입니다. 숫자를 입력해 주세요.")
            }
        }
    }

    fun readMenu(): String{
        println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")
        val orderMenu = readln()
        return orderMenu
    }
}

//require 메서드는 조건을 검증하고 조건이 만족되지 않을 경우 예외를 발생시키는 유용한 도구입니다.
//하지만 require는 보통 단일 조건을 검증하는 데 사용되며, 반복적으로 입력을 요청하는 데는 적합하지 않습니다.