package christmas.domain.entity

import christmas.presentation.model.DateModel

class EventCalendarEntity {
    val dates = List(30) { index ->
        val day = index + 1
        createDateModel(day)
    }

    private fun createDateModel(day: Int) = DateModel(day, isWeekend(day), hasStar(day))

    private fun isWeekend(day: Int) = day % 7 == 1 || day % 7 == 2

    private fun hasStar(day: Int) = day % 7 == 3 || day == 25
}