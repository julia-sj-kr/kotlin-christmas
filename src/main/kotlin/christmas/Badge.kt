package christmas

enum class Badge(val type: String) {
    NON(""),
    STAR("별"),
    TREE("나무"),
    SANTA("산타");

    companion object {
        fun getBadge(eventPrice: Int): Badge {
            when {
                eventPrice >= 20_000 -> return SANTA
                eventPrice >= 10_000 -> return TREE
                eventPrice >= 5_000 -> return STAR
            }
            return NON
        }
    }
}