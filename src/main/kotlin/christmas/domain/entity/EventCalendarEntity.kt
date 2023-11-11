package christmas.domain.entity

import christmas.presentation.model.DateModel

class EventCalendarEntity {
    val dates = List(30) { index ->
        val day = index + 1
        return@List when {
            isWeekend(day) -> DateModel(day, isWeekend = true, hasStar = false)
            hasStar(day) -> DateModel(day, isWeekend = false, hasStar = true)
            else -> DateModel(day, isWeekend = false, hasStar = false)
        }
    }

    private fun isWeekend(day: Int) = day % 7 == 1 || day % 7 == 2

    private fun hasStar(day: Int) = day % 7 == 3 || day == 25
}