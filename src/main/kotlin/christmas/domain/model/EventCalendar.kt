package christmas.domain.model

class EventCalendar {
    val dates = List(30) { index ->
        val day = index + 1
        return@List when {
            isWeekend(day) -> Date(day, isWeekend = true, hasStar = false)
            hasStar(day) -> Date(day, isWeekend = false, hasStar = true)
            else -> Date(day, isWeekend = false, hasStar = false)
        }
    }

    private fun isWeekend(day: Int) = day % 7 == 1 || day % 7 == 2

    private fun hasStar(day: Int) = day % 7 == 3
}