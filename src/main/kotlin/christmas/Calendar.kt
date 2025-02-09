package christmas

class Calendar {
    val days = (1..31).toList() //반환 타입 List<Int>
    //val days = listOf(1..31) //반환 타입 List<IntRange>

//    금,토 : days를 나누기 했을때 나머지가 0 또는 1
//    일,월,화,수,목: days를 나누기 했을때 나머지가 2 이상 6 이하

    fun sortWeekend(day: Int): Boolean {
        return day % 7 == 0 || day % 7 == 1 //true이면 주말, false이면 평일
    }

    fun checkSpecialDays(day: Int): Boolean {
        return day % 7 == 2 || day == 25
    }
}