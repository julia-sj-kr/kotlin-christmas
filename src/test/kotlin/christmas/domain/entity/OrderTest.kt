package christmas.domain.entity

import christmas.enum.MenuRole
import christmas.presentation.model.MenuModel
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class OrderTest {

    private lateinit var order: OrderEntity

    @BeforeEach
    fun `setUp`() {
        val tBoneStake = MenuRole.T_BONE_STEAK
        val barbecueRibs = MenuRole.BARBECUE_RIBS
        order = OrderEntity(
            listOf(
                MenuModel(name = tBoneStake.menu, tBoneStake.type, tBoneStake.price, 2),
                MenuModel(name = barbecueRibs.menu, barbecueRibs.type, barbecueRibs.price, 1)
            )
        )
    }

    @Test
    fun `주문 가격이 164_000원이 아닐 경우 오류가 발생 한다`() {
        val expected = 164_000
        assertEquals(expected, order.getTotalPrice())
    }

    @ValueSource(ints = [21,232,23])
    @ParameterizedTest
    fun `주문 개수가 20개 이상일 경우 오류가 발생 한다`(menuCount:Int){
        val tBoneStake = MenuRole.T_BONE_STEAK
        assertThrows<IllegalArgumentException> {
            OrderEntity(listOf(MenuModel(name = tBoneStake.menu, tBoneStake.type, tBoneStake.price, menuCount)))
        }
    }
    @Test
    fun `음료만 시킬 경우에 오류가 발생 한다`(){
        val champagne = MenuRole.CHAMPAGNE
        val zeroCola = MenuRole.ZERO_COLA
        assertThrows<IllegalArgumentException> {
            OrderEntity(
                listOf(
                    MenuModel(name = champagne.menu, champagne.type, champagne.price, 2),
                    MenuModel(name = zeroCola.menu,zeroCola.type,zeroCola.price,1)
                    ))
        }
    }
}