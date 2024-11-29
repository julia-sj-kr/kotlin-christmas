package christmas

import christmas.Menu

enum class MenuType(val menus: List<Menu>) {
    APPETIZER(listOf(Menu.BUTTON_MUSHROOM_SOUP, Menu.TAPAS, Menu.CAESAR_SALAD)),
    MAIN(listOf(Menu.T_BONE_STEAK, Menu.BARBECUE_RIBS, Menu.SEAFOOD_PASTA, Menu.CHRISTMAS_PASTA)),
    DESSERT(listOf(Menu.CHOCOLATE_CAKE, Menu.ICE_CREAM)),
    DRINK(listOf(Menu.ZERO_COLA, Menu.RED_WINE, Menu.CHAMPAGNE));

    companion object {
        fun convertMenuType(menu: Menu): MenuType {
            return requireNotNull(MenuType.entries.find { it.menus.contains(menu) }) { "[ERROR] 메뉴 종류에서 찾을 수 없습니다!" }
        }
    }
}