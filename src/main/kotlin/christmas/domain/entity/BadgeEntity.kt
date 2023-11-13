package christmas.domain.entity

import christmas.enum.BadgeRole

class BadgeEntity(private val benefitsPrice: Int) {
    private val type = when {
        benefitsPrice >= BadgeRole.SANTA.minBenefitsPrice -> BadgeRole.SANTA.badge
        benefitsPrice >= BadgeRole.TREE.minBenefitsPrice -> BadgeRole.TREE.badge
        benefitsPrice >= BadgeRole.STAR.minBenefitsPrice -> BadgeRole.STAR.badge
        else -> "없음"
    }

    fun getType() = type

}