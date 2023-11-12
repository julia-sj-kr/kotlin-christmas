package christmas.enum


enum class MenuRole(val menu: String, val type: String, val price: Int) {
    T_BONE_STEAK("티본스테이크", "메인", 55_000),
    BARBECUE_RIBS("바비큐립", "메인", 54_000),
    SEAFOOD_PASTA("해산물파스타", "메인", 25_000),
    CHRISTMAS_PASTA("크리스마스파스타", "메인", 25_000),
    BUTTON_MUSHROOM_SOUP("양송이스프", "에피타이저", 6_000),
    TAPAS("타파스", "에피타이저", 5_500),
    CAESAR_SALAD("시저샐러드", "에피타이저", 8_000),
    CHOCOLATE_CAKE("초코케이크", "디저트", 15_000),
    ICE_CREAM("아이스크림", "디저트", 5_000),
    ZERO_COLA("제로콜라", "음료", 3_000),
    RED_WINE("레드와인", "음료", 60_000),
    CHAMPAGNE("샴페인", "음료", 25_000)
}