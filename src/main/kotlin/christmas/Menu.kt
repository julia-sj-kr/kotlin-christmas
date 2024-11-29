package christmas

enum class Menu(val menu: String, val price: Int, val menuType: MenuType) {
    BUTTON_MUSHROOM_SOUP("양송이스프", 6_000, MenuType.APPETIZER),
    TAPAS("타파스", 5_500, MenuType.APPETIZER),
    CAESAR_SALAD("시저 샐러드", 8_000, MenuType.APPETIZER),
    T_BONE_STEAK("티본 스테이크", 55_000, MenuType.MAIN),
    BARBECUE_RIBS("바베큐 립", 54_000, MenuType.MAIN),
    SEAFOOD_PASTA("해산물 파스타", 35_000, MenuType.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, MenuType.MAIN),
    CHOCOLATE_CAKE("초코케이크", 15_000, MenuType.DESSERT),
    ICE_CREAM("아이스크림", 5_000, MenuType.DESSERT),
    ZERO_COLA("제로콜라", 3_000, MenuType.DRINK),
    RED_WINE("레드와인", 60_000, MenuType.DRINK),
    CHAMPAGNE("샴페인", 25_000, MenuType.DRINK)
}