package christmas.domain.entity

import christmas.enum.MenuRole
import christmas.presentation.model.MenuModel
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class OrderTest {

    lateinit var order: OrderEntity

    @BeforeEach
    fun `setUp`() {
        val tBoneStake = MenuRole.TBoneSteak
        val barbecueRibs = MenuRole.BarbecueRibs
        order = OrderEntity(
            listOf(
                MenuModel(name = tBoneStake.menu, tBoneStake.type, tBoneStake.price, 2),
                MenuModel(name = barbecueRibs.menu, barbecueRibs.type, barbecueRibs.price, 1)
            )
        )
    }

    @Test
    fun `주문 가격이 164_000원이 아닐 경우 오류 발생`() {
        val expected = 164_000
        assertEquals(expected, order.getTotalPrice())
    }
}