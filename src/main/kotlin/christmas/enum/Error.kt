package christmas.enum

enum class Error(val message: String) {
    DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    NO_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_COUNT("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_FORM("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    DUPLICATE_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ONLY_BEVERAGE("[ERROR] 음료만 시키실 수 없습니다. 다시 입력해 주세요."),
    OVER_MENU_COUNT("[ERROR] 메뉴는 최대 20개까지만 시킬 수 있습니다. 다시 입력해 주세요.")
}