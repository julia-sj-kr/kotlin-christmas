package christmas.domain.model

class Benefits {

    fun DDayDiscountPrice(date: Date): Int {
        if (date.day > 25) return 0
        return 1000 + (date.day-1) * 100
    }

}