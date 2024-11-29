package christmas

import christmas.Menu

enum class MenuType(val menus: List<Menu>) {
    APPETIZER(listOf(Menu.BUTTON_MUSHROOM_SOUP, Menu.TAPAS, Menu.CAESAR_SALAD)),
    MAIN(listOf(Menu.T_BONE_STEAK, Menu.BARBECUE_RIBS, Menu.SEAFOOD_PASTA, Menu.CHRISTMAS_PASTA)),
    DESSERT(listOf(Menu.CHOCOLATE_CAKE, Menu.ICE_CREAM)),
    DRINK(listOf(Menu.ZERO_COLA, Menu.RED_WINE, Menu.CHAMPAGNE))
}