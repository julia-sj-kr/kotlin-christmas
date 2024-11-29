package christmas

enum class Discount(val title: String, val price: Int = 0) {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인"),
    WEEK_DAY("평일 할인", 2023),
    HOLIDAY("주말 할인", 2023),
    SPECIAL("특별 이벤트", 1000),
    APPLY("증정 이벤트", 25_000)
}