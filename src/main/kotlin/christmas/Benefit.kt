package christmas

data class BenefitDiscount(val dDay: Int, val weekDay: Int, val holiday: Int, val special: Int, val apply: Int) {
    fun totalBenefit() = this.dDay + this.weekDay + this.holiday + this.special + this.apply

    fun totalDiscount() = this.dDay + this.weekDay + this.holiday + this.special
}