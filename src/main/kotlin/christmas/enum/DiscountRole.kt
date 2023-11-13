package christmas.enum

enum class DiscountRole(val type:String,val price:Int) {
    CHRISTMAS_D_DAY("크리스마스 디 데이 할인",1000),
    WEEKDAY("평일 할인",2023),
    WEEKEND("주말 할인",2023),
    SPECIAL("특별 할인",1000),
}