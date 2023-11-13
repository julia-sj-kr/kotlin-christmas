package christmas.enum

enum class BadgeRole(val badge: String, val minBenefitsPrice: Int) {
    SANTA("산타", 20_000),
    TREE("나무", 10_000),
    STAR("별", 5_000)
}