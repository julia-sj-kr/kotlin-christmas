package christmas.domain.entity

class BadgeEntity(private val benefitsPrice: Int) {
    private val type = when {
        benefitsPrice >= 20_000 -> "산타"
        benefitsPrice >= 10_000 -> "트리"
        benefitsPrice >= 5_000 -> "별"
        else -> "없음"
    }

    fun getType() = type

}