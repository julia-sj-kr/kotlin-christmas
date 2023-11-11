package christmas.domain.entity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BadgeTest {
    lateinit var badge: Badge

    @BeforeEach
    fun `setUp`(){
        badge = Badge(6000)
    }

    @Test
    fun `뱃지가 별이 아니라면 오류가 발생 한다`(){
        assertEquals(badge.getType() ,"별")
    }
}