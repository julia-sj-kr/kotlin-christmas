package christmas

enum class Calendar(val startDayOfWeekIndex: Int, val days: List<Int>) {
    DECEMBER(4, (1..31).toList());

    companion object {
        fun isWeekDay(day: Int): Boolean {
            val dayOfWeekIndex = DECEMBER.startDayOfWeekIndex + day -1
            return dayOfWeekIndex % 7 in 0..4
        }

        fun isSpecialDay(day: Int): Boolean {
            val dayOfWeekIndex = DECEMBER.startDayOfWeekIndex + day -1
            return dayOfWeekIndex % 7 == 6 || day == 25
        }
    }
}