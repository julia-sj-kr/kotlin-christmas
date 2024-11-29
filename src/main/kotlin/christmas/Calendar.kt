package christmas

enum class Calendar(startDayOfWeekIndex: Int, days: List<Int>) {
    DECEMBER(4, (1..31).toList());

    companion object {
        fun isWeekDay(day: Int): Boolean {
            return day % 7 in 0..4
        }

        fun isSpecialDay(day: Int): Boolean {
            return day % 7 == 6 || day == 25
        }
    }
}