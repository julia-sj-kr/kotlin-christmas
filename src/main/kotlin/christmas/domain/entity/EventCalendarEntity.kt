package christmas.domain.entity

import christmas.presentation.model.DateModel

class EventCalendarEntity {
    val dates = List(ONE_MONTH) { index ->
        val day = index + INDEX_TO_DATE_NUMBER
        createDateModel(day)
    }

    private fun createDateModel(day: Int) = DateModel(day, isWeekend(day), hasStar(day))

    private fun isWeekend(day: Int) = day % ONE_WEEK == START_FRIDAY || day % ONE_WEEK == START_SATURDAY

    private fun hasStar(day: Int) = day % ONE_WEEK == START_SUNDAY || day == CHRISTMAS_DATE

    companion object{
        const val ONE_WEEK = 7
        const val START_FRIDAY = 1
        const val START_SATURDAY = 2
        const val START_SUNDAY = 3
        const val CHRISTMAS_DATE = 25
        const val ONE_MONTH = 31
        const val INDEX_TO_DATE_NUMBER = 1
    }
}