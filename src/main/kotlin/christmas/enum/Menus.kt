package christmas.enum


enum class Main(val menu: String, val price: Int) {
    TBoneSteak("티본스테이크", 55_000),
    BarbecueRibs("바비큐립", 54_000),
    SeafoodPasta("해산물파스타", 25_000),
    ChristmasPasta("크리스마스파스타", 25_000)
}

enum class Appetizer(val menu: String, val price: Int) {
    ButtonMushroomSoup("티본스테이크", 6_000),
    Tapas("타파스", 5_500),
    CaesarSalad("해산물파스타", 8_000),
}

enum class Dessert(val menu: String, val price: Int) {
    ChocolateCake("초코케이크", 15_000),
    IceCream("아이스크림", 5_000),
}

enum class Beverage(val menu: String, val price: Int) {
    ZeroCola("제로콜라", 3_000),
    RedWine("레드와인", 60_000),
    Champagne("해산물파스타", 25_000),
}