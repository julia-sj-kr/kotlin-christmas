package christmas

//- 총혜택 금액에 따라 다른 이벤트 배지를 부여합니다. 이 배지는 2024 새해 이벤트에서 활용할 예정입니다.
//배지에 따라 새해 이벤트 참여 시, 각각 다른 새해 선물을 증정할 예정입니다.
//- 5천 원 이상: 별
//- 1만 원 이상: 트리
//- 2만 원 이상: 산타

enum class Badge(val type: String) {
    NON("없음"),
    STAR("별"),
    TREE("트리"),
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