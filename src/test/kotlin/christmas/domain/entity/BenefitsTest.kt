package christmas.domain.entity

import christmas.enum.MenuRole
import christmas.presentation.model.DateModel
import christmas.presentation.model.MenuModel
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BenefitsTest {
    lateinit var benefits: BenefitsEntity

    @BeforeEach
    fun `setUp`() {
        val tBoneStake = MenuRole.T_BONE_STEAK
        val iceCream = MenuRole.ICE_CREAM
        val date = DateModel(3, isWeekend = false, hasStar = true)
        val order = OrderEntity(
            listOf(
                MenuModel(name = tBoneStake.menu, tBoneStake.type, tBoneStake.price, 1),
                MenuModel(name = iceCream.menu, iceCream.type, iceCream.price, 2)
            )
        )
        benefits = BenefitsEntity(date, order)
    }

    @Test
    fun `크리스마스 디 데이 할인 가격이 1,200원이 아닐 경우에 오류가 발생 한다`() {
        val expected = 1200
        val dDayDiscount = benefits.discounts.find { discount -> discount.name == "크리스마스 디 데이 할인" }?.price ?: 0
        assertEquals(expected, dDayDiscount)
    }

    @Test
    fun `평일 할인 가격이 4,046원이 아닐 경우에 오류가 발생 한다`() {
        val expected = 4_046
        val weekDayDiscount = benefits.discounts.find { discount -> discount.name == "평일 할인" }?.price ?: 0
        assertEquals(expected, weekDayDiscount)
    }

    @Test
    fun `주말 할인 가격이 0원이 아닐 경우에 오류가 발생 한다`() {
        val expected = 0
        val weekendDiscount = benefits.discounts.find { discount -> discount.name == "주말 할인" }?.price ?: 0
        assertEquals(expected, weekendDiscount)
    }

    @Test
    fun `특별 할인 가격이 1000원이 아닐 경우에 오류가 발생 한다`() {
        val expected = 1000
        val weekendDiscount = benefits.discounts.find { discount -> discount.name == "특별 할인" }?.price ?: 0
        assertEquals(expected, weekendDiscount)
    }

    @Test
    fun `총 할인 가격이 5046원이 아닐 경우에 오류가 발생 한다`() {
        val expected = 5046
        val totalDiscount = benefits.totalDiscountPrice()
        assertEquals(expected, totalDiscount)
    }

    @Test
    fun `무료 메뉴에 샴페인이 포함된다면 오류가 발생 한다`() {
        assert(benefits.freeMenus.find { menu -> menu.name == "샴페인" } == null)
    }

    @Test
    fun `메뉴가 만원이 넘지 않을 경우에 할인 내역이 생기면 오류가 발생 한다`() {
        val tapas = MenuRole.TAPAS
        val order = OrderEntity(listOf(MenuModel(name = tapas.menu, tapas.type, tapas.price, 1)))
        val date = EventCalendarEntity().dates[4]
        benefits = BenefitsEntity(date, order)
        assert(benefits.discounts.isEmpty())
    }

}