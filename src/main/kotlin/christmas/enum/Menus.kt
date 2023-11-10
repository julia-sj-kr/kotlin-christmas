package christmas.enum


enum class Main(val menu: String, val type: String, val price: Int) {
    TBoneSteak("티본스테이크", "메인", 55_000),
    BarbecueRibs("바비큐립", "메인", 54_000),
    SeafoodPasta("해산물파스타", "메인", 25_000),
    ChristmasPasta("크리스마스파스타", "메인", 25_000)
}

enum class Appetizer(val menu: String, val type: String, val price: Int) {
    ButtonMushroomSoup("양송이 스프", "에피타이저", 6_000),
    Tapas("타파스", "에피타이저", 5_500),
    CaesarSalad("시저샐러드", "에피타이저", 8_000),
}

enum class Dessert(val menu: String, val type: String, val price: Int) {
    ChocolateCake("초코케이크", "디저트", 15_000),
    IceCream("아이스크림", "디저트", 5_000),
}

enum class Beverage(val menu: String, val type: String, val price: Int) {
    ZeroCola("제로콜라", "음료", 3_000),
    RedWine("레드와인", "음료", 60_000),
    Champagne("샴페인", "음료", 25_000),
}