package christmas.domain.model

import christmas.enum.Dessert
import christmas.enum.Main
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BenefitsTest {
    lateinit var benefits: Benefits

    @BeforeEach
    fun `setUp`() {
        val tBoneStake = Main.TBoneSteak
        val iceCream = Dessert.IceCream
        val date = Date(3, isWeekend = false, hasStar = true)
        val order = Order(
            listOf(
                Menu(name = tBoneStake.name, tBoneStake.type, tBoneStake.price, 1),
                Menu(name = iceCream.name, iceCream.type, iceCream.price, 2)
            )
        )
        benefits = Benefits(date, order)
    }

    @Test
    fun `크리스마스 디 데이 할인 가격이 1,200원이 아닐 경우에 에러가 발생 한다`() {
        val expected = 1200
        val dDayDiscount = benefits.discounts.find { discount -> discount.name == "크리스마스 디 데이 할인" }?.price ?: 0
        assertEquals(expected, dDayDiscount)
    }

    @Test
    fun `평일 할인 가격이 4,046원이 아닐 경우에 에러가 발생 한다`() {
        val expected = 4_046
        val weekDayDiscount = benefits.discounts.find { discount -> discount.name == "평일 할인" }?.price ?: 0
        assertEquals(expected, weekDayDiscount)
    }

    @Test
    fun `주말 할인 가격이 0원이 아닐 경우에 에러가 발생 한다`() {
        val expected = 0
        val weekendDiscount = benefits.discounts.find { discount -> discount.name == "주말 할인" }?.price ?: 0
        assertEquals(expected, weekendDiscount)
    }

    @Test
    fun `특별 할인 가격이 1000원이 아닐 경우에 에러가 발생 한다`() {
        val expected = 1000
        val weekendDiscount = benefits.discounts.find { discount -> discount.name == "특별 할인" }?.price ?: 0
        assertEquals(expected, weekendDiscount)
    }

}