package christmas.domain.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BenefitsTest {
    lateinit var benefits: Benefits
    @BeforeEach
    fun `setUp`(){
        benefits = Benefits()
    }

    @Test
    fun `크리스마스 디 데이 할인 가격이 1,200원이 아닐 경우에 에러가 발생 한다`(){
        val expected = 1200
        val discount = benefits.DDayDiscountPrice(Date(3, isWeekend = false, hasStar = true))
        assertEquals(expected,discount)
    }
}